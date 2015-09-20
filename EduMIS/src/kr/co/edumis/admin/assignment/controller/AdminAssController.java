package kr.co.edumis.admin.assignment.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;

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
				
				adAssvo.setStartDate(mult.getParameter("startDate"));
				adAssvo.setEndDate(mult.getParameter("endDate"));
				adAssvo.setTitle(mult.getParameter("title"));
				adAssvo.setContent(mult.getParameter("content"));
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
		
		List<AdminAssVO> list = service.list();
		System.out.println(list.size());
		ModelAndView mav = new ModelAndView("/jsp/admin/assignment/adAssList.jsp");
		mav.addObject("list", list);
		
		
		
		List<String>  ckArr = new ArrayList<String>();
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		String nowDate = String.valueOf(c.get(c.YEAR)) + 
				String.valueOf(c.get(c.MONTH) < 10 ? "0"+(c.get(c.MONTH)+1) : (c.get(c.MONTH))+1) + 
				String.valueOf(c.get(c.DATE) < 10 ? "0" + c.get(c.DATE) : c.get(c.DATE));
		int nDate = Integer.parseInt(nowDate);
		for(AdminAssVO vo : list) {
			int startDate = Integer.parseInt(vo.getStartDate().replace("-", ""));
			int endDate = Integer.parseInt(vo.getEndDate().replace("-", ""));
			
			if(nDate >= startDate && nDate <= endDate) {
				ckArr.add("O");
			} else
				ckArr.add("X");
		}
		mav.addObject("ckArr", ckArr);
		
		for(AdminAssVO vo : list) {
			System.out.println(vo.getNo());
		}
		return mav;
	}
}
