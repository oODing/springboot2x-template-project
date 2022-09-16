package cn.ding.template.backend.service.catchlog;

/**
 * @author ding
 */
public interface ResponseHandlerI {
    /**
     * 响应处理
     *
     * @param returnType 返回类型
     * @param errCode    错误编码
     * @param errMsg     错误信息
     * @return
     */
    Object handle(Class returnType, String errCode, String errMsg);
}
