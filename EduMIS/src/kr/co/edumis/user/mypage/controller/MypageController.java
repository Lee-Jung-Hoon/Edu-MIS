package kr.co.edumis.user.mypage.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
		LoginVO lvo = (LoginVO)session.getAttribute("user");
		String id = lvo.getId();
		try {
			ModelAndView mav = new ModelAndView("/jsp/mypage/detail_myinfo.jsp");
			List<MypageVO> list = service.getMyinfo(id);
			switch(list.get(0).getEmailDomain()){
			case "1":
				list.get(0).setEmailDomain("naver.com");
				break;
			case "2":
				list.get(0).setEmailDomain("daum.net");
				break;
			case "3":
				list.get(0).setEmailDomain("google.com");
				break;
			}
			
			
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
			switch(mvo.getEmailDomain()){
			case "naver.com":
				mvo.setEmailDomain("1");
				break;
			case "daum.net":
				mvo.setEmailDomain("2");
				break;
			case "google.com":
				mvo.setEmailDomain("3");
				break;
			}
			switch(mvo.getMajor()){
			case "전공":
				mvo.setMajor("1");
				break;
			case "비전공":
				mvo.setMajor("2");
				break;
			}
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
			
			String realPath = req.getServletContext().getRealPath("/memberFile");
			
			File file = new File(realPath);
			if( !file.exists() ) {
				System.out.println(file.mkdirs());
			} else {
				System.out.println("디렉토리 존재함..");
			}
			
			MultipartRequest mult = new MultipartRequest(req,
					realPath, 1024 * 1024 * 10, "UTF-8",
					new DefaultFileRenamePolicy());
			
			MypageVO mvo = new MypageVO();
			mvo.setId(mult.getParameter("id"));
			mvo.setName(mult.getParameter("name"));
			mvo.setPass(mult.getParameter("pass"));
//			mvo.setPassChk(mult.getParameter("passChk"));
			mvo.setYear(mult.getParameter("year"));
			mvo.setMonth(mult.getParameter("month"));
			mvo.setDay(mult.getParameter("day"));
			mvo.setPostNo(mult.getParameter("postNo"));
			mvo.setBasicAddr(mult.getParameter("basicAddr"));
			mvo.setDetailAddr(mult.getParameter("detailAddr"));
			mvo.setPhone1(mult.getParameter("phone1"));
			mvo.setPhone2(mult.getParameter("phone2"));
			mvo.setPhone3(mult.getParameter("phone3"));
			mvo.setEmail(mult.getParameter("email"));
			mvo.setEmailDomain(mult.getParameter("emailDomain"));
			mvo.setMajor(mult.getParameter("major"));
			
			File f = mult.getFile("attachFile");
			if (f != null) {
				String systemName = mult.getFilesystemName("attachFile");
				String oriName = mult.getOriginalFileName("attachFile");
				mvo.setRealFileName(systemName);
				mvo.setOrgFileName(oriName);
				mvo.setFilePath("/memberFile");				
			}
			
			
//			MypageVO mvo = (MypageVO)WebUtil.getFromParamToVO("kr.co.edumis.user.mypage.vo.MypageVO", req);
			switch(mvo.getEmailDomain()){
			case "1":
				mvo.setEmailDomain("naver.com");
				break;
			case "2":
				mvo.setEmailDomain("daum.net");
				break;
			case "3":
				mvo.setEmailDomain("google.com");
				break;
			}
			service.updateMyinfo(mvo);
			return mav; 
		}catch(Exception e){
			throw new ServletException(e);
		}
	}
	
	
	
}
