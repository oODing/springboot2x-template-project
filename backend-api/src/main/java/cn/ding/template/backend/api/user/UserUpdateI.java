package cn.ding.template.backend.api.user;


import cn.ding.template.backend.api.dto.user.UserUpdateDTO;

/**
 * 用户更新
 *
 * @author ding
 */
public interface UserUpdateI {

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    UserUpdateDTO addUser(UserUpdateDTO user);

}
