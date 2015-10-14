package kr.co.edumis.admin.makegroup;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.edumis.user.member.dao.MemberDAO;
import kr.co.edumis.user.member.service.MemberService;
import kr.co.edumis.user.member.vo.MemberVO;

@Controller
@RequestMapping("/makegroups")
public class MakeGroupsController {
	
	@Autowired
	public MemberService service;

	@RequestMapping("/makecontroller.do")
	public ModelAndView makeController(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();

		ModelAndView mav = new ModelAndView("/admin/groupmaker/MakeGroup");
		
		List<MemberVO> list = service.selectMember();
		for (int i = 0; i < list.size(); i++) {
			MemberVO mvo = list.get(i);
			System.out.println(mvo.getName());

		}

		mav.addObject("mlist", list);

		return mav;

	}

	@RequestMapping("/make.do")
	public ModelAndView resultController(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		ModelAndView mav = new ModelAndView("/admin/groupmaker/MakeGroupsResult");
		int gNum = Integer.parseInt(req.getParameter("gNum"));
		System.out.println(gNum);
		
		service.resetLeader();

		for (int i = 1; i <= gNum; i++) {
			MemberVO mvo = new MemberVO();
			mvo.setNo(req.getParameter("leader" + i));
			System.out.println(mvo.getNo());
			if (i <= (gNum / 2)) {
				mvo.setTechLeader("1");
			} else {
				mvo.setTechLeader("2");
			}
			mvo.setTeam(" ");
			service.updateLeader(mvo);

		}
		List<MemberVO> list = service.selectMember();
		MakeGroupsExecute mge = new MakeGroupsExecute();
		mge.Execute(list, gNum);

		mav.addObject("mlist", service.selectMember());
		mav.addObject("gNum", gNum);

		return mav;
	}

	@RequestMapping("/result.do")
	public ModelAndView resultShowController(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		ModelAndView mav = new ModelAndView("/admin/groupmaker/MakeGroupShow");
		
		List<MemberVO> list = service.selectMember();
		int temp = 0;
		for (int i = 0; i < list.size(); i++) {
			MemberVO mvo = list.get(i);
			int team = Integer.parseInt(mvo.getTeam());
			if (temp < team) {
				temp = team;
			}
		}
		int gNum = temp * 2;
		System.out.println(gNum);

		mav.addObject("mlist", service.selectMember());
		mav.addObject("gNum", gNum);

		return mav;
	}

	@ResponseBody
	@RequestMapping("/remake.json")
	public List<MemberVO> remakeController(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		
		List<MemberVO> list = service.selectMember();
		int temp = 0;
		for (int i = 0; i < list.size(); i++) {
			MemberVO mvo = list.get(i);
			int team = Integer.parseInt(mvo.getTeam());
			if (temp < team) {
				temp = team;
			}
		}
		int gNum = temp * 2;
		System.out.println(gNum);

		MakeGroupsExecute mge = new MakeGroupsExecute();
		mge.Execute(list, gNum);

		return service.selectMember();
	}

	@ResponseBody
	@RequestMapping("/ajax.json")
	public List<MemberVO> MakeGroupsAjax(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		

		

		return service.selectMember();
	}

}