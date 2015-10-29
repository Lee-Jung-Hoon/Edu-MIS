package kr.co.edumis.admin.attendance.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.edumis.admin.attendance.service.AdminAttService;
import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.user.member.vo.MemberVO;

@Controller
public class AdminRMController {
	@Autowired
	private AdminAttService service;
	

	
	@RequestMapping("/attendance/AttRegist.do")
	public ModelAndView AttRegist(HttpServletRequest req){
		ModelAndView mav = new ModelAndView("${pageContext.request.contextPath}/admin/attendance/attendance.do");
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
		ModelAndView mav = new ModelAndView("${pageContext.request.contextPath}/admin/attendance/attendance.do");
		List<MemberVO> member;
		try{
			// insert시키는 부분
			member = service.selectMemList();
//			String no  = req.getParameter("no");
//			System.out.println(member.get(0).getName());
			for(MemberVO m: member){
				AdminAttVO avo = new AdminAttVO();
//				int no = Integer.parseInt(req.getParameter(m.getNo()));
				String type = req.getParameter(m.getNo());
				int no = Integer.parseInt(type);
				System.out.println("no:" + no);
				String attDate = req.getParameter("attDate");
				System.out.println(attDate);
				
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
