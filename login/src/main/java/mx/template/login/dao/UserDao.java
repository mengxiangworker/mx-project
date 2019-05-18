package mx.template.login.dao;

import mx.template.login.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author peidong.meng
 * @date 2019/5/18
 */
@Mapper
public interface UserDao {

    List<User> selectAll();
}
