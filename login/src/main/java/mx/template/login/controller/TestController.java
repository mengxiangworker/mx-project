package mx.template.login.controller;

import lombok.extern.slf4j.Slf4j;
import mx.template.login.entity.User;
import mx.template.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author peidong.meng
 * @date 2019/5/18
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> test(){

        log.debug("获取所有用户。。。");
        return userService.list();
    }
}
