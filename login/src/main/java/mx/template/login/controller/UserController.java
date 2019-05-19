package mx.template.login.controller;

import lombok.extern.slf4j.Slf4j;
import mx.template.base.model.RespCode;
import mx.template.base.model.RespResult;
import mx.template.login.dto.UserDto;
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
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public RespResult<List<UserDto>> list(){
        RespResult<List<UserDto>> result = new RespResult<>(true);
        try {
            List<UserDto> list = userService.list();
            result.success(list);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            result.fail(RespCode.ERROR, e);
        }
        return result;
    }



    @GetMapping("/test/add")
    public RespResult<Integer> add(){
        RespResult<Integer> result = new RespResult<>(true);
        try {
            Integer n = userService.testAdd();
            result.success(n);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            result.fail(RespCode.ERROR, e);
        }
        return result;
    }
}
