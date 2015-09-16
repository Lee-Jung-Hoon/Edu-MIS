package kr.co.mlec.framework;

import java.util.HashMap;
import java.util.Map;

/*
 * Model : 화면에 처리할 데이터를 담기
 * View : 화면 페이지 정보 담기
 */
public class ModelAndView {
	private String view;
	private Map<String, Object> model = new HashMap<>();

	public ModelAndView() {
	}

	public ModelAndView(String view) {
		this.view = view;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}

	public void addObject(String key, Object value) {
		model.put(key, value);
	}
}
