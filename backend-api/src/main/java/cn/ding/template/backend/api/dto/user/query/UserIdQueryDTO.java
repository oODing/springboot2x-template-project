package cn.ding.template.backend.api.dto.user.query;

import cn.ding.template.backend.api.dto.base.Query;
import lombok.Data;

/**
 * @author: ding
 */
@Data
public class UserIdQueryDTO implements Query {

    private Long id;

}
