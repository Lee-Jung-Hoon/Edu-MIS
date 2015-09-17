package kr.co.edumis.framework;

import java.lang.reflect.Method;

public class CtrlAndMethod {
	// 메소드 객체와 메서드를 실행할 실행객체 정보
	private Object target;
	private Method method;
	
	public CtrlAndMethod(Object target, Method method) {
		this.target = target;
		this.method = method;
	}

	public Object getTarget() {
		return target;
	}
	
	public Method getMethod() {
		return method;
	}
}