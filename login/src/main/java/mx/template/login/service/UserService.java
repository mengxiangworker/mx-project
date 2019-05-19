package mx.template.login.service;

import com.google.common.collect.Lists;
import mx.template.base.util.ModelEntityUtils;
import mx.template.login.dto.UserDto;
import mx.template.login.repository.UserRepository;
import mx.template.login.entity.UserEntity;
import mx.template.login.service.impl.UserServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author peidong.meng
 * @date 2019/5/18
 */
@Service
@Transactional
public class UserService implements UserServiceImpl<UserDto> {

    @Autowired
    private UserRepository userRepository;


    public int testAdd() {

        UserEntity entity = new UserEntity();
        entity.setRealName("张三");
        entity.setUserName("zhangsan");
        entity.setCreateTime(new Date());
        entity.setIdCard("0001");
        entity.setUPwd("123456");
        entity.setPhoneNumber("11111111111");
        entity.setSalt(RandomStringUtils.randomAlphabetic(4));

        userRepository.save(entity);
        return 0;
    }

    @Override
    public int save(UserDto userDto) {
        return 0;
    }

    @Override
    public int update(UserDto userDto) {
        return 0;
    }

    @Override
    public int delete(UserDto userDto) {
        return 0;
    }

    @Override
    public List<UserDto> list(){
        List<UserDto> list = Lists.newArrayList();

        List<UserEntity> users = userRepository.getAll();
        if(CollectionUtils.isNotEmpty(users)){
            users.forEach(x->{
                UserDto u = new UserDto();

                ModelEntityUtils.copyProperties(u, x);
                list.add(u);
            });
        }

        return list;
    }

    @Override
    public UserDto view(Integer id) {
        return null;
    }
}
