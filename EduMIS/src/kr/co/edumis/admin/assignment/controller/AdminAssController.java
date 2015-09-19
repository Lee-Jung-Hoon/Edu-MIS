package kr.co.edumis.admin.assignment.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.edumis.admin.assignment.service.AdminAssService;
import kr.co.edumis.admin.assignment.service.AdminAssServiceImpl;
import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;

@Controller
public class AdminAssController {
	private AdminAssService service;
	
	public AdminAssController(){
		service = new AdminAssServiceImpl();
	}
	
	@RequestMapping("/admin/assDetail.do")
	public ModelAndView adAssDetail(String no) 
			throws ServletException, IOException {
		
		

		ModelAndView mav = new ModelAndView("/jsp/admin/assignment/addAssDetail.jsp");
		return mav;
	}
	
	@RequestMapping("/admin/assRegist.do")
	public String adAssRegist(AdminAssVO adAssvo, HttpServletRequest req) throws Exception {
		MultipartRequest mult = new MultipartRequest(req,
				"C:\\java\\web-workspace\\EduMIS\\WebContent\\assignmentFile",
				1024 * 1024 * 10,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		
		Enumeration<String> e = mult.getFileNames();
		
		while(e.hasMoreElements()) {
			String fileNmae = e.nextElement();
			
			File f = mult.getFile(fileNmae);
			
			if(f != null) {
				String systemName = mult.getFilesystemName(fileNmae);
				String oriName = mult.getOriginalFileName(fileNmae);
				
				adAssvo.setRealFileName(systemName);
				adAssvo.setOrgFileNmae(oriName);
				adAssvo.setFilePath("/assignmentFile");
			}
		}
		service.insert(adAssvo);
		
		return "redirect:/EduMIS/admin/assList.do";
	}
	
	@RequestMapping("/admin/assList.do")
	public ModelAndView adAssList(AdminAssVO adminassVO) throws Exception {
		
		ModelAndView mav = new ModelAndView("/jsp/admin/assignment/addAssList.jsp");
		return mav;
	}

}
