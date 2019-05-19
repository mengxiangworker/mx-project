/** 
 * 2011-11-19 下午04:27:25  
 * @author zhaowg 
 * @version V1.0 
 */
package mx.template.base.exception;


/**
 * 自定的异常类
 * @author mpd
 */
public class BaseException extends  RuntimeException{

	public BaseException(){
		super();
	}

	public BaseException(String msg){
		super(msg);
	}
}
