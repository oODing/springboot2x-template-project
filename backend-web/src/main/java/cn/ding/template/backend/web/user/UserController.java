package cn.ding.template.backend.web.user;


import cn.ding.template.backend.api.dto.user.UserUpdateDTO;
import cn.ding.template.backend.api.dto.user.query.UserIdQueryDTO;
import cn.ding.template.backend.api.user.UserUpdateI;
import cn.ding.template.backend.api.user.query.UserQueryI;
import cn.ding.template.backend.service.catchlog.CatchAndLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author ding
 */
@Component
@RestController
public class UserController {

    @Autowired
    private UserQueryI userQueryI;
    @Autowired
    private UserUpdateI userUpdateI;

    @CatchAndLog
    @GetMapping("/username")
    public String getUserName(@RequestParam("id") Long id) {
        System.out.println(id);
        return userQueryI.getUserName(id);
    }

    @PostMapping("/username2")
    public String getUserName2(@RequestBody UserIdQueryDTO user) {
        System.out.println(user.getId());
        return userQueryI.getUserName(user.getId());
    }

    @RequestMapping("/add")
    public UserUpdateDTO addUser(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        UserUpdateDTO user = new UserUpdateDTO();
        user.setName(name);
        user.setAge(age);
        return userUpdateI.addUser(user);
    }

}
