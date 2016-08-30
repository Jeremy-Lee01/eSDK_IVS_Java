package com.huawei.esdk.demo.interceptor;


import java.util.List;

public class MsgSessionHolder {
	
	private MsgSessionHolder(){}
	
	private List<String> session;

	private static final MsgSessionHolder msgSessionHolder = new MsgSessionHolder();    

	public static MsgSessionHolder getInstance() {    
	    return msgSessionHolder;    
	   }   
	
	public List<String> getSession() {
		return session;
	}

	public void setSession(List<String> session) {
		this.session = session;
	}
	
	
}
