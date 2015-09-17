/*
 * URI에 해당하는 Controller 클래스 정보를 관리함
 */
package kr.co.framework;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	// 맵을 이용한 URI와 Controller 관리
	private Map<String, CtrlAndMethod> mappings = new HashMap<>();

	public HandlerMapping(String ctrls) {
		String[] ctrlArr = ctrls.split("\\|");
		try {
			for (String ctrl : ctrlArr) {
				Class<?> clz = Class.forName(ctrl.trim());
				
				// 메소드에 선언된 RequestMapping 정보를 얻기위해서
				Method methods[] = clz.getDeclaredMethods();
				for(Method method : methods) {
					RequestMapping rm = method.getAnnotation(RequestMapping.class);
					
					if(rm==null) continue;
					
					String uri = rm.value();
					Object target = clz.newInstance();
					CtrlAndMethod cam = new CtrlAndMethod(target, method);
					
					mappings.put(uri, cam);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Dispatcher에서 uri를 넘겨주면 해당 컨트롤러를 반환하는 기능
	public CtrlAndMethod getController(String uri) {
		return mappings.get(uri);
	}
}
