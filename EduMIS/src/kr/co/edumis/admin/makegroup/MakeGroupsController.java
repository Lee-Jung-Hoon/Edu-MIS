package kr.co.edumis.admin.makegroup;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.member.dao.MemberDAO;
import kr.co.edumis.user.member.vo.MemberVO;

@Controller
public class MakeGroupsController {
	
	@RequestMapping("/makegroups/makecontroller.do")
	public ModelAndView makeController(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		ModelAndView mav = new ModelAndView();
		MemberDAO mda = new MemberDAO();
//		List<MemberVO> list = sqlMapper.selectList("member.dao.MemberMapper.getMemberList");
		List<MemberVO> list = mda.selectMember();
		for(int i =0; i<list.size();i++){
			MemberVO mvo = list.get(i);
			System.out.println(mvo.getName());
		
	} 
//		String json 
		
		mav.addObject("mlist", list);
		mav.setView("/jsp/admin/groupmaker/MakeGroups.jsp");
		return mav;
		
		
		
		
	}
	
	@RequestMapping("/makegroups/make.do")
	public ModelAndView resultController(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		ModelAndView mav = new ModelAndView();
		int gNum = Integer.parseInt(req.getParameter("gNum"));
		System.out.println(gNum);
		MemberDAO mda = new MemberDAO();
		mda.resetLeader();
		
//		sqlMapper.update("member.dao.MemberMapper.resetLeader");
//		sqlMapper.commit();
		
		for(int i =1;i<=gNum;i++){
			MemberVO mvo = new MemberVO();
			mvo.setNo(req.getParameter("leader"+i));
			System.out.println(mvo.getNo());
			if(i<=(gNum/2)){
				mvo.setTechLeader("1");
			}else{
				mvo.setTechLeader("2");
			}
			mvo.setTeam(" ");
			mda.updateLeader(mvo);
//			sqlMapper.update("member.dao.MemberMapper.updateLeader", mvo);
//			sqlMapper.commit();
			
		}
//		List<MemberVO> list = sqlMapper.selectList("member.dao.MemberMapper.getMemberList");
		List<MemberVO> list = mda.selectMember();
		MakeGroupsExecute mge = new MakeGroupsExecute();
		mge.Execute(list,gNum);
		
		
		mav.addObject("mlist", mda.selectMember());
		mav.addObject("gNum", gNum);
		
		mav.setView("/jsp/admin/groupmaker/MakeGroupsResult.jsp");
		
		
		return mav;
	}
	
	@RequestMapping("/makegroups/result.do")
	public ModelAndView resultShowController(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
//		
		ModelAndView mav = new ModelAndView();
		MemberDAO mda = new MemberDAO();
		List<MemberVO> list = mda.selectMember();
		int temp =0;
		for(int i = 0;i<list.size();i++){
			MemberVO mvo = list.get(i);
			int team = Integer.parseInt(mvo.getTeam());
			if(temp<team){
				temp = team;
			}
		}
		int gNum = temp*2;
		System.out.println(gNum);
		
		
		
		mav.addObject("mlist", mda.selectMember());
		mav.addObject("gNum", gNum);
		
		mav.setView("/jsp/admin/groupmaker/MakeGroupShow.jsp");
		
		
		return mav;
	}
	@RequestMapping("/makegroups/remake.do")
	public ModelAndView remakeController(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
//		
		ModelAndView mav = new ModelAndView();
		MemberDAO mda = new MemberDAO();
		List<MemberVO> list = mda.selectMember();
		int temp =0;
		for(int i = 0;i<list.size();i++){
			MemberVO mvo = list.get(i);
			int team = Integer.parseInt(mvo.getTeam());
			if(temp<team){
				temp = team;
			}
		}
		int gNum = temp*2;
		System.out.println(gNum);
		
		MakeGroupsExecute mge = new MakeGroupsExecute();
		mge.Execute(list,gNum);
		
		mav.addObject("mlist", mda.selectMember());
		mav.addObject("gNum", gNum);
		
		mav.setView("/jsp/admin/groupmaker/MakeGroupShow.jsp");
		
		
		return mav;
	}
	
	@RequestMapping("/makegroups/ajax")
	public void MakeGroupsAjax(HttpServletRequest req, HttpServletResponse res) throws Exception {
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
			json+= "{ name : '"
					+name+ "', no : '"+no+"', team: '"+team+"'} ";
			if(i!=list.size()-1){
				json+=",";
			}
		}
		json +="]";
		
		System.out.println(json);
		out.println(json);
		
		out.close();
		
	}
		
	
	
	

}
