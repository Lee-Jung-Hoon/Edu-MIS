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
		for(int i = 0; i < memList.size(); i++){
			MemberVO mem = memList.get(i);

			json += "  {";
			json += "	'no': '" + mem.getNo() + "', ";
			json += "	'mName': "+"'"+mem.getName() + "' ";

			List<AdminAttVO> attMemList = service.selectAttMemList(mem.getNo());
			for(int j = 0; j < attMemList.size(); j++) {
				if (j == 0) {
					json += ", ";
					json += "'attInfo': [";
				}
				AdminAttVO attMem = attMemList.get(j);
				json += "'" + attMem.getAttType()+ ":" + attMem.getAttDate()+"' ";
				
				if(j != attMemList.size() -1){
					json += ", ";
				}
			}
			if (attMemList.size() != 0) {
				json += "]";
			}
			
			json += "  } ";
			
			if(i != memList.size() - 1){
				json += ", ";
			} 
		}
		
		System.out.println(json);
		
		json += "]";
		
		out.println(json);
		out.close();
	}
	
	
	
}








