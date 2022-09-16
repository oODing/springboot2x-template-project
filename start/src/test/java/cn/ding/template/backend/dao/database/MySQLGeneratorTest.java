package cn.ding.template.backend.dao.database;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import org.junit.jupiter.api.Test;

/**
 * @author: ding
 */
//@SpringBootTest
public class MySQLGeneratorTest extends BaseGeneratorTest {

//    @Value("${spring.datasource.dynamic.datasource.mysql.url}")
    static String url="jdbc:mysql://localhost:3306/testcola?useUnicode=true&characterEncoding=utf-8&serverTimezone=serverTimezone=Asia/Shanghai";
//    @Value("${spring.datasource.dynamic.datasource.mysql.username}")
    static String name="root";
//    @Value("${spring.datasource.dynamic.datasource.mysql.password}")
    static String password="123456";
    static String SCHEMA = "metric";

    /**
     * 数据源配置
     */
    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder(url, name, password)
            .schema(SCHEMA)
            .build();

    @Test
    public void testSimple() {
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        generator.strategy(strategyConfig().build());
        generator.global(globalConfig().build());
        generator.execute();
    }
}
