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
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.edumis.admin.attendance.service.AdminAttService;
import kr.co.edumis.admin.attendance.service.AdminAttServiceImpl;
import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.user.member.vo.MemberVO;

@Controller
@RequestMapping("/attendance")
public class AdminAttController extends HttpServlet{
	
	@Autowired
	private AdminAttService service;
	


	
	// 학생 리스트 불러오기
	@RequestMapping("/memAttList.do")
	private void memAttList(HttpServletRequest req, HttpServletResponse res) throws Exception{
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		List<MemberVO> memList = service.selectMemList();
		System.out.println("콘트롤러 memList사이즈 : "+memList.size());
		List<AdminAttVO> attList = service.selectAttList2();	
		String json = "";
		json += "[";
		for(int i = 0; i < memList.size(); i++){
			MemberVO mem = memList.get(i);

			json += "  {";
			json += "	'no': '" + mem.getNo() + "', ";
			json += "	'mName': "+"'"+mem.getName() + "', ";
			json += "	'grade': "+"'"+mem.getGrade() + "'";

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








