package kr.co.edumis.framework;

import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {
	public static Object getFormParamToVO(String className, HttpServletRequest req) {
		Object obj = null;
		try {
			Class<?> clz = Class.forName(className);
			obj = clz.newInstance();
			Method[] methods = clz.getDeclaredMethods();

			for (Method method : methods) {
				Enumeration<String> pNames = req.getParameterNames();
				while (pNames.hasMoreElements()) {
					String paramName = pNames.nextElement();
					String paramValue = req.getParameter(paramName);
					String methodName = "set" + Character.toUpperCase(paramName.charAt(0)) + paramName.substring(1);
					
					if(method.getName().equals(methodName)) {
						Class<?>[] pArr = method.getParameterTypes();
						String tName = pArr[0].getName();
						switch(tName) {
						case "java.lang.String" :
							method.invoke(obj, paramValue);
							break;
						case "int" :
							method.invoke(obj, Integer.parseInt(paramValue));
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
