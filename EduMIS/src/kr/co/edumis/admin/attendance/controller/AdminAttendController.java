package kr.co.edumis.admin.attendance.controller;

import java.util.List;

import kr.co.edumis.admin.attendance.service.AdminAttService;
import kr.co.edumis.admin.attendance.service.AdminAttServiceImpl;
import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;

@Controller
public class AdminAttendController {
	private AdminAttService service;
	
	public AdminAttendController(){
		service = new AdminAttServiceImpl();
		
	}
		@RequestMapping("/attend/attend.do")
		public ModelAndView AttList() {
			ModelAndView mav = new ModelAndView("/jsp/admin/attend/attend.jsp");
			try {
				List<AdminAttVO> list = service.selectAttList2();
				
				List<AdminAttVO> list1 = service.selectAttendList(1);
				List<AdminAttVO> list2 = service.selectAttendList(2);
				List<AdminAttVO> list3 = service.selectAttendList(3);
				List<AdminAttVO> list4 = service.selectAttendList(4);
				
				int listSize = list.size();
				int listSize1 = list1.size();
				System.out.println(listSize);
				System.out.println(listSize);

				mav.addObject("listSize", listSize);
				mav.addObject("listSize1", listSize1);
				
				mav.addObject("list1", list1);
				mav.addObject("list2", list2);
				mav.addObject("list3", list3);
				mav.addObject("list4", list4);
				
				mav.addObject("list", list);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return mav;
	}
		
		

}
