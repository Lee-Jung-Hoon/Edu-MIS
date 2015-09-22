package kr.co.edumis.admin.attendance.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.admin.attendance.service.AdminAttService;
import kr.co.edumis.admin.attendance.service.AdminAttServiceImpl;
import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.framework.Controller;
import kr.co.edumis.user.member.vo.MemberVO;

@WebServlet("/attendance/memAttList.do")
public class AdminAttController extends HttpServlet{
	private AdminAttService service;
	
	public AdminAttController(){
		service = new AdminAttServiceImpl();
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		List<MemberVO> memList = service.selectMemList();
		System.out.println("콘트롤러 memList사이즈 : "+memList.size());
		
		List<AdminAttVO> attList = service.selectAttList();	
//		System.out.println(attList.get(0).getAttType());
//		System.out.println("memList  !#! : " + memList.get(0).getName());
//		for(int i = 0; i < memList.size(); i++){
//			System.out.println("no : "+memList.get(i).getNo());
//			System.out.println("name : "+memList.get(i).getName());
//		}
		String json = "";
		json += "[";
		System.out.println("memList.size() : "+memList.size());
		for(int i = 0; i < memList.size(); i++){
			MemberVO mem = memList.get(i);
//			if(i == memList.size() - 1){
				json += "  {";
				json += "	'no': "+"'"+mem.getNo()+"'"+",  ";
				json += "	'mName': "+"'"+mem.getName()+"'";
				List<AdminAttVO> attMemList = service.selectAttMemList(mem.getNo());
				for(int j = 0; j < attMemList.size(); j++){
//					if(attMemList.size() > j){
						AdminAttVO attMem = attMemList.get(j);
						System.out.println(mem.getName()+"의 date : "+attMem.getAttDate());
						System.out.println(mem.getName()+"의 type : "+attMem.getAttType());
//						System.out.println("attMemList의 데이트 : "+attMem.getAttDate());
//						System.out.println("attMemList의 타입 : "+attMem.getAttType());
						json += "	'attDate': "+"'"+attMem.getAttDate()+"'"+",  ";
						json += "	'attType': "+"'"+attMem.getAttType()+"'";
//					}
				}
				json += "  }, ";
//			} 
//		else{
//				json += "  {";
//				json += "	'no': "+"'"+mem.getNo()+"'"+",  ";
//				json += "	'mName': "+"'"+mem.getName()+"'";
//				for(int j = 0; j < attList.size(); j++){
//					System.out.println("attList.size() : "+attList.size());
//					List<AdminAttVO> attMemList = service.selectAttMemList(mem.getNo());
//					if(attMemList.size() > j){
//						AdminAttVO attMem = attMemList.get(j);
//						System.out.println("attMemList의 데이트 : "+attMem.getAttDate());
//						System.out.println("attMemList의 타입 : "+attMem.getAttType());
//						json += "	'attDate': "+"'"+attMem.getAttDate()+"'"+",  ";
//						json += "	'attType': "+"'"+attMem.getAttType()+"'";
//					}
//				}
//				json += "  }, ";
//			}
		}
		
//		for(int i = 0; i < attList.size(); i++){
//			AdminAttVO att = attList.get(i);
//			if(i == attList.size() - 1){
//				json += "  {";
//				json += "	'mNo': "+"'"+att.getmNo()+"'"+",  ";
//				json += "	'mName': "+"'"+att.getmName()+"'"+",  ";
//				json += "	'attDate': "+"'"+att.getAttDate()+"'"+",  ";
//				json += "	'attType': "+"'"+att.getAttType()+"'";
//				json += "  } ";
//			} else{
//				json += "  {";
//				json += "	'mNo': " +"'"+att.getmNo()+"'"+ ",  ";
//				json += "	'mName': "+"'"+att.getmName()+"'"+",  ";
//				json += "	'attDate': "+"'"+att.getAttDate()+"'"+",  ";
//				json += "	'attType': "+"'"+att.getAttType()+"'";
//				json += "  }, ";
//			}
//		}
		json += "]";
		
		out.println(json);
		out.close();
	}
	
	
//	public ModelAndView memAttList(HttpServletRequest req){
//		ModelAndView mav = new ModelAndView("/jsp/admin/attendance/attendance.jsp");
//		String mNo = req.getParameter("mNo");
//		List<MemberVO> memList = service.selectMemList();
//		List<AdminAttVO> attList = service.selectAttList(mNo);
//		
//		mav.addObject("memList", memList);
//		mav.addObject("attList", attList);
//		
//		return mav;
//	}
	
	
}








