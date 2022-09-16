package cn.ding.template.backend.api.dto.user;

import cn.ding.template.backend.api.dto.base.Command;
import lombok.Data;

/**
 * 用户信息更新DTO
 *
 * @author ding
 */
@Data
public class UserUpdateDTO implements Command {
    private Long id;

    private String name;

    private Integer age;

}