package cn.ding.template.backend.common.dto;

import lombok.Data;

/**
 * @description: 方法调用的日志记录对象
 * @author: ding
 */
@Data
public class LogRecord implements Record {

    private static final long serialVersionUID = 1L;

    /**
     * 方法花费时间
     */
    private long time;
    /**
     * 执行方法名
     */
    private String methodName;
    /**
     * 请求数据
     */
    private Object request;
    /**
     * 响应数据
     */
    private Object response;

    /**
     * 报错信息
     */
    private Exception error;

    public LogRecord() {
    }

}
