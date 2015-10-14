package kr.co.edumis.user.assignment.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.user.assignment.service.UserAssService;
import kr.co.edumis.user.assignment.vo.UserAssVO;
import kr.co.edumis.user.login.vo.LoginVO;

@Controller
@RequestMapping("/user")
public class UserAssController {
	
	@Autowired
	private UserAssService service;
	
	@Autowired
	ServletContext servletContext;
	
	//과제목록
	@RequestMapping("/assList.do")
	public ModelAndView userAssList(HttpServletRequest req)throws Exception {
	
		ModelAndView mav = new ModelAndView("/user/assignment/userAssList");
	
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
			

		return mav;
	}
	
	//상세조회
	@RequestMapping("/assDetail.do")
	public ModelAndView userDetail(String no, HttpServletRequest req)throws Exception {
		
		Map<String, String> param = new HashMap<>();
		String id = req.getParameter("id");
		param.put("id", id);
		param.put("no", no);
		
		ModelAndView mav = new ModelAndView("/user/assignment/userAssRegist");
				
		AdminAssVO admass = service.admdetail(no);
		mav.addObject("ass", admass);
		
		UserAssVO userass = service.userdetail(param);
		mav.addObject("userass", userass);

		return mav;
	}
	
	//과제등록
	@RequestMapping(value="/assRegist.do")
	public String userAssRegist(UserAssVO userass,MultipartHttpServletRequest mRequest)throws Exception {
	   
//		String realPath = req.getServletContext().getRealPath("/assignmentFile");
		
		String realPath = servletContext.getRealPath("/assignmentFile/");
		
		File file = new File(realPath);
		if( !file.exists() ) {
			System.out.println(file.mkdirs());
		} else {
			System.out.println("디렉토리 존재함..");
		}
		
		Iterator<String> iter = mRequest.getFileNames();
		while(iter.hasNext()) {
			
			String formFileName = iter.next();
			
			MultipartFile multi = mRequest.getFile(formFileName);
			
			String oriFileName = multi.getOriginalFilename();
			
			
			if(oriFileName != null && !oriFileName.equals("")) {
			
				// 확장자 처리
				String ext = "";
				// 뒤쪽에 있는 . 의 위치 
				int index = oriFileName.lastIndexOf(".");
				if (index != -1) {
					// 파일명에서 확장자명(.포함)을 추출
					ext = oriFileName.substring(index);
					
				}
				String realFileName = "mlec-" + UUID.randomUUID().toString() + ext;
				
				userass.setContent(mRequest.getParameter("usertext"));
		    	userass.setOrgFileName(oriFileName);
		    	userass.setRealFileName(realFileName);
		    	userass.setNo(Integer.parseInt(mRequest.getParameter("no")));
		    	userass.setName(mRequest.getParameter("name"));
		    	userass.setId(mRequest.getParameter("id"));
		    	userass.setFilePath("/assignmentFile");

			
				// 임시저장된 파일을 원하는 경로에 저장
				multi.transferTo(new File(realPath + "/" + realFileName));
			} else{

	    		userass.setContent(mRequest.getParameter("usertext"));
	    		userass.setNo(Integer.parseInt(mRequest.getParameter("no")));
	    		userass.setName(mRequest.getParameter("name"));
	    		userass.setId(mRequest.getParameter("id"));
	    		userass.setFilePath("/assignmentFile");
	    		
	    	}
		} 
		service.registAssignment(userass);


		return "redirect:assList.do";
		
	}
	
	@RequestMapping("/assBfModify.do")
	public ModelAndView userAssBfModify(String no,HttpServletRequest req)throws Exception{
		

		ModelAndView mav = new ModelAndView("/user/assignment/userAssModify");
		Map<String, String> param = new HashMap<>();
		String id = req.getParameter("id");
		param.put("id", id);
		param.put("no", no);
		

		AdminAssVO admass = service.admdetail(no);
		mav.addObject("ass", admass);
			
		UserAssVO userass = service.userdetail(param);
		mav.addObject("userass", userass);
			
	
		return mav;
		
	}
	
	@RequestMapping("/assModify.do")
	public String userAssModify(UserAssVO userass,MultipartHttpServletRequest mRequest)throws Exception {
		
		String realPath = servletContext.getRealPath("/assignmentFile/");
		
		File file = new File(realPath);
		if( !file.exists() ) {
			System.out.println(file.mkdirs());
		} else {
			System.out.println("디렉토리 존재함..");
		}
		
		Iterator<String> iter = mRequest.getFileNames();
		while(iter.hasNext()) {
			
			String formFileName = iter.next();
			
			// 폼에서 파일을 선택하지 않아도 객체 생성됨
			MultipartFile multi = mRequest.getFile(formFileName);
			
			// 원본 파일명
			String oriFileName = multi.getOriginalFilename();
			
			// 고유한 파일명 만들기	
			
			if(oriFileName != null && !oriFileName.equals("")) {
			
				// 확장자 처리
				String ext = "";
				// 뒤쪽에 있는 . 의 위치 
				int index = oriFileName.lastIndexOf(".");
				if (index != -1) {
					// 파일명에서 확장자명(.포함)을 추출
					ext = oriFileName.substring(index);
					
				}
				String realFileName = "mlec-" + UUID.randomUUID().toString() + ext;
				
				userass.setContent(mRequest.getParameter("usertext"));
		    	userass.setOrgFileName(oriFileName);
		    	userass.setRealFileName(realFileName);
		    	userass.setNo(Integer.parseInt(mRequest.getParameter("no")));
		    	userass.setName(mRequest.getParameter("name"));
		    	userass.setId(mRequest.getParameter("id"));
		    	userass.setFilePath("/assignmentFile");

			
				// 임시저장된 파일을 원하는 경로에 저장
				multi.transferTo(new File(realPath + "/" + realFileName));
			} else{

	    		userass.setContent(mRequest.getParameter("usertext"));
	    		userass.setNo(Integer.parseInt(mRequest.getParameter("no")));
	    		userass.setName(mRequest.getParameter("name"));
	    		userass.setId(mRequest.getParameter("id"));
	    		userass.setFilePath("/assignmentFile");
	    		
	    	}
		} 
		service.updateUserAss(userass);
		

		return "redirect:assList.do";
		
	}
	
	
	
	
}
