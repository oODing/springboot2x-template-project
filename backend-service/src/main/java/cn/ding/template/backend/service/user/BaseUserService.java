package cn.ding.template.backend.service.user;

import cn.ding.template.backend.api.dto.user.UserUpdateDTO;
import cn.ding.template.backend.dao.database.dataobject.UserDO;
import org.springframework.cglib.beans.BeanCopier;

/**
 * 存放 userService基础的功能， 如dto转换成do
 *
 * @author: ding
 */
public abstract class BaseUserService {

    private static final BeanCopier COPIER = BeanCopier.create(UserUpdateDTO.class, UserDO.class, false);

    protected UserDO toDataObjectForCreate(UserUpdateDTO user) {
        UserDO userDO = new UserDO();
        COPIER.copy(user, userDO, null);
        return userDO;
    }

}
