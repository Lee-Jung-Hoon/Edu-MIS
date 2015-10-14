package kr.co.edumis.admin.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.edumis.admin.attendance.service.AdminAttServiceImpl;
import kr.co.edumis.admin.attendance.vo.AdminAttListVO;

@Controller
@RequestMapping("/attend")
public class AdminAttendController{
	
	@Autowired
	private AdminAttServiceImpl service;
	
	// 출석통계를 위한 컨트롤러
	@RequestMapping("/attend.do")
	public ModelAndView AttList() throws Exception{
		ModelAndView mav = new ModelAndView("/admin/attend/attend");
		List<AdminAttListVO> list =  service.selectAttList();

		
		mav.addObject("list",list);
		
		return mav;
	}
	
	 // 출석통계 기간설정 컨트롤러
	@RequestMapping("/attendterm.do")
	public ModelAndView AttTermList(AdminAttListVO adm) throws Exception{
		ModelAndView mav = new ModelAndView("/admin/attend/attend");
		System.out.println(adm.toString());
		System.out.println(adm.sum());
		System.out.println(adm.endSum());
		List<AdminAttListVO> list =  service.selectAttTermList(adm);
		
		mav.addObject("list",list);
		
		return mav;
	}
}
