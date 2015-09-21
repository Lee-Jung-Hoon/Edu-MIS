package kr.co.edumis.user.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.mypage.service.MypageService;
import kr.co.edumis.user.mypage.service.MypageServiceImpl;
import kr.co.edumis.user.mypage.vo.MypageVO;

@Controller
public class MypageController {
	private MypageService service;
	
	public MypageController(){
		service = new MypageServiceImpl();
	}
	
	@RequestMapping("/user/mypage/detailMyinfo.do")
	public ModelAndView detailMyinfo(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		String id = "scot1234";
		try {
			MypageVO mvo = service.getMyinfo(id);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		return null;
	}
	
}
