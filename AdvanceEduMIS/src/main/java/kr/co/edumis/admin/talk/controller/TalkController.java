package kr.co.edumis.admin.talk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.edumis.admin.talk.service.TalkService;
import kr.co.edumis.admin.talk.vo.TalkVO;
import kr.co.edumis.user.login.vo.LoginVO;
import kr.co.edumis.user.member.vo.MemberVO;


@Controller
@RequestMapping("/talk")
public class TalkController {
	
	@Autowired
	private TalkService service;

	@ResponseBody
	@RequestMapping("/receiveList.do")
	public List<TalkVO> receiveList(HttpServletRequest req) {
		List<TalkVO> list = null;
		try {
			HttpSession session = req.getSession();
			LoginVO member = (LoginVO)session.getAttribute("admin");
			list = service.selectReList(member.getNo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping("/memberList.do")
	public ModelAndView memberList(HttpServletRequest req) throws Exception {
		req.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView("/jsp/admin/talk/memberList.jsp");
		try {
			List<MemberVO> list = service.selectMemberList();
			System.out.println(list.size());
			mav.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping("/login.do")
	public ModelAndView login(HttpServletRequest req) throws Exception {
		req.setCharacterEncoding("UTF-8");
		LoginVO member = new LoginVO();
		member.setNo(Integer.parseInt(req.getParameter("no")));
		member.setName(req.getParameter("name"));
		member.setGrade(req.getParameter("grade"));
		
		HttpSession session = req.getSession();
		session.setAttribute("admin", member);
		
		
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
	
	@RequestMapping("/recvList.do")
	   public ModelAndView ReceiveTalkList(HttpServletRequest req, HttpServletResponse res){
	      ModelAndView mav = new ModelAndView("/jsp/admin/talk/receiveHistory.jsp");
	      System.out.println("1");

	      // 임시
//	      MemberVO mvo = new MemberVO();
//	      mvo.setNo("3");
//	      hs.setAttribute("user", mvo);

	      HttpSession session = req.getSession();
	      LoginVO member = (LoginVO)session.getAttribute("admin");

	      try {
	         List<TalkVO> list = service.selectReceiveTalkList(member.getNo());
	         System.out.println("2");
	         mav.addObject("list", list);
	         for (TalkVO talk : list) {
	            System.out.println(talk.getNo());
	         }
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
	      return new ModelAndView("redirect:/EduMIS/talk/talkTrash.do");
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
	      return new ModelAndView("redirect:/EduMIS/talk/talkTrash.do");
	   }

	   @RequestMapping("/allCheckDelete.do")
	   public ModelAndView DeleteAllCheckTalk(HttpServletRequest req) {
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

	   @RequestMapping("/sendList.do")
	   public ModelAndView SendTalkList(HttpServletRequest req) {
	      ModelAndView mav = new ModelAndView("/jsp/admin/talk/sendHistory.jsp");

	      HttpSession session = req.getSession();
	      LoginVO member = (LoginVO)session.getAttribute("admin");

	      try {
	         List<TalkVO> list = service.selectSendTalkList(member.getNo());
	         System.out.println(list.size());
	         mav.addObject("list", list);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return mav;
	   }

	   @RequestMapping("/datilTalk.do")
	   public ModelAndView DetailTalk(HttpServletRequest req) {
	      ModelAndView mav = new ModelAndView("/jsp/admin/talk/detailTalk.jsp");
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
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return mav;
	   }

	   @RequestMapping("/insertSendTalk.do")
	   public ModelAndView insertTalk(HttpServletRequest req) {
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

	   @RequestMapping("/deleteTalk.do")
	   public ModelAndView deleteTalk(HttpServletRequest req) {
	      int no = Integer.parseInt(req.getParameter("no"));
	      try {
	         service.deleteTalk(no);

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return new ModelAndView("redirect:/EduMIS/talk/recvList.do");
	   }

	   @RequestMapping("/searchTalk.do")
	   public ModelAndView searchTalk(HttpServletRequest req) {
	      String type = req.getParameter("searchType");
	      String text = req.getParameter("content");

	      HttpSession session = req.getSession();
	      LoginVO member = (LoginVO)session.getAttribute("admin");

	      int no = member.getNo();
	      TalkVO talk = new TalkVO();
	      talk.setName(type);
	      talk.setContent(text);
	      talk.setNo(no);

	      ModelAndView mav = new ModelAndView("/jsp/admin/talk/receiveHistory.jsp");
	      try {
	         if (type.equals("content")) {
	            List<TalkVO> list = service.searchTalk(talk);
	            mav.addObject("list", list);
	         } else {
	            List<TalkVO> list = service.searchNameTalk(talk);
	            mav.addObject("list", list);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return mav;
	   }

	   @RequestMapping("/searchTalk2.do")
	   public ModelAndView searchSendTalk(HttpServletRequest req) {
	      String type = req.getParameter("searchType");
	      String text = req.getParameter("content");

	      HttpSession session = req.getSession();
	      LoginVO member = (LoginVO)session.getAttribute("admin");

	      int no = member.getNo();
	      TalkVO talk = new TalkVO();
	      talk.setName(type);
	      talk.setContent(text);
	      talk.setNo(no);

	      ModelAndView mav = new ModelAndView("/jsp/admin/talk/sendHistory.jsp");
	      try {
	         if (type.equals("content")) {
	            List<TalkVO> list = service.searchTalk2(talk);
	            mav.addObject("list", list);
	         } else {
	            List<TalkVO> list = service.searchNameTalk2(talk);
	            mav.addObject("list", list);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return mav;
	   }

	   @RequestMapping("/talkTrash.do")
	   public ModelAndView TalkTrash(HttpServletRequest req) {
	      ModelAndView mav = new ModelAndView("/jsp/admin/talk/talkTrash.jsp");

	      HttpSession session = req.getSession();
	      LoginVO member = (LoginVO)session.getAttribute("admin");

	      int no = member.getNo();

	      try {
	         List<TalkVO> list = service.talkTrash(no);
	         mav.addObject("list", list);
	         for (TalkVO talk : list) {
	            System.out.println(talk.getNo());
	         }
	         System.out.println();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return mav;
	   }
}
	