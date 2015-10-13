package kr.co.edumis.user.mypage.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.edumis.user.login.vo.LoginVO;
import kr.co.edumis.user.mypage.service.MypageService;
import kr.co.edumis.user.mypage.vo.MypageVO;

@Controller
@RequestMapping("/user/mypage")
public class MypageController {
	
	@Autowired
	private MypageService service;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping("/detailMyinfo.do")
	public ModelAndView detailMyinfo(HttpServletRequest req) throws Exception{
//		HttpSession session = req.getSession();
//		LoginVO lvo = (LoginVO)session.getAttribute("user");
//		String id = lvo.getId();
		String id = "scot1234";
		ModelAndView mav = new ModelAndView("/user/mypage/detail_myinfo");
		MypageVO mvo = service.getMyInfo(id);
		
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
		
		switch(mvo.getMajor()){
		case "1":
			mvo.setMajor("전공");
			break;
		case "2":
			mvo.setMajor("비전공");
		}
		
		mav.addObject("mvo", mvo);
		return mav;
	}
	
	@RequestMapping("/modifyMyinfoForm.do")
	public ModelAndView modifyMyinfoForm(MypageVO mypageVO) throws Exception{
		ModelAndView mav = new ModelAndView("/user/mypage/modify_myinfo");
		switch(mypageVO.getEmailDomain()){
		case "1":
			mypageVO.setEmailDomain("naver.com");
			break;
		case "2":
			mypageVO.setEmailDomain("daum.net");
			break;
		case "3":
			mypageVO.setEmailDomain("google.com");
			break;
		}
		
		switch(mypageVO.getMajor()){
		case "1":
			mypageVO.setMajor("전공");
			break;
		case "2":
			mypageVO.setMajor("비전공");
		}
		System.out.println(mypageVO.getEmailDomain());
		System.out.println(mypageVO.getMajor());
		mav.addObject("mvo", mypageVO);
		return mav;
	}
	
	@RequestMapping("/modifyMyinfo.do")
	public ModelAndView modifyMyInfo(MultipartHttpServletRequest mReq) throws Exception{
		String uploadDir = servletContext.getRealPath("/memberFile");
		
		File file = new File(uploadDir);
		if(!file.exists()){
			System.out.println(file.mkdirs());
		}else{
			System.out.println("디렉토리 존재함...");
		}
		
		MypageVO mvo = new MypageVO();
		mvo.setId(mReq.getParameter("id"));
		mvo.setName(mReq.getParameter("name"));
		mvo.setPass(mReq.getParameter("pass"));
		mvo.setYear(mReq.getParameter("year"));
		mvo.setMonth(mReq.getParameter("month"));
		mvo.setDay(mReq.getParameter("day"));
		mvo.setPostNo(mReq.getParameter("postNo"));
		mvo.setBasicAddr(mReq.getParameter("basicAddr"));
		mvo.setDetailAddr(mReq.getParameter("detailAddr"));
		mvo.setPhone1(mReq.getParameter("phone1"));
		mvo.setPhone2(mReq.getParameter("phone2"));
		mvo.setPhone3(mReq.getParameter("phone3"));
		mvo.setEmail(mReq.getParameter("email"));
		mvo.setEmailDomain(mReq.getParameter("emailDomain"));
		mvo.setMajor(mReq.getParameter("major"));
		
			MultipartFile mFile = mReq.getFile("attachFile");
			
			String oriFileName = mFile.getOriginalFilename();
			
			if(oriFileName != null && !oriFileName.equals("")){
				System.out.println("원본 파일명 : " + oriFileName);
				mvo.setOrgFileName(oriFileName);
				String ext = "";
				int index = oriFileName.lastIndexOf(".");
				if(index != -1){
					ext = oriFileName.substring(index);
				}
				
//				long fileSize = mFile.getSize();
				
				String realFileName = "mlec-" + UUID.randomUUID().toString() + ext;
				
				mFile.transferTo(new File(uploadDir + "/" + realFileName));
				mvo.setRealFileName(realFileName);
				mvo.setFilePath("/memberFile");
			}
			
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
		
		switch(mvo.getMajor()){
		case "1":
			mvo.setMajor("전공");
			break;
		case "2":
			mvo.setMajor("비전공");
		}
		System.out.println(mvo.getEmailDomain());
		System.out.println(mvo.getMajor());
		service.updateMyinfo(mvo);
		ModelAndView mav = new ModelAndView("redirect:detailMyinfo.do");
		return mav;
	}
}
