package mx.template.login.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peidong.meng
 * @date 2019/5/18
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {


    @GetMapping("/1")
    public void test(){

        log.debug("-------");
    }
}
