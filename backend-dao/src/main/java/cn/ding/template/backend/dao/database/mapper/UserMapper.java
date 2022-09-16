package cn.ding.template.backend.dao.database.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import cn.ding.template.backend.dao.database.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ding
 */
@Mapper
@Repository
@DS(value = "mysql")
public interface UserMapper /*extends BaseMapper<UserDO>*/ {

    /**
     * 获取用户信息
     *
     * @param name
     * @return
     */
    UserDO getByName(String name);

    /**
     * 获取用户信息
     *
     * @param id
     * @return
     */
    UserDO getById(Long id);

    /**
     * 插入用户信息
     *
     * @param userDO
     * @return
     */
    int insert(UserDO userDO);
}
