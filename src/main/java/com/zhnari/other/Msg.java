package com.zhnari.other;

import java.util.HashMap;
import java.util.Map;
/**
 * 这是一个json返回类
 * @author ASUS
 *
 */
public class Msg {

	/*返回码*/
	private int code;
	/*返回信息*/
	private String msg;
	/*数据的添加*/
	private Map<String,Object> extend = new HashMap<String, Object>();
	
	/*成功信息*/
	public static Msg success(){
		Msg result = new Msg();
		result.setCode(100);
		result.setMsg("请求成功");
		return result;
	}
	/*请求失败*/
	public static Msg fail(){
		Msg result = new Msg();
		result.setCode(200);
		result.setMsg("请求失败");
		return result;
	}
	/*添加携带信息*/
	public Msg add(String key,Object value){
		this.getExtend().put(key, value);
		return this;
	}
	
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getExtend() {
		return extend;
	}
	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
	
}
