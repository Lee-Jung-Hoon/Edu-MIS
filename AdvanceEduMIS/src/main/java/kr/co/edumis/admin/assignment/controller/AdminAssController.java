package kr.co.edumis.admin.assignment.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.edumis.admin.assignment.service.AdminAssService;
import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.user.assignment.vo.UserAssVO;
import kr.co.edumis.user.member.vo.MemberVO;

@Controller
@RequestMapping("/admin")
public class AdminAssController {
	
	@Autowired
	private AdminAssService service;
	@Autowired
	ServletContext servletContext;

	@RequestMapping("/assDetail.do")
	public ModelAndView adAssDetail(String no) throws Exception {

		System.out.println(no);
		ModelAndView mav = new ModelAndView("/admin/assignment/adAssDetail");
		
		AdminAssVO adminassVO = service.detailDownload(no);
		mav.addObject("detail", adminassVO);
		
		System.out.println(adminassVO.getTitle());
		System.out.println(adminassVO.getOrgFileName());
		System.out.println(adminassVO.getRealFileName());
		
		List<MemberVO> list = service.studentAssignmentList();
		mav.addObject("list", list);
		
		List<UserAssVO> subList = service.getsubList();
		
		for(MemberVO vo : list){
			boolean bool = false;
			
			for(UserAssVO uVO : subList) {
				if(vo.getId().equals(uVO.getId()) && no.equals(String.valueOf(uVO.getNo()))){
					System.out.println("ddd : " + uVO.getNo());
					bool = true;
					break;
				}
			}
			
			if(bool) {
				vo.setPass("O");
			} else {
				vo.setPass("X");
			}
		}
		
		return mav;
	}

	@RequestMapping(value="/assRegist.do", method=RequestMethod.POST)
	public String adAssRegist(AdminAssVO adAssvo, MultipartHttpServletRequest mRequest) throws Exception {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!:"+ adAssvo.getContent());
	String uploadDir = servletContext.getRealPath("/upload/");
	System.out.println(uploadDir);

	String id = mRequest.getParameter("id");
	System.out.println("id : " + id);
	
	Iterator<String> iter = mRequest.getFileNames();
	while(iter.hasNext()) {
		
		String formFileName = iter.next();
		// 폼에서 파일을 선택하지 않아도 객체 생성됨
		MultipartFile mFile = mRequest.getFile(formFileName);
		
		// 원본 파일명
		String orgFileName = mFile.getOriginalFilename();
		System.out.println("원본 파일명 : " + orgFileName);
		
		if(orgFileName != null && !orgFileName.equals("")) {
		
			// 확장자 처리
			String ext = "";
			// 뒤쪽에 있는 . 의 위치 
			int index = orgFileName.lastIndexOf(".");
			if (index != -1) {
				// 파일명에서 확장자명(.포함)을 추출
				ext = orgFileName.substring(index);
			}
			
			// 파일 사이즈
			long fileSize = mFile.getSize();
			System.out.println("파일 사이즈 : " + fileSize);
			
			// 고유한 파일명 만들기	
			String realFileName = "mlec-" + UUID.randomUUID().toString() + ext;
			System.out.println("저장할 파일명 : " + realFileName);
		
			// 임시저장된 파일을 원하는 경로에 저장
			//mFile.transferTo(new File(uploadDir + "/" + realFileName));
			
			adAssvo.setFilePath(uploadDir);
			adAssvo.setOrgFileName(orgFileName);
			adAssvo.setRealFileName(realFileName);
			
			service.insert(adAssvo);
		} 
	} 
	return "redirect:/admin/assList.do";
	}

	@RequestMapping("/assList.do")
	public ModelAndView adAssList(AdminAssVO adminassVO, HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView("/admin/assignment/adAssList");

		// 표시할 페이지 수
		int pageIndex = (int) Math.ceil(service.selectCount() / 10d);
		mav.addObject("pageIndex", pageIndex);
		
		// 한 페이지에 표시할 게시물
		int reqIndex = 1; 	// 요청받은 페이지 번호
		
		if (req.getParameter("reqIndex") != null) {
			reqIndex = Integer.parseInt(req.getParameter("reqIndex"));
		}
		
		if(reqIndex > pageIndex) {
			reqIndex = pageIndex;
		} else if(reqIndex < 1){
			reqIndex = 1;
		}
		
		int startIndex = 1 + (reqIndex - 1) * 10;
		int endIndex = 10 + (reqIndex - 1) * 10;
		Map<String, Integer> param = new HashMap<>();
		param.put("startIndex", startIndex);
		param.put("endIndex", endIndex);
		mav.addObject("thisPage", reqIndex);
	
		List<AdminAssVO> list = service.list(param);
		mav.addObject("asslist", list);

		// 진행여부 체크
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
	
	@RequestMapping("/assBfModify.do")
	public ModelAndView adAssBfmodify(String no) throws Exception {
	
		System.out.println(no);
		ModelAndView mav = new ModelAndView("/admin/assignment/adAssModify");
		
		AdminAssVO adminassVO = service.detail(no);
		mav.addObject("modi", adminassVO);
		
		System.out.println(adminassVO.getTitle());
		System.out.println(adminassVO.getOrgFileName());
		System.out.println(adminassVO.getRealFileName());
		
		
		return mav;
	}
	
	@RequestMapping("/assModify.do")
	public String adAssModify(AdminAssVO adAssvo, MultipartHttpServletRequest mRequest) throws Exception {
		String uploadDir = servletContext.getRealPath("/upload/");
		System.out.println(uploadDir);

		String id = mRequest.getParameter("id");
		System.out.println("id : " + id);
		
		Iterator<String> iter = mRequest.getFileNames();
		while(iter.hasNext()) {
			
			String formFileName = iter.next();
			// 폼에서 파일을 선택하지 않아도 객체 생성됨
			MultipartFile mFile = mRequest.getFile(formFileName);
			
			// 원본 파일명
			String orgFileName = mFile.getOriginalFilename();
			System.out.println("원본 파일명 : " + orgFileName);
			
			if(orgFileName != null && !orgFileName.equals("")) {
			
				// 확장자 처리
				String ext = "";
				// 뒤쪽에 있는 . 의 위치 
				int index = orgFileName.lastIndexOf(".");
				if (index != -1) {
					// 파일명에서 확장자명(.포함)을 추출
					ext = orgFileName.substring(index);
				}
				
				// 파일 사이즈
				long fileSize = mFile.getSize();
				System.out.println("파일 사이즈 : " + fileSize);
				
				// 고유한 파일명 만들기	
				String realFileName = "mlec-" + UUID.randomUUID().toString() + ext;
				System.out.println("저장할 파일명 : " + realFileName);
			
				// 임시저장된 파일을 원하는 경로에 저장
				//mFile.transferTo(new File(uploadDir + "/" + realFileName));
				
				adAssvo.setFilePath(uploadDir);
				adAssvo.setOrgFileName(orgFileName);
				adAssvo.setRealFileName(realFileName);
				
				service.insert(adAssvo);
			} 
		} 
		return "redirect:/admin/assList.do";
	}
	
	@RequestMapping("/assDelete.do")
	public String adAssDelete(String no) throws Exception {
		service.delete(no);
		
		return "redirect:/admin/assList.do";
	}
	
	@RequestMapping("/admin/assUserDetail.do")
	public ModelAndView AssUserDetail(HttpServletRequest req) throws Exception{
		ModelAndView mav = new ModelAndView("/admin/assignment/adAssUserDetail");
		
		Map<String, String> param = new HashMap<>();
		
		param.put("no", req.getParameter("no"));
		param.put("id", req.getParameter("id"));
		
		UserAssVO vo = service.getDetail(param);
		
		mav.addObject("vo", vo);
		
		return mav;
	}

	
}
