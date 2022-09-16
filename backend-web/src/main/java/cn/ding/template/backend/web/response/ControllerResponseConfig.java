package cn.ding.template.backend.web.response;

import cn.ding.template.backend.api.dto.base.Response;
import cn.ding.template.backend.api.dto.base.SingleResponse;
import cn.ding.template.backend.common.exception.ExceptionEnum;
import cn.ding.template.backend.common.exception.ExceptionFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @description: 接口出参统一处理
 * @author: ding
 */
@Slf4j
@RestControllerAdvice
public class ControllerResponseConfig implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return !methodParameter.getParameterType().isAssignableFrom(Response.class)
                || methodParameter.hasMethodAnnotation(NotControllerResponseBodyAdvice.class);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter methodParameter, MediaType mediaType, Class<?
            extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // String类型不能直接包装
        if (methodParameter.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 将数据包装在ResultVo里后转换为json串进行返回
                return objectMapper.writeValueAsString(SingleResponse.of(data));
            } catch (JsonProcessingException e) {
                throw ExceptionFactory.sysException(ExceptionEnum.CAST_ERROR);
            }
        }
        // 否则直接包装成ResultVo返回
        return SingleResponse.of(data);
    }
}
