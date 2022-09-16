package cn.ding.template.backend.web;

import cn.ding.template.backend.common.exception.ExceptionEnum;
import cn.ding.template.backend.common.exception.ExceptionFactory;
import cn.ding.template.backend.service.catchlog.CatchAndLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ding
 */
@RestController
public class IndexController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/bizE")
    public String bizE() {
        throw ExceptionFactory.bizException(ExceptionEnum.UNKNOWN);
    }

    @GetMapping("/sysE")
    public String sysE() {
        throw ExceptionFactory.sysException(ExceptionEnum.INTERNAL_SERVER_ERROR);
    }

    @CatchAndLog
    @GetMapping("/npe")
    public String npe(String id) {
        throw new NullPointerException();
    }


}
