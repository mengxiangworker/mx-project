package mx.template.login.repository;

import mx.template.login.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author peidong.meng
 * @date 2019/5/18
 */
@Repository
public interface UserRepository {

    /**
     * 获取全部用户
     * @return
     */
    List<UserEntity> getAll();

    @Select("SELECT id,real_name,user_name,tx_token,phone_number,id_card,password,salt,create_time FROM user_master WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "userId"),
            @Result(property = "real_name", column = "realName"),
            @Result(property = "user_name",  column = "userName"),
            @Result(property = "tx_token", column = "txToken"),
            @Result(property = "phone_number",  column = "phoneNumber"),
            @Result(property = "id_card", column = "idCard"),
            @Result(property = "u_pwd",  column = "uPwd"),
            @Result(property = "salt", column = "salt"),
            @Result(property = "create_time", column = "createTime", javaType = Date.class)

    })
    UserEntity getOne(Integer id);

    @Insert({"INSERT INTO user_master(real_name,user_name,tx_token,phone_number,id_card,u_pwd,salt,create_time) VALUES(#{realName},#{userName},#{txToken},#{phoneNumber},#{idCard},#{uPwd},#{salt},#{createTime})"})
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "id")
    void save(UserEntity user);

    @Update("UPDATE user_master SET real_name=#{realName},user_name=#{userName},tx_token=#{txToken},phone_number=#{phoneNumber},id_card=#{idCard},u_pwd=#{uPwd},salt=#{salt},create_time=#{createTime} WHERE id =#{userId}")
    void update(UserEntity user);

    @Delete("DELETE FROM user_master WHERE id =#{id}")
    void delete(Long id);
}
