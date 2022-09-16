package cn.ding.template.backend.dao.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Data
@TableName("users")
public class UserDO {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;
}
