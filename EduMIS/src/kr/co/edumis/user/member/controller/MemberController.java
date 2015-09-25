package kr.co.edumis.user.member.controller;


import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.member.service.MemberService;
import kr.co.edumis.user.member.service.MemberServiceImpl;
import kr.co.edumis.user.member.vo.MemberVO;

@Controller
public class MemberController {
	private MemberService service;
	
	public MemberController(){
		service = new MemberServiceImpl();
	}
	
	@RequestMapping("/user/member/join.do")
	public ModelAndView join(MemberVO member, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView("/jsp/user/member/main.jsp");
		
		MultipartRequest mult = new MultipartRequest(req,
				"C:\\java73\\web-workspace\\EduMIS\\WebContent\\memberFile", 1024 * 1024 * 10, "UTF-8",
				new DefaultFileRenamePolicy());
		
		member.setId(mult.getParameter("id"));
		member.setName(mult.getParameter("name"));
		member.setPass(mult.getParameter("pass"));
		member.setYear(mult.getParameter("year"));
		member.setMonth(mult.getParameter("month"));
		member.setDay(mult.getParameter("day"));
		member.setPostNo(mult.getParameter("postNo"));
		member.setBasicAddr(mult.getParameter("basicAddr"));
		member.setDetailAddr(mult.getParameter("detailAddr"));
		member.setPhone1(mult.getParameter("phone1"));
		member.setPhone2(mult.getParameter("phone2"));
		member.setPhone3(mult.getParameter("phone3"));
		member.setEmail(mult.getParameter("email"));
		member.setEmailDomain(mult.getParameter("emailDomain"));
		member.setMajor(mult.getParameter("major"));
		
		File f = mult.getFile("attachFile");
	
		if (f != null) {
			String systemName = mult.getFilesystemName("attachFile");
			String oriName = mult.getOriginalFileName("attachFile");
	
			
			member.setRealFileName(systemName);
			member.setOrgFileName(oriName);
			member.setFilePath("/memberFile");				
	
		}
		
		try {
			service.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/user/member/joinForm.do")
	public String joinForm() throws ServletException, IOException {
		return "/jsp/user/member/joinForm.jsp";
	}
}