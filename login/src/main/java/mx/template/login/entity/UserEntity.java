package mx.template.login.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author peidong.meng
 * @date 2019/5/18
 * 用户主表
 */
@Getter
@Setter
@ToString
public class UserEntity {

    /**
     * 主键
     */
    private Integer userId;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 账号
     */
    private String userName;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * QQ/WX账号
     */
    private String txToken;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 密码
     */
    private String uPwd;

    /**
     * 盐
     */
    private String salt;

    /**
     * 创建时间
     */
    private Date createTime;
}
