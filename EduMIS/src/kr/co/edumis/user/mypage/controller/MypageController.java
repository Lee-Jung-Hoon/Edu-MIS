package kr.co.edumis.user.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.framework.WebUtil;
import kr.co.edumis.user.login.vo.LoginVO;
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
		HttpSession session = req.getSession();
		LoginVO lvo = (LoginVO)session.getAttribute("userInfo");
		String id = lvo.getId();
		try {
			ModelAndView mav = new ModelAndView("/jsp/mypage/detail_myinfo.jsp");
			List<MypageVO> list = service.getMyinfo(id);
			if(list.get(0).getMajor().equals("1")){
				list.get(0).setMajor("전공");
			}else{
				list.get(0).setMajor("비전공");
			}
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
			service.updateMyinfo(mvo);
			System.out.println("이제 가요");
			return mav; 
		}catch(Exception e){
			throw new ServletException(e);
		}
	}
	
	
	
}
