package kr.co.edumis.user.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.framework.WebUtil;
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
			ModelAndView mav = new ModelAndView("/jsp/mypage/detail_myinfo.jsp");
			System.out.println(1);
			List<MypageVO> list = service.getMyinfo(id);
			System.out.println(list.size());
			System.out.println(list.get(0).getId());
			mav.addObject("list", list);
			return mav;
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	@RequestMapping("/user/mypage/modifyMyinfoForm.do")
	public ModelAndView modifyMyinfoForm(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		try{
			ModelAndView mav = new ModelAndView("/jsp/mypage/modify_myinfo.jsp");
			MypageVO mvo = (MypageVO)WebUtil.getFromParamToVO("kr.co.edumis.user.mypage.vo.MypageVO", req);
			mav.addObject("mvo", mvo);
			return mav; 
		}catch(Exception e){
			throw new ServletException(e);
		}
	}
	
	@RequestMapping("/user/mypage/modifyMyinfo.do")
	public ModelAndView modifyMyinfo(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		try{
			ModelAndView mav = new ModelAndView("redirect:/EduMIS/user/mypage/detailMyinfo.do");
			MypageVO mvo = (MypageVO)WebUtil.getFromParamToVO("kr.co.edumis.user.mypage.vo.MypageVO", req);
			mav.addObject("mvo", mvo);
			return mav; 
		}catch(Exception e){
			throw new ServletException(e);
		}
	}
	
	
	
}
