package kr.co.edumis.user.talk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.edumis.user.login.vo.LoginVO;
import kr.co.edumis.user.member.vo.MemberVO;
import kr.co.edumis.user.talk.service.TalkService;
import kr.co.edumis.user.talk.service.TalkUserServiceImpl;
import kr.co.edumis.user.talk.vo.TalkUserVO;

@Controller
@RequestMapping("/talk/user")
public class TalkUserController {
	
	@Autowired
	private TalkService service;
	

	@RequestMapping("/receiveList.do")
	public ModelAndView receiveList(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("user/talk/receiveList");
		try {
			HttpSession session = req.getSession();
			LoginVO member = (LoginVO)session.getAttribute("user");
			
			List<TalkUserVO> list = service.selectReList(member.getNo());
			System.out.println("size" + list.size());
			mav.addObject("size", list.size());
			mav.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		return mav;
	}
	
	@RequestMapping("/memberList.do")
	public ModelAndView memberList(HttpServletRequest req) throws Exception {
		req.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView("user/talk/memberList");
		try {
			HttpSession session = req.getSession();
			LoginVO member = (LoginVO)session.getAttribute("user");
			List<MemberVO> list = service.selectMemberList(member.getNo());
			System.out.println(list.size());
			mav.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
//	@RequestMapping("/talk/user/login.do")
//	public ModelAndView login(HttpServletRequest req) throws Exception {
//		req.setCharacterEncoding("UTF-8");
//		LoginVO member = new LoginVO();
//		member.setNo(Integer.parseInt(req.getParameter("no")));
//		member.setName(req.getParameter("name"));
//		member.setGrade(req.getParameter("grade"));
//		
//		HttpSession session = req.getSession();
//		session.setAttribute("member", member);
//		
//		
////		ModelAndView mav = new ModelAndView("/jsp/user/main.jsp");
//		ModelAndView mav = new ModelAndView("/template/global_memo02.jsp");
//		try {
//			List<MemberVO> list = service.selectMemberList();
//			System.out.println(list.size());
//			mav.addObject("list", list);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return mav;
//	}
	
	@RequestMapping("/recvList.do")
	public ModelAndView ReceiveTalkList(HttpServletRequest req, HttpServletResponse res){
		ModelAndView mav = new ModelAndView("user/talk/receiveHistory");
		System.out.println("1");

		// 임시
//		MemberVO mvo = new MemberVO();
//		mvo.setNo("3");
//		hs.setAttribute("user", mvo);

		HttpSession session = req.getSession();
		LoginVO member = (LoginVO)session.getAttribute("user");

		try {
			List<TalkUserVO> list = service.selectReceiveTalkList(member.getNo());
			System.out.println("2");
			mav.addObject("list", list);
			for (TalkUserVO talk : list) {
				System.out.println(talk.getNo());
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/checkDelete.do")
	public ModelAndView DeleteCheckTalk(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView();

		String type = req.getParameter("type");

		String[] delList = req.getParameterValues("delCheck");
		try {
			if (type.equals("receive_del")) {
				for (int i = 0; i < delList.length; i++) {
					int tNo = Integer.parseInt(delList[i]);
					TalkUserVO talk = new TalkUserVO();
					talk.setNo(tNo);
					talk.setName(type);
					System.out.println(talk.getName());
					service.deleteCheckTalk(talk);
				}
				return new ModelAndView("redirect:/AdvanceEduMIS/talk/user/recvList.do");
			} else {
				for (int i = 0; i < delList.length; i++) {
					int tNo = Integer.parseInt(delList[i]);
					TalkUserVO talk = new TalkUserVO();
					talk.setNo(tNo);
					talk.setName(type);
					System.out.println(talk.getName());
					service.deleteCheckTalk(talk);
				}
			}
			return new ModelAndView("redirect:/AdvanceEduMIS/talk/user/sendList.do");
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}
	@RequestMapping("/reviveTalk.do")
	public ModelAndView ReviveCheckTalk(HttpServletRequest req, HttpServletResponse res){
		ModelAndView mav = new ModelAndView();
		
		String[] delList = req.getParameter("delCheck").split(",");
		try {
				for (int i = 0; i < delList.length; i++) {
					int tNo = Integer.parseInt(delList[i]);
					service.reviveCheckTalk(tNo);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/AdvanceEduMIS/talk/user/talkTrash.do");
	}

	@RequestMapping("/realDelete.do")
	public ModelAndView RealDeleteCheckTalk(HttpServletRequest req, HttpServletResponse res) {
		
		
		ModelAndView mav = new ModelAndView();

		String[] delList = req.getParameter("delCheck").split(",");
		try {
			for (int i = 0; i < delList.length; i++) {
				int tNo = Integer.parseInt(delList[i]);
				service.realDeleteCheckTalk(tNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/AdvanceEduMIS/talk/user/talkTrash.do");
	}

	@RequestMapping("/allCheckDelete.do")
	public ModelAndView DeleteAllCheckTalk(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView();

		String type = req.getParameter("type");

		String[] delList = req.getParameterValues("delCheck");
		try {
			if (type.equals("receive_del")) {
				for (int i = 0; i < delList.length; i++) {
					int tNo = Integer.parseInt(delList[i]);
					TalkUserVO talk = new TalkUserVO();
					talk.setNo(tNo);
					talk.setName(type);
					System.out.println(talk.getName());
					service.deleteCheckTalk(talk);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/AdvanceEduMIS/talk/user/recvList.do");
	}

	@RequestMapping("/sendList.do")
	public ModelAndView SendTalkList(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView("user/talk/sendHistory");

		HttpSession session = req.getSession();
		LoginVO member = (LoginVO)session.getAttribute("user");

		try {
			List<TalkUserVO> list = service.selectSendTalkList(member.getNo());
			System.out.println(list.size());
			mav.addObject("list", list);

//			mav.setView();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/datilTalk.do")
	public ModelAndView DetailTalk(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView("user/talk/detailTalk");
		System.out.println("no : " + req.getParameter("no"));
		int tNo = Integer.parseInt(req.getParameter("no"));
		String name = req.getParameter("name");
		int sendmNo = Integer.parseInt(req.getParameter("sendNo"));
		int receivemNo = Integer.parseInt(req.getParameter("receiveNo"));
		int pNo = Integer.parseInt(req.getParameter("pNo"));

		try {

			TalkUserVO talk = service.selectDetailTalk(tNo);
			service.setCheck(tNo);
			talk.setNo(tNo);
			talk.setName(name);
			talk.setSendMemberNo(sendmNo);
			talk.setReceiveMemberNo(receivemNo);
			talk.setpNo(pNo);
			mav.addObject("detail", talk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/insertSendTalk.do")
	public ModelAndView insertTalk(HttpServletRequest req, HttpServletResponse res) {
		int sendmNo = Integer.parseInt(req.getParameter("sendMemberNo"));
		int receivemNo = Integer.parseInt(req.getParameter("receiveMemberNo"));
		int tNo = Integer.parseInt(req.getParameter("tNo"));
		int pNo = Integer.parseInt(req.getParameter("pNo"));
		String content = req.getParameter("content");
		try {
			TalkUserVO talk = new TalkUserVO();
			talk.setSendMemberNo(sendmNo);
			talk.setReceiveMemberNo(receivemNo);
			talk.setContent(content);
			talk.setpNo(pNo);
			talk.setNo(tNo);

			System.out.println(pNo);
			service.insertSendTalk(talk);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/AdvanceEduMIS/talk/user/recvList.do");
	}

	@RequestMapping("/deleteTalk.do")
	public ModelAndView deleteTalk(HttpServletRequest req, HttpServletResponse res) {
		int no = Integer.parseInt(req.getParameter("no"));
		try {
			service.deleteTalk(no);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/AdvanceEduMIS/talk/user/recvList.do");
	}

	@RequestMapping("/searchTalk.do")
	public ModelAndView searchTalk(HttpServletRequest req, HttpServletResponse res) {
		String type = req.getParameter("searchType");
		String text = req.getParameter("searchTalk");

		HttpSession session = req.getSession();
		LoginVO member = (LoginVO)session.getAttribute("user");

		int no = member.getNo();
		TalkUserVO talk = new TalkUserVO();
		talk.setName(type);
		talk.setContent(text);
		talk.setNo(no);

		ModelAndView mav = new ModelAndView("user/talk/receiveHistory");
		try {
			if (type.equals("content")) {
				List<TalkUserVO> list = service.searchTalk(talk);
				mav.addObject("list", list);
			} else {
				List<TalkUserVO> list = service.searchNameTalk(talk);
				mav.addObject("list", list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/searchTalk2.do")
	public ModelAndView searchSendTalk(HttpServletRequest req, HttpServletResponse res) {
		String type = req.getParameter("searchType");
		String text = req.getParameter("searchTalk");

		HttpSession session = req.getSession();
		LoginVO member = (LoginVO)session.getAttribute("user");

		int no = member.getNo();
		TalkUserVO talk = new TalkUserVO();
		talk.setName(type);
		talk.setContent(text);
		talk.setNo(no);

		ModelAndView mav = new ModelAndView("user/talk/sendHistory");
		try {
			if (type.equals("content")) {
				List<TalkUserVO> list = service.searchTalk2(talk);
				mav.addObject("list", list);
			} else {
				List<TalkUserVO> list = service.searchNameTalk2(talk);
				mav.addObject("list", list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/talkTrash.do")
	public ModelAndView TalkTrash(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("user/talk/talkTrash.jsp");

		HttpSession session = req.getSession();
		LoginVO member = (LoginVO)session.getAttribute("user");

		int no = member.getNo();

		try {
			List<TalkUserVO> list = service.talkTrash(no);
			mav.addObject("list", list);
			for (TalkUserVO talk : list) {
				System.out.println(talk.getNo());
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
	