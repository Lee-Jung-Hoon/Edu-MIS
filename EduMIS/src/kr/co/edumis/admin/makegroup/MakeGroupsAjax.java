package kr.co.edumis.admin.makegroup;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.member.dao.MemberDAO;
import kr.co.edumis.user.member.vo.MemberVO;


@WebServlet("/makegroups/ajax")
public class MakeGroupsAjax extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		String json ="[";
		MemberDAO mda = new MemberDAO();
//		List<MemberVO> list = sqlMapper.selectList("member.dao.MemberMapper.getMemberList");
		List<MemberVO> list = mda.selectMember();
		for(int i =0; i<list.size();i++){
			MemberVO mvo = list.get(i);
			String name = mvo.getName();
			String no = mvo.getNo();
			String team = mvo.getTeam();
			String realFileName = mvo.getRealFileName();
			String filePath = mvo.getFilePath();
			json+= "{ name : '"
					+name+ "', no : '"+no+"', team: '"+team+"', filePath : '"+filePath+"', realFileName : '"+realFileName+"'} ";
			if(i!=list.size()-1){
				json+=",";
			}
		}
		json +="]";
		
		System.out.println(json);
		out.println(json);
		
		out.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}

	
	
	
	

}
