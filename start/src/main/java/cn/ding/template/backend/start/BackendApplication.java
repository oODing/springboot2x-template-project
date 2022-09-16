package cn.ding.template.backend.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author ding
 */
@SpringBootApplication(scanBasePackages = "cn")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

}
