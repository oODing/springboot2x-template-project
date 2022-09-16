package cn.ding.template.backend.web.response;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ding
 * @description: 作用在方法上，表示不使用 ControllerResponseConfig 的统一处理
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotControllerResponseBodyAdvice {
}
