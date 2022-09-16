package cn.ding.template.backend.api.user.query;


/**
 * 用户查询接口
 *
 * @author ding
 */
public interface UserQueryI {

    /**
     * 获取用户名
     *
     * @param id
     * @return
     */
    String getUserName(Long id);

}
