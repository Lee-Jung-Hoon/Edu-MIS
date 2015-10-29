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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.edumis.admin.assignment.service.AdminAssService;
import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.common.Constants;
import kr.co.edumis.common.PageVO;
import kr.co.edumis.common.SearchVO;
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

	@RequestMapping(value="/assRegist.do")
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
	public ModelAndView adAssList(AdminAssVO adminassVO, HttpServletRequest req, @RequestParam(value="reqIndex", required=false, defaultValue="1") int pageNo) throws Exception {
		ModelAndView mav = new ModelAndView("/admin/assignment/adAssList");
		
		SearchVO vo = new SearchVO();
		vo.setStart( (pageNo -1) * Constants.PAGE_LIST_COUNT + 1 );
		vo.setEnd( pageNo * Constants.PAGE_LIST_COUNT );
		
		Map<String,Object> result = service.list(vo);
		System.out.println("종료1");
		
		int count = (Integer)result.get("count");
		
		PageVO pageVO = new PageVO("list.do" , pageNo, count);
		
//		mav.addObject("list", result.get("list"));
		mav.addObject("pageVO", pageVO);
		
				
//		List<AdminAssVO> list = service.list(pageVO);
		System.out.println("종료2");
		mav.addObject("asslist", result.get("list"));
		List<AdminAssVO> list = (List<AdminAssVO>) result.get("list");
		// 진행여부 체크
		List<String> ckArr = new ArrayList<String>();
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		String nowDate = String.valueOf(c.get(c.YEAR))
				+ String.valueOf(c.get(c.MONTH)+1 < 10 ? "0" + (c.get(c.MONTH) + 1) : (c.get(c.MONTH)) + 1)
				+ String.valueOf(c.get(c.DATE) < 10 ? "0" + c.get(c.DATE) : c.get(c.DATE));
		int nDate = Integer.parseInt(nowDate);
		System.out.println(nDate);
		int i = 0;
		for (AdminAssVO avo : list) {
			System.out.println(avo.getStartDate());
			int startDate = Integer.parseInt(avo.getStartDate().replace("-", ""));
			int endDate = Integer.parseInt(avo.getEndDate().replace("-", ""));

			if (nDate >= startDate && nDate <= endDate) {
				ckArr.add("O");
			} else
				ckArr.add("X");
			System.out.println(ckArr.get(i));
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
