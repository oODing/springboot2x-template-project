package cn.ding.template.backend.common.exception;

/**
 * @author ding
 */
public class ExceptionFactory {

    public static BizException bizException(ExceptionEnum exceptionEnum) {
        return new BizException(exceptionEnum.getCode(), exceptionEnum.getMsg());
    }

    public static BizException bizException(String errorMessage) {
        return new BizException(errorMessage);
    }

    public static BizException bizException(String errorCode, String errorMessage) {
        return new BizException(errorCode, errorMessage);
    }

    public static SysException sysException(ExceptionEnum exceptionEnum) {
        return new SysException(exceptionEnum.getCode(), exceptionEnum.getMsg());
    }

    public static SysException sysException(String errorMessage) {
        return new SysException(errorMessage);
    }

    public static SysException sysException(String errorCode, String errorMessage) {
        return new SysException(errorCode, errorMessage);
    }

    public static SysException sysException(String errorMessage, Throwable e) {
        return new SysException(errorMessage, e);
    }

    public static SysException sysException(String errorCode, String errorMessage, Throwable e) {
        return new SysException(errorCode, errorMessage, e);
    }

}
