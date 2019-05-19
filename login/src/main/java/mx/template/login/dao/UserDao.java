package mx.template.login.dao;

import mx.template.login.entity.User;

import java.util.List;

/**
 * @author peidong.meng
 * @date 2019/5/18
 */
public interface UserDao {

    List<User> selectAll();
}
