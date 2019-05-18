package mx.template.login.service;

import mx.template.login.dao.UserDao;
import mx.template.login.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author peidong.meng
 * @date 2019/5/18
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public List<User> list(){
        return userDao.selectAll();
    }
}
