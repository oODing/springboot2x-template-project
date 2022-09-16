package cn.ding.template.backend.service.user;

import cn.ding.template.backend.api.user.query.UserQueryI;
import cn.ding.template.backend.dao.database.dataobject.UserDO;
import cn.ding.template.backend.dao.database.mapper.UserMapper;
import cn.ding.template.backend.service.catchlog.CatchAndLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ding
 */
@CatchAndLog
@Service
@Slf4j
public class UserQueryImpl extends BaseUserService implements UserQueryI {

    @Resource
    private UserMapper userMapper;

    @Override
    public String getUserName(Long id) {
        UserDO userDO = userMapper.getById(id);
        log.info("getUserName", userDO);
        return userDO != null ? userDO.getName() : null;
    }

}
