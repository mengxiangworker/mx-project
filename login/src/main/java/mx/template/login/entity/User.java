package mx.template.login.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author peidong.meng
 * @date 2019/5/18
 */
@Getter
@Setter
@ToString
public class User {

    private Integer id;
    private String userName;
    private String idCard;
    private String password;
}