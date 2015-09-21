package kr.co.edumis.user.assignment.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.assignment.service.UserAssService;
import kr.co.edumis.user.assignment.service.UserAssServiceImpl;
import kr.co.edumis.user.assignment.vo.UserAssVO;

@Controller
public class UserAssController {
	
	private UserAssService service;
	
	public UserAssController(){
		service = new UserAssServiceImpl();
	}
	
	//과제목록
	@RequestMapping("/user/assList.do")
	public ModelAndView userAssList(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		ModelAndView mav = new ModelAndView("/jsp/user/assignment/userAssList.jsp");
		
		try {
			List<AdminAssVO> list = service.getList();
			mav.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	//상세조회
	@RequestMapping("/user/assDetail.do")
	public ModelAndView userDetail(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		int no = Integer.parseInt(req.getParameter("no"));

		ModelAndView mav = new ModelAndView("/jsp/user/assignment/userAssRegist.jsp");
		//해야할 과제 정보 보여주기
				try {
					AdminAssVO admass = service.detail(no);
					mav.addObject("ass", admass);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		return mav;
	}
	
	//과제등록
	@RequestMapping("/user/assRegist.do")
	public String userAssRegist(UserAssVO userass,HttpServletRequest req) throws ServletException, IOException {
	   
		MultipartRequest multi = new MultipartRequest(
	    		req,
	    		"C:\\java73\\web-workspace\\EduMIS\\WebContent\\assignmentFile",
				1024*1024*10, 
				"UTF-8",
				new DefaultFileRenamePolicy() //파일의 이름이 같을 때 사용할 정책 설정
				);
	    
	    Enumeration<String> e = multi.getFileNames();
	    
	    while(e.hasMoreElements()){
	    	String filename = e.nextElement();
	    	
	    	File f = multi.getFile(filename);
	    	
	    	if(f != null){
	    	
	    	String orgFileName = multi.getOriginalFileName(filename);
	    	String realFileName = multi.getFilesystemName(filename);
	    	
	    	userass.setContent(multi.getParameter("usertext"));
	    	userass.setOrgFileName(orgFileName);
	    	userass.setRealFileName(realFileName);
	    	userass.setNo(Integer.parseInt(multi.getParameter("no")));
	    	userass.setName("가나다");
	    	userass.setId("abcde");
	    	userass.setFilePath("/assignmentFile");
	    	}
	    }
	    
	    try {
			service.registAssignment(userass);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return  "redirect:/EduMIS/user/assList.do";
		
	}
	
	
	@RequestMapping("/user/assDetailComplete.do")
	public ModelAndView userAssDetailComplete(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
				return null;
		
	}
	@RequestMapping("/user/assBfModify.do")
	public ModelAndView userAssBfModify(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		return null;
		
	}
	@RequestMapping("/user/assModify.do")
	public ModelAndView userAssModify(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
				return null;
		
	}
	
	
	
	
}
