package kr.co.edumis.user.assignment.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.assignment.service.UserAssService;
import kr.co.edumis.user.assignment.service.UserAssServiceImpl;
import kr.co.edumis.user.assignment.vo.UserAssVO;
import kr.co.edumis.user.login.vo.LoginVO;

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
            //페이징
			//페이지 수
			int pageIndex = (int)Math.ceil(service.AssCount()/10d);
			mav.addObject("pageIndex", pageIndex);
			
			int reqIndex = 1; 
			if (req.getParameter("reqIndex") != null) {
				reqIndex = Integer.parseInt(req.getParameter("reqIndex"));
			}
			if(reqIndex > pageIndex) {
				reqIndex = pageIndex;
			} else if(reqIndex < 1){
				reqIndex = 1;
			}
			
			String startIndex = String.valueOf(1 + (reqIndex - 1) * 10);
			String endIndex = String.valueOf(10 + (reqIndex - 1) * 10);
			Map<String, String> param = new HashMap<>();
			param.put("startIndex",startIndex);
			param.put("endIndex", endIndex);
			
			
			//제출여부
			HttpSession hts = req.getSession();
			LoginVO session = (LoginVO)hts.getAttribute("user");
			String id = session.getId();
			param.put("id", id);
			
				
			List<AdminAssVO> list = service.getList(param);
//			System.out.println(list.get(0).getIsSubmit());
//			System.out.println(list.get(1).getIsSubmit());
			mav.addObject("thisPage", reqIndex);
			mav.addObject("assList", list);

			
			
			// 진행여부
			List<String> ckArr = new ArrayList<String>();
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(System.currentTimeMillis());
			String nowDate = String.valueOf(c.get(c.YEAR))
					+ String.valueOf(c.get(c.MONTH) < 10 ? "0" + (c.get(c.MONTH) + 1) : (c.get(c.MONTH)) + 1)
					+ String.valueOf(c.get(c.DATE) < 10 ? "0" + c.get(c.DATE) : c.get(c.DATE));
			int nDate = Integer.parseInt(nowDate);
			
			for (AdminAssVO vo : list) {
				int startDate = Integer.parseInt(vo.getStartDate().replace("-", ""));
				int endDate = Integer.parseInt(vo.getEndDate().replace("-", ""));

				if (nDate >= startDate && nDate <= endDate) {
					ckArr.add("O");
				} else
					ckArr.add("X");
			}
			mav.addObject("ckArr", ckArr);
			
			

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	//상세조회
	@RequestMapping("/user/assDetail.do")
	public ModelAndView userDetail(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String no = req.getParameter("no");
		
		Map<String, String> param = new HashMap<>();
		String id = req.getParameter("id");
		param.put("id", id);
		param.put("no", no);
		
		ModelAndView mav = new ModelAndView("/jsp/user/assignment/userAssRegist.jsp");
				
		try {					
					AdminAssVO admass = service.admdetail(no);
					mav.addObject("ass", admass);

					UserAssVO userass = service.userdetail(param);
					mav.addObject("userass", userass);

				} catch (Exception e) {
					e.printStackTrace();
				}
		return mav;
	}
	
	//과제등록
	@RequestMapping("/user/assRegist.do")
	public String userAssRegist(UserAssVO userass,HttpServletRequest req) throws ServletException, IOException {
	   
		String realPath = req.getServletContext().getRealPath("/assignmentFile");
		
		File file = new File(realPath);
		if( !file.exists() ) {
			System.out.println(file.mkdirs());
		} else {
			System.out.println("디렉토리 존재함..");
		}
		
		MultipartRequest multi = new MultipartRequest(
	    		req,
	    		realPath,
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
	    	userass.setName(multi.getParameter("name"));
	    	userass.setId(multi.getParameter("id"));
	    	userass.setFilePath("/assignmentFile");
	    	}
	    }
	    
	    
	    try {
			service.registAssignment(userass);
			System.out.println(multi.getParameter("id"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return  "redirect:/EduMIS/user/assList.do";
		
	}
	
	@RequestMapping("/user/assBfModify.do")
	public ModelAndView userAssBfModify(String no,HttpServletRequest req)
			throws ServletException, IOException {
		

		ModelAndView mav = new ModelAndView("/jsp/user/assignment/userAssModify.jsp");
		Map<String, String> param = new HashMap<>();
		String id = req.getParameter("id");
		param.put("id", id);
		param.put("no", no);
		

		try {
			AdminAssVO admass = service.admdetail(no);
			mav.addObject("ass", admass);
			
			UserAssVO userass = service.userdetail(param);
			mav.addObject("userass", userass);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mav;
		
	}
	@RequestMapping("/user/assModify.do")
	public String userAssModify(UserAssVO userass,HttpServletRequest req)
			throws ServletException, IOException {
		
		String realPath = req.getServletContext().getRealPath("/assignmentFile");
		
		File file = new File(realPath);
		if( !file.exists() ) {
			System.out.println(file.mkdirs());
		} else {
			System.out.println("디렉토리 존재함..");
		}
		
		MultipartRequest multi = new MultipartRequest(
	    		req,
	    		realPath,
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
	    	userass.setName(multi.getParameter("name"));
	    	userass.setId(multi.getParameter("id"));
	    	userass.setFilePath("/assignmentFile");
	    	}
	    }
	    try {
			service.updateUserAss(userass);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return "redirect:/EduMIS/user/assList.do";
		
	}
	
	
	
	
}
