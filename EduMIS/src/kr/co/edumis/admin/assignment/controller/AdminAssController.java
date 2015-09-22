package kr.co.edumis.admin.assignment.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.edumis.admin.assignment.service.AdminAssService;
import kr.co.edumis.admin.assignment.service.AdminAssServiceImpl;
import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.assignment.vo.UserAssVO;
import kr.co.edumis.user.member.vo.MemberVO;

@Controller
public class AdminAssController {
	private AdminAssService service;

	public AdminAssController() {
		service = new AdminAssServiceImpl();
	}

	@RequestMapping("/admin/assDetail.do")
	public ModelAndView adAssDetail(String no) throws Exception {

		System.out.println(no);
		ModelAndView mav = new ModelAndView("/jsp/admin/assignment/adAssDetail.jsp");
		
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
				if(vo.getName().equals(uVO.getName())){
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

	@RequestMapping("/admin/assRegist.do")
	public String adAssRegist(AdminAssVO adAssvo, HttpServletRequest req) throws Exception {
		MultipartRequest mult = new MultipartRequest(req,
				"C:\\java73\\web-workspace\\EduMIS\\WebContent\\assignmentFile", 1024 * 1024 * 10, "UTF-8",
				new DefaultFileRenamePolicy());

		Enumeration<String> e = mult.getFileNames();

		while (e.hasMoreElements()) {
			String fileNmae = e.nextElement();

			File f = mult.getFile(fileNmae);

			if (f != null) {
				String systemName = mult.getFilesystemName(fileNmae);
				String oriName = mult.getOriginalFileName(fileNmae);

				adAssvo.setStartDate(mult.getParameter("startDate"));
				adAssvo.setEndDate(mult.getParameter("endDate"));
				adAssvo.setTitle(mult.getParameter("title"));
				adAssvo.setContent(mult.getParameter("content"));
				adAssvo.setRealFileName(systemName);
				adAssvo.setOrgFileName(oriName);
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

		for (AdminAssVO vo : list) {
			System.out.println(vo.getNo());
		}
		return mav;
	}
	@RequestMapping("/admin/assBfModify.do")
	public ModelAndView adAssBfmodify(String no) throws Exception {
	
		System.out.println(no);
		ModelAndView mav = new ModelAndView("/jsp/admin/assignment/adAssModify.jsp");
		
		AdminAssVO adminassVO = service.detail(no);
		mav.addObject("modi", adminassVO);
		
		System.out.println(adminassVO.getTitle());
		System.out.println(adminassVO.getOrgFileName());
		System.out.println(adminassVO.getRealFileName());
		
		
		return mav;
	}
	
	@RequestMapping("/admin/assModify.do")
	public String adAssModify(AdminAssVO adAssvo, HttpServletRequest req) throws Exception {
		MultipartRequest mult = new MultipartRequest(req,
				"C:\\java73\\web-workspace\\EduMIS\\WebContent\\assignmentFile", 1024 * 1024 * 10, "UTF-8",
				new DefaultFileRenamePolicy());

		Enumeration<String> e = mult.getFileNames();

		while (e.hasMoreElements()) {
			String fileNmae = e.nextElement();

			File f = mult.getFile(fileNmae);

			if (f != null) {
				String systemName = mult.getFilesystemName(fileNmae);
				String oriName = mult.getOriginalFileName(fileNmae);

				adAssvo.setStartDate(mult.getParameter("startDate"));
				adAssvo.setNo(Integer.parseInt(mult.getParameter("no")));
				adAssvo.setEndDate(mult.getParameter("endDate"));
				adAssvo.setTitle(mult.getParameter("title"));
				adAssvo.setContent(mult.getParameter("content"));
				adAssvo.setRealFileName(systemName);
				adAssvo.setOrgFileName(oriName);
				adAssvo.setFilePath("/assignmentFile");
			}
		}
		System.out.println("뚱 : " + adAssvo.getNo());

		service.update(adAssvo);

		return "redirect:/EduMIS/admin/assList.do";
	}
	@RequestMapping("/admin/assDelete.do")
	public String adAssDelete(String no) throws Exception {
		service.delete(no);
		
		return "redirect:/EduMIS/admin/assList.do";
	}
	
	@RequestMapping("/admin/assUserDetail.do")
	public ModelAndView AssUserDetail(HttpServletRequest req) throws Exception{
		ModelAndView mav = new ModelAndView("/jsp/admin/assignment/adAssUserDetail.jsp");
		
		Map<String, String> param = new HashMap<>();
		
		param.put("no", req.getParameter("no"));
		param.put("id", req.getParameter("id"));
		
		UserAssVO vo = service.getDetail(param);
		
		mav.addObject("vo", vo);
		
		return mav;
	}

	
}
