package mx.template.base.model;

/**
 * Created by zwg on 2016/10/12.
 *
 * @author zwg
 */
public enum RespCode {

    SUCCESS(1000, "成功"),
    NOHIT(1200, "无命中"),
    CACHE(1100,"缓存查询"),
    BUILDING(1300,"数据生成中"),

    UNKOWN_ERROR(2001, "未知错误"),
    SERVICE_ERROR(2002, "服务错误"),
    EXCEPTION_ERROR(2003, "服务异常"),
    DB_ERROR(2004, "数据库错误"),
    TIMEOUT(2000, "访问超时"),
    NOFEE(2100, "无费用"),
    NOPARAMS(2200, "参数缺失"),

    ERROR(3000, "失败"),
    NO_LOGIN(3001, "未登录"),
    NO_EXISTS_USER(3002, "用户不存在"),
    PWD_ERROR(3003, "密码错误"),
    VERTIFYCODE_ERROR(3004, "验证码错误"),
    NOT_AUTH(3005, "没有权限"),
    LOCATION_ERROR(3006, "位置错误"),
    TOKEN_ERROR(3007, "token错误"),
    TOKEN_EXPIRE(3008, "token过期"),
    NOAUTH(3100, "授权失败"),

    FORMAT_ERROR(4001, "数据格式错误"),
    PARAM_EMPTY(4002, "参数为空"),
    PARAM_ERROR(4003, "参数错误"),
    NONEADAPTER(4000, "数据适配器不存在"),

    SAVE_FAIL(5001, "保存失败"),
    UPDATE_FAIL(5002, "更新失败"),
    DELETE_FAIL(5003, "删除失败"),;


    int code;
    String msg;

    RespCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
