package kr.co.edumis.admin.attendance.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.edumis.admin.attendance.service.AdminAttServiceImpl;
import kr.co.edumis.admin.attendance.vo.AdminAttListVO;
import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.user.member.vo.MemberVO;

@Controller
@RequestMapping("/attend")
public class AdminAttendController{
	
	@Autowired
	private AdminAttServiceImpl service;
	
	// 출석통계를 위한 컨트롤러
	@RequestMapping("/attend.do")
	public ModelAndView AttList() throws Exception{
		ModelAndView mav = new ModelAndView("/admin/attend/attend");
		AdminAttListVO a = new AdminAttListVO();
		System.out.println(a.toString());
		List<AdminAttListVO> list =  service.selectAttList();		
		System.out.println(a.toString());
		mav.addObject("list",list);		
		return mav;
	}
	
	
	
}
