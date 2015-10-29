package kr.co.edumis.admin.attendance.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.co.edumis.admin.attendance.service.AdminAttService;
import kr.co.edumis.admin.attendance.service.AdminAttServiceImpl;
import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.user.member.vo.MemberVO;


@Controller
@WebServlet("/attendance/memListController.do")
public class AdminListController extends HttpServlet{
	
	@Autowired
	private AdminAttService service;
	


	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		List<MemberVO> memList = service.selectMemList();
		
		String json = "";
		json += "[";
		for(int i = 0; i < memList.size(); i++){
			MemberVO mem = memList.get(i);
			if(i == memList.size() - 1){
				json += "  {";
				json += "	'no': "+"'"+mem.getNo()+"'"+",  ";
				json += "	'mName': "+"'"+mem.getName()+"'"+",  ";
				json += "	'grade': "+"'"+mem.getGrade()+"'";				
				json += "  } ";
			} else{
				json += "  {";
				json += "	'no': "+"'"+mem.getNo()+"'"+",  ";
				json += "	'mName': "+"'"+mem.getName()+"'"+",  ";
				json += "	'grade': "+"'"+mem.getGrade()+"'";
				json += "  }, ";
			}
		}
		json += "]";
		
		out.println(json);
		out.close();
	}
	
	

	
	
}








