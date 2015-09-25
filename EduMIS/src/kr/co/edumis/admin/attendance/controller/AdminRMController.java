package kr.co.edumis.admin.attendance.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.edumis.admin.attendance.service.AdminAttService;
import kr.co.edumis.admin.attendance.service.AdminAttServiceImpl;
import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.member.vo.MemberVO;

@Controller
public class AdminRMController {
	private AdminAttService service;
	
	public AdminRMController() {
		service = new AdminAttServiceImpl();
	}
	
	@RequestMapping("/attendance/AttRegist.do")
	public ModelAndView AttRegist(HttpServletRequest req){
		ModelAndView mav = new ModelAndView("redirect:/EduMIS/jsp/admin/attendance/attendance.jsp");
		List<MemberVO> member;
		try{
			// insert시키는 부분
			member = service.selectMemList();
//			String no  = req.getParameter("no");
//			System.out.println(member.get(0).getName());
			for(MemberVO m: member){
				AdminAttVO avo = new AdminAttVO();
				int no = Integer.parseInt(req.getParameter("no_"+m.getNo()));
				String name = req.getParameter(m.getName());
				String type = req.getParameter(m.getNo());
				int attType = 0;
				switch(type){
				case "출석":
					attType = 1;
					System.out.println("attType : " + attType);
					break;
				case "지각":
					attType = 2;
					System.out.println("attType : " + attType);
					break;
				case "조퇴":
					attType = 3;
					System.out.println("attType : " + attType);
					break;
				case "결석":
					attType = 4;
					System.out.println("attType : " + attType);
					break;
				}
				avo.setmNo(no);
				avo.setmName(name);
				avo.setAttType(attType);
				service.insertAtt(avo);
				System.out.println(no + "-" + name + "-" + type + "-" + attType);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return mav;
		
	}
	@RequestMapping("/attendance/AttUpdate.do")
	public ModelAndView AttUpdate(HttpServletRequest req){
		ModelAndView mav = new ModelAndView("redirect:/EduMIS/jsp/admin/attendance/attendance.jsp");
		List<MemberVO> member;
		try{
			// insert시키는 부분
			member = service.selectMemList();
//			String no  = req.getParameter("no");
//			System.out.println(member.get(0).getName());
			for(MemberVO m: member){
				AdminAttVO avo = new AdminAttVO();
				int no = Integer.parseInt(req.getParameter("no_"+m.getNo()));
				String type = req.getParameter(m.getNo());
				String attDate = req.getParameter("attDate");
				
				int attType = 0;
				switch(type){
				case "출석":
					attType = 1;
					System.out.println("attType : " + attType);
					break;
				case "지각":
					attType = 2;
					System.out.println("attType : " + attType);
					break;
				case "조퇴":
					attType = 3;
					System.out.println("attType : " + attType);
					break;
				case "결석":
					attType = 4;
					System.out.println("attType : " + attType);
					break;
				}
				avo.setmNo(no);
				avo.setAttType(attType);
				avo.setAttDate(attDate);
//				System.out.println(no + "-" + "-" + type + "-" + attType+ "-" +attDate);
				service.updateAtt(avo);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return mav;
		
	}
	
	

}
