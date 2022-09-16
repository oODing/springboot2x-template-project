package cn.ding.template.backend.web.response;

import cn.ding.template.backend.api.dto.base.Response;
import cn.ding.template.backend.common.exception.BizException;
import cn.ding.template.backend.common.exception.ExceptionEnum;
import cn.ding.template.backend.common.exception.SysException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author: ding
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerConfig {

    /**
     * 业务异常处理
     *
     * @param e 业务异常
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public Response exceptionHandler(BizException e) {
        log.error(e.getMessage());

        return Response.buildFailure(e.getErrCode(), e.getMessage());
    }

    /**
     * 请求路径不存在的处理
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseBody
    public Response exceptionHandler(NoHandlerFoundException e) {
        // 把错误信息输入到日志中
        log.error(e.getMessage());
        return Response.buildFailure(ExceptionEnum.NOT_FOUND.getCode(),
                ExceptionEnum.NOT_FOUND.getMsg());
    }

    /**
     * 未知异常处理
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response exceptionHandler(Exception e) {
        // 把错误信息输入到日志中
        log.error(e.getMessage());
        return Response.buildFailure(ExceptionEnum.UNKNOWN.getCode(),
                ExceptionEnum.UNKNOWN.getMsg());
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(value = SysException.class)
    @ResponseBody
    public Response exceptionHandler(SysException e) {
        log.error(e.getMessage());
        return Response.buildFailure(ExceptionEnum.INTERNAL_SERVER_ERROR.getCode(),
                ExceptionEnum.INTERNAL_SERVER_ERROR.getMsg());
    }

    /**
     * 空指针异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public Response exceptionHandler(NullPointerException e) {
        log.error(e.getMessage());
        return Response.buildFailure(ExceptionEnum.NULL_POINT.getCode(),
                ExceptionEnum.NULL_POINT.getMsg());
    }

}
