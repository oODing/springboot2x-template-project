package cn.ding.template.backend.service.user;

import cn.ding.template.backend.api.dto.user.UserUpdateDTO;
import cn.ding.template.backend.api.user.UserUpdateI;
import cn.ding.template.backend.dao.database.dataobject.UserDO;
import cn.ding.template.backend.dao.database.mapper.UserMapper;
import cn.ding.template.backend.service.catchlog.CatchAndLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: ding
 */

@CatchAndLog
@Service
public class UserUpdateImpl extends BaseUserService implements UserUpdateI {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserUpdateDTO addUser(UserUpdateDTO user) {
        UserDO userDO = toDataObjectForCreate(user);
        int id = userMapper.insert(userDO);
        user.setId((long) id);
        return user;
    }

}
