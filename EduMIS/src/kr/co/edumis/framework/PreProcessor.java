package kr.co.edumis.framework;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PreProcessor {
	public Object[] process(Method method, HttpServletRequest req, HttpServletResponse res) throws Exception {
		Parameter[] pArr = method.getParameters();
		int count = 0;
		Object[] retArr = new Object[pArr.length];
		for (Parameter p : pArr) {
			// 이클립스 자바컴파일러 항목 선택 후 
			// Store information about method parameters 체크박스 체크
			
			// parameter 옵션 없이 컴파일 한 경우
			if(!p.isNamePresent()) {
				throw new IllegalArgumentException("컴파일 옵션에 -parameter 추가");
			}

			String name = p.getName();

			Class<?> pType = p.getType();
			String pTypeName = pType.getName();
			if (pTypeName.endsWith("HttpServletRequest")) {
				retArr[count++] = req;
			}
			else if (pTypeName.endsWith("HttpServletResponse")) {
				retArr[count++] = res;
			}
			else if (pTypeName.startsWith("kr.co.edumis")) {
				retArr[count++] = WebUtil.getFromParamToVO(pType.getName(), req);
			} else if ("int".equals(pTypeName)) {
				retArr[count++] = Integer.parseInt(req.getParameter(name));
			} else {
				retArr[count++] = req.getParameter(name);
			}
		}
		return retArr;
	}
}



