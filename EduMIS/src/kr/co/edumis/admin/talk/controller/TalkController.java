package kr.co.edumis.admin.talk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.edumis.admin.talk.service.TalkService;
import kr.co.edumis.admin.talk.service.TalkServiceImpl;
import kr.co.edumis.admin.talk.vo.MemberTestVO;
import kr.co.edumis.admin.talk.vo.TalkVO;
import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.member.vo.MemberVO;

@Controller
public class TalkController {
	private TalkService service;

	public TalkController() {
		service = new TalkServiceImpl();
	}

	@RequestMapping("/talk/receiveList.do")
	public ModelAndView receiveList(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("/jsp/admin/talk/receiveList.jsp");
		try {
			HttpSession session = req.getSession();
			MemberTestVO member = (MemberTestVO)session.getAttribute("member");
			
			List<TalkVO> list = service.selectReList(member.getNo());
			System.out.println("size" + list.size());
			mav.addObject("size", list.size());
			mav.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/talk/memberList.do")
	public ModelAndView memberList(HttpServletRequest req) throws Exception {
		req.setCharacterEncoding("UTF-8");
		MemberTestVO member = new MemberTestVO();
		member.setNo(Integer.parseInt(req.getParameter("no")));
		member.setName(req.getParameter("name"));
		member.setGrade(req.getParameter("grade"));
		
		HttpSession session = req.getSession();
		session.setAttribute("member", member);
		
//		MemberTestVO test = (MemberTestVO)session.getAttribute("member");
		
		
//		ModelAndView mav = new ModelAndView("/jsp/admin/main.jsp");
		ModelAndView mav = new ModelAndView("/template/global_memo02.jsp");
		try {
			List<MemberVO> list = service.selectMemberList();
			System.out.println(list.size());
			mav.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/talk/recvList.do")
	public ModelAndView ReceiveTalkList(HttpServletRequest req, HttpServletResponse res){
		ModelAndView mav = new ModelAndView();
		System.out.println("1");

		// 임시
		HttpSession hs = req.getSession();
		MemberVO mvo = new MemberVO();
		mvo.setNo("3");
		hs.setAttribute("user", mvo);

		// MemberVO mvo = (MemberVO)hs.getAttribute("user");
		int no = Integer.parseInt(mvo.getNo());

		try {
			List<TalkVO> list = service.selectReceiveTalkList(no);
			System.out.println("2");
			mav.addObject("list", list);
			for (TalkVO talk : list) {
				System.out.println(talk.getNo());
			}
			System.out.println();
			mav.setView("/jsp/admin/talk/receiveHistory.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/talk/checkDelete.do")
	public ModelAndView DeleteCheckTalk(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView();

		String type = req.getParameter("type");

		String[] delList = req.getParameterValues("delCheck");
		try {
			if (type.equals("receive_del")) {
				for (int i = 0; i < delList.length; i++) {
					int tNo = Integer.parseInt(delList[i]);
					TalkVO talk = new TalkVO();
					talk.setNo(tNo);
					talk.setName(type);
					System.out.println(talk.getName());
					service.deleteCheckTalk(talk);
				}
				return new ModelAndView("redirect:/EduMIS/talk/recvList.do");
			} else {
				for (int i = 0; i < delList.length; i++) {
					int tNo = Integer.parseInt(delList[i]);
					TalkVO talk = new TalkVO();
					talk.setNo(tNo);
					talk.setName(type);
					System.out.println(talk.getName());
					service.deleteCheckTalk(talk);
				}
			}
			return new ModelAndView("redirect:/EduMIS/talk/sendList.do");
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}
	@RequestMapping("/talk/reviveTalk.do")
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
		return new ModelAndView("redirect:/EduMIS/talk/talkTrash.do");
	}

	@RequestMapping("/talk/realDelete.do")
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
		return new ModelAndView("redirect:/EduMIS/talk/talkTrash.do");
	}

	@RequestMapping("/talk/allCheckDelete.do")
	public ModelAndView DeleteAllCheckTalk(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView();

		String type = req.getParameter("type");

		String[] delList = req.getParameterValues("delCheck");
		try {
			if (type.equals("receive_del")) {
				for (int i = 0; i < delList.length; i++) {
					int tNo = Integer.parseInt(delList[i]);
					TalkVO talk = new TalkVO();
					talk.setNo(tNo);
					talk.setName(type);
					System.out.println(talk.getName());
					service.deleteCheckTalk(talk);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/EduMIS/talk/recvList.do");
	}

	@RequestMapping("/talk/sendList.do")
	public ModelAndView SendTalkList(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView();

		HttpSession hs = req.getSession();
		MemberVO mvo = (MemberVO) hs.getAttribute("user");

		int no = Integer.parseInt(mvo.getNo());

		try {
			List<TalkVO> list = service.selectSendTalkList(no);
			System.out.println(list.size());
			mav.addObject("list", list);

			mav.setView("/jsp/admin/talk/sendHistory.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/talk/datilTalk.do")
	public ModelAndView DetailTalk(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView();
		System.out.println("no : " + req.getParameter("no"));
		int tNo = Integer.parseInt(req.getParameter("no"));
		String name = req.getParameter("name");
		int sendmNo = Integer.parseInt(req.getParameter("sendNo"));
		int receivemNo = Integer.parseInt(req.getParameter("receiveNo"));
		int pNo = Integer.parseInt(req.getParameter("pNo"));

		try {

			TalkVO talk = service.selectDetailTalk(tNo);
			service.setCheck(tNo);
			talk.setNo(tNo);
			talk.setName(name);
			talk.setSendMemberNo(sendmNo);
			talk.setReceiveMemberNo(receivemNo);
			talk.setpNo(pNo);
			mav.addObject("detail", talk);
			mav.setView("/jsp/admin/talk/detailTalk.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/talk/insertSendTalk.do")
	public ModelAndView insertTalk(HttpServletRequest req, HttpServletResponse res) {
		int sendmNo = Integer.parseInt(req.getParameter("sendMemberNo"));
		int receivemNo = Integer.parseInt(req.getParameter("receiveMemberNo"));
		int tNo = Integer.parseInt(req.getParameter("tNo"));
		int pNo = Integer.parseInt(req.getParameter("pNo"));
		String content = req.getParameter("content");
		try {
			TalkVO talk = new TalkVO();
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
		return new ModelAndView("redirect:/EduMIS/talk/recvList.do");
	}

	@RequestMapping("/talk/deleteTalk.do")
	public ModelAndView deleteTalk(HttpServletRequest req, HttpServletResponse res) {
		int no = Integer.parseInt(req.getParameter("no"));
		try {
			service.deleteTalk(no);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/EduMIS/talk/recvList.do");
	}

	@RequestMapping("/talk/searchTalk.do")
	public ModelAndView searchTalk(HttpServletRequest req, HttpServletResponse res) {
		String type = req.getParameter("searchType");
		String text = req.getParameter("searchTalk");

		HttpSession hs = req.getSession();
		MemberVO mvo = (MemberVO) hs.getAttribute("user");

		int no = Integer.parseInt(mvo.getNo());

		ModelAndView mav = new ModelAndView("/jsp/admin/talk/receiveHistory.jsp");
		try {
			if (type.equals("content")) {
				TalkVO talk = new TalkVO();
				talk.setName(type);
				talk.setContent(text);
				talk.setNo(no);
				List<TalkVO> list = service.searchTalk(talk);
				mav.addObject("list", list);
			} else {
				TalkVO talk = new TalkVO();
				talk.setName(type);
				talk.setContent(text);
				talk.setNo(no);
				List<TalkVO> list = service.searchNameTalk(talk);
				mav.addObject("list", list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/talk/searchTalk2.do")
	public ModelAndView searchSendTalk(HttpServletRequest req, HttpServletResponse res) {
		String type = req.getParameter("searchType");
		String text = req.getParameter("searchTalk");

		HttpSession hs = req.getSession();
		MemberVO mvo = (MemberVO) hs.getAttribute("user");

		int no = Integer.parseInt(mvo.getNo());

		ModelAndView mav = new ModelAndView("/jsp/admin/talk/sendHistory.jsp");
		try {
			if (type.equals("content")) {
				TalkVO talk = new TalkVO();
				talk.setName(type);
				talk.setContent(text);
				talk.setNo(no);
				List<TalkVO> list = service.searchTalk2(talk);
				mav.addObject("list", list);
			} else {
				TalkVO talk = new TalkVO();
				talk.setName(type);
				talk.setContent(text);
				talk.setNo(no);
				List<TalkVO> list = service.searchNameTalk2(talk);
				mav.addObject("list", list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/talk/talkTrash.do")
	public ModelAndView TalkTrash(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView();

		HttpSession hs = req.getSession();
		MemberVO mvo = (MemberVO) hs.getAttribute("user");

		int no = Integer.parseInt(mvo.getNo());

		try {
			List<TalkVO> list = service.talkTrash(no);
			mav.addObject("list", list);
			for (TalkVO talk : list) {
				System.out.println(talk.getNo());
			}
			System.out.println();
			mav.setView("/jsp/admin/talk/talkTrash.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
