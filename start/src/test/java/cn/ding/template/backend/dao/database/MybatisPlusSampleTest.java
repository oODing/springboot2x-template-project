package cn.ding.template.backend.dao.database;

import cn.ding.template.backend.dao.database.dataobject.UserDO;
import cn.ding.template.backend.dao.database.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author: ding
 */
//@MybatisPlusTest
@SpringBootTest()
public class MybatisPlusSampleTest {
//    @Autowired
//    DataSource dataSource;
//
//    @Test
//    void contextLoads() throws SQLException {
//        System.out.println(dataSource.getClass());
//        Connection connection = dataSource.getConnection();
//        System.out.println(connection);
//        //template模板，拿来即用
//        connection.close();
//    }

    @Resource
    private UserMapper userMapper;

    @Test
    void testInsert() {
        System.out.println(userMapper.getById(1L));
        UserDO userDO = new UserDO();
        userDO.setAge(10);
        userDO.setName("tommy");
        long userId = userMapper.insert(userDO);
        assertThat(userId).isNotNull();
    }
}
