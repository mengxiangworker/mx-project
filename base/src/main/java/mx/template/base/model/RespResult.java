package mx.template.base.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;


/**
 * JSON数据统一返回格式
 * @author mpd
 */
@Getter
@Setter
@ToString
public class RespResult<E> implements Serializable {

	private static final long serialVersionUID = 2914677101817844403L;
	/**
	 * 返回码
	 */
	private int code;
	/**
	 * 说明内容
	 */
	private String message;
	/**
	 * 返回的具体数据
	 */
	private E data;
	/**
	 * 总记录数
	 */
	private long total;
	/**
	 * 接口相关的调试信息放在infos信息里面
	 */
	private Map<String,Object> infos;

	private static final String START_TIME="START_TIME";
	private static final String END_TIME="END_TIME";
	private static final String EXCEPTION_DETAIL="EXCEPTIONS";
	private static final String CONSUME="CONSUME";
	
	public RespResult(boolean debug) {
		super();
		if(debug){
			infos = new HashMap<>();
			infos.put(START_TIME,System.currentTimeMillis());
		}
	}
	
	
	public RespResult<E> success(String message, E e){
		updateRespCode(RespCode.SUCCESS);
		this.message = message;
		endTime();
		data = e;
		return this;
	}
	
	
	public RespResult<E> success(E e){
		updateRespCode(RespCode.SUCCESS);
		endTime();
		data = e;
		return this;
	}
	
	public RespResult<E> fail(RespCode respCode){
		errorInfo(respCode,null,null);
		return this;
	}
	
	public RespResult<E> fail(RespCode respCode, Exception e){
		errorInfo(respCode,e,null);
		return this;
	}

	public RespResult<E> fail(RespCode respCode,E b, Exception e){
		errorInfo(respCode,e,b);
		return this;
	}

	private void updateRespCode(RespCode respCode){
		this.code = respCode.getCode();
		this.message = respCode.getMsg();
	}

	private void errorInfo(RespCode respCode,Exception e,E b){
		this.code = respCode.getCode();
		this.message = respCode.getMsg();
		if(e!=null){
			this.message += " ,Exception: " + e.getMessage();
		}
		data = b;
		if(infos!=null){
			endTime();
			if(e!=null){
				StringWriter stringWriter = new StringWriter();
				PrintWriter pw = new PrintWriter(stringWriter);
				e.printStackTrace(pw);
				infos.put(EXCEPTION_DETAIL,stringWriter.getBuffer().toString());
				pw.close();
			}
		}
	}

	private void endTime(){
		if(infos!=null){
			long e = System.currentTimeMillis();
			long s = (long) infos.get(START_TIME);
			infos.put(END_TIME,e);
			infos.put(CONSUME,(e - s));
		}
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("RespResult{");
		sb.append("code=").append(code);
		sb.append(", message='").append(message).append('\'');
		sb.append(", total=").append(total);
		sb.append(", data=").append(data);
		sb.append(", infos=").append(infos);
		sb.append('}');
		return sb.toString();
	}
}
