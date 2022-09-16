package cn.ding.template.backend.service.catchlog;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import cn.ding.template.backend.common.dto.LogRecord;
import cn.ding.template.backend.common.exception.BizException;
import cn.ding.template.backend.common.exception.SysException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @ Description   :  Catching and Logging
 * @ Author        :  Frank Zhang
 * @ CreateDate    :  2020/11/09
 * @ Version       :  1.0
 * @author ding
 */
@Component
@Aspect
@Slf4j
@Order(1)
public class CatchLogAspect {

    /**
     * The syntax of pointcut : https://blog.csdn.net/zhengchao1991/article/details/53391244
     */
    @Pointcut("@within(cn.ding.template.backend.service.catchlog.CatchAndLog) && execution(public * *(..))")
    public void pointcut() {
    }

    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        LogRecord logRecord = new LogRecord();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        logRequest(joinPoint, logRecord);

        Object response = null;
        try {
            response = joinPoint.proceed();
        } catch (Throwable e) {
            response = handleException(joinPoint, e);
        } finally {
            stopWatch.stop();
            logRecord.setResponse(JSON.toJSONString(response));
            logRecord.setTime(stopWatch.getTotalTimeMillis());
//            logResponse(logRecord);
            log.debug("logRecord :{}", JSON.toJSONString(logRecord, SerializerFeature.IgnoreErrorGetter));
        }

        return response;
    }

    private Object handleException(ProceedingJoinPoint joinPoint, Throwable e) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Class returnType = ms.getReturnType();

        if (e instanceof BizException) {
            log.warn("BIZ EXCEPTION : " + e.getMessage());
            //在Debug的时候，对于BizException也打印堆栈
            if (log.isDebugEnabled()) {
                log.error(e.getMessage(), e);
            }
            return ResponseHandlerFactory.get().handle(returnType, ((BizException) e).getErrCode(), e.getMessage());
        }

        if (e instanceof SysException) {
            log.error("SYS EXCEPTION :");
            log.error(e.getMessage(), e);
            return ResponseHandlerFactory.get().handle(returnType, ((SysException) e).getErrCode(), e.getMessage());
        }

        log.error("UNKNOWN EXCEPTION :");
        log.error(e.getMessage(), e);

        return ResponseHandlerFactory.get().handle(returnType, "UNKNOWN_ERROR", e.getMessage());
    }

    /**
     * 打印响应数据
     *
     * @param logRecord 日志对象
     * @param
     */
    private void logResponse(LogRecord logRecord) {
        try {
            log.debug("RESPONSE : " + logRecord.getResponse());
            log.debug("COST : " + logRecord.getTime() + "ms");
        } catch (Exception e) {
            //swallow it
            log.error("logResponse error : " + e);
        }
    }

    /**
     * 打印请求数据
     *
     * @param joinPoint 切入点
     */
    private void logRequest(ProceedingJoinPoint joinPoint, LogRecord logRecord) {
        try {
            if (!log.isDebugEnabled()) {
                return;
            }
            logRecord.setMethodName(joinPoint.getSignature().toShortString());
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                logRecord.setRequest(JSON.toJSONString(arg, SerializerFeature.IgnoreErrorGetter));
            }
        } catch (Exception e) {
            logRecord.setError(e);
            //swallow it
            log.error("logReqeust error : " + e);
        }
    }

}
