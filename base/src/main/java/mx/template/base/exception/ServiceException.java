package mx.template.base.exception;

/**
 * @author peidong.meng
 * @date 2019/5/19
 *
 * 业务异常
 */
public class ServiceException extends BaseException{

    public ServiceException(){}
    public ServiceException(String message){
        super(message);
    }
}