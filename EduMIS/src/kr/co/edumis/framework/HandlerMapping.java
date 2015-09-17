/*
 * URI에 해당하는 Controller 클래스 정보를 관리함
 */
package kr.co.edumis.framework;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandlerMapping {
	// 맵을 이용한 URI와 Controller 관리
	private Map<String, CtrlAndMethod> mappings;
	
	public HandlerMapping(String packageName) throws Exception {
		mappings = new HashMap<String, CtrlAndMethod>();

		// 컨트롤러 이름 얻기
		List<String> ctrls = getControlList(packageName);
		System.out.println(ctrls);
		for (String ctrl : ctrls) {
			if (! isConAnno(ctrl) ) continue;
			addMap(ctrl.trim());
		}
	}

	private boolean isConAnno(String ctrl) throws Exception {
		Class<?> clz = Class.forName(ctrl);
		Controller con = clz.getAnnotation(Controller.class);
		return (con != null);
	}
	
	private List<String> getControlList(String packageName) throws Exception {
		Enumeration<URL> en = this.getClass().getClassLoader().getResources(packageName.replace(".", "/"));
		List<String> nameList = new ArrayList<String>();
		String packagePath = "";
		while(en.hasMoreElements()) {
			URL url = en.nextElement();
			File file = new File(url.toURI());
			packagePath = file.getPath().replace(packageName.replace(".", "\\"), "");
			File[] files = file.listFiles();
			for(File f : files) {
				getClassNameByPackage(f, nameList, packagePath);
			}
		}
		return nameList;
	}
	
	private void getClassNameByPackage(File f, List<String> list, String packagePath) throws Exception {
		if (f.isDirectory()) {
			File[] files = f.listFiles();
			for (File file : files) {
				getClassNameByPackage(file, list, packagePath);
			}
		} else if (f.isFile()) {
			list.add(
					f.getPath().substring(0, f.getPath().lastIndexOf("."))
					 .replace(packagePath, "").replace("\\", "."));
		}
	}
	
	// addMap("kr.co.mlec.board.controller.ListBoardController");
	private void addMap(String className) throws Exception {
		Class<?> clz = Class.forName(className);
		Object target = clz.newInstance();
		
		Method[] methods = clz.getDeclaredMethods();
		for (Method method : methods) {
			RequestMapping reqAnno = method.getAnnotation(RequestMapping.class);
			if (reqAnno == null) {
				continue;
			}
			String key = reqAnno.value();
			
			CtrlAndMethod cam = new CtrlAndMethod(target, method);
			mappings.put(key, cam);
		}
	}
 	
	public CtrlAndMethod getCtrlAndMethod(String uri) {
		return mappings.get(uri);
	}
}