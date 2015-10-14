package kr.co.edumis.admin.talk.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.edumis.admin.talk.service.TalkService;
import kr.co.edumis.admin.talk.vo.TalkVO;
import kr.co.edumis.user.login.vo.LoginVO;
import kr.co.edumis.user.member.vo.MemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/talk")
public class TalkController {
	
	@Autowired
	private TalkService service;

	@RequestMapping("/receiveList.do")
	public ModelAndView receiveList(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("admin/talk/receiveList");
		try {
			HttpSession session = req.getSession();
			LoginVO member = (LoginVO)session.getAttribute("admin");
			List<TalkVO> list = service.selectReList(member.getNo());
			mav.addObject("size", list.size());
			mav.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/memberList.do")
	public ModelAndView memberList(HttpSession session){
		ModelAndView mav = new ModelAndView("admin/talk/memberList");
		LoginVO member = (LoginVO)session.getAttribute("admin");
		try {
			System.out.println("no : " + member.getNo());
			List<MemberVO> list = service.selectMemberList(member.getNo());
			System.out.println(list.size());
			mav.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/recvList.do")
	   public ModelAndView ReceiveTalkList(HttpServletRequest req, HttpServletResponse res){
	      ModelAndView mav = new ModelAndView("admin/talk/receiveHistory");
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
	   public String DeleteCheckTalk(HttpServletRequest req, HttpServletResponse res) {
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
	            return "redirect:/talk/recvList.do";
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
	         return "redirect:/talk/recvList.do";
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return null;//jsp바꺼 다쉬면//jsp바꺼 다쉬면//jsp바꺼 다쉬면//jsp바꺼 다쉬면
	   }
	   @RequestMapping("/reviveTalk.do")
	   public String ReviveCheckTalk(HttpServletRequest req){
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
	      return "redirect:/talk/recvList.do";
	   }

	   @RequestMapping("/realDelete.do")
	   public String RealDeleteCheckTalk(HttpServletRequest req) {
	      
	      
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
	      return "redirect:/talk/recvList.do";
	   }

	   @RequestMapping("/allCheckDelete.do")
	   public String DeleteAllCheckTalk(HttpServletRequest req) {
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
	      return "redirect:/talk/recvList.do";
	   }

	   @RequestMapping("/sendList.do")
	   public ModelAndView SendTalkList(HttpServletRequest req) {
	      ModelAndView mav = new ModelAndView("admin/talk/sendHistory");

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
	      ModelAndView mav = new ModelAndView("admin/talk/detailTalk");
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
	   public String insertTalk(HttpServletRequest req) {
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
	      return "redirect:/talk/recvList.do";
	   }

	   @RequestMapping("/deleteTalk.do")
	   public String deleteTalk(HttpServletRequest req) {
	      int no = Integer.parseInt(req.getParameter("no"));
	      try {
	         service.deleteTalk(no);

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return "redirect:/talk/recvList.do";
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

	      ModelAndView mav = new ModelAndView("admin/talk/receiveHistory");
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

	      ModelAndView mav = new ModelAndView("admin/talk/sendHistory");
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
	      ModelAndView mav = new ModelAndView("admin/talk/talkTrash");

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
	   
	   
	   //톡 답변
	   @ResponseBody
	   @RequestMapping("/reTalk.do")
	   public void sendReTalk(HttpServletRequest req){
		   	HttpSession session = req.getSession();
			LoginVO member = (LoginVO)session.getAttribute("admin");
			String content = req.getParameter("content");
			int no = Integer.parseInt(req.getParameter("no"));
			try {
				service.updateCheck(no);
				TalkVO talk = service.selectNo(no); // 글번호로 보낸 사람 번호와 부모 넘버를 받아옴(부모번호, 보낸사람번호, 받는사람 번호, 내용,)
				talk.setReceiveMemberNo(talk.getSendMemberNo());
				talk.setSendMemberNo(member.getNo()); // session number 로 지정해야 함
				talk.setContent(content);
				service.insertTalk(talk);
			} catch (Exception e) {
				e.printStackTrace();
			}
	   }
	   
		@ResponseBody
		@RequestMapping("/newTalk.do")
		public void sendNewTalk(HttpServletRequest req) {
			HttpSession session = req.getSession();
			LoginVO member = (LoginVO) session.getAttribute("admin");
			String content = req.getParameter("content");
			String[] arr = req.getParameter("name").split("/");
			try {
				for (int i = 1; i < arr.length; i++) {
					TalkVO talk = new TalkVO();
					int seq;
					seq = service.selectSeq();
					talk.setNo(seq);
					talk.setpNo(seq);
					talk.setSendMemberNo(member.getNo()); // session number 로 지정해야 함
					talk.setReceiveMemberNo(Integer.parseInt(arr[i]));
					talk.setContent(content);
					service.insertNewTalk(talk);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@ResponseBody
		@RequestMapping("/sub.do")
		public void getCount(HttpServletRequest req, HttpServletResponse res){
			HttpSession session = req.getSession();
			LoginVO member = (LoginVO) session.getAttribute("admin");
			try {
				List<TalkVO> list = service.selectReList(member.getNo());
				PrintWriter out = res.getWriter();
				out.println(list.size());
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@ResponseBody
		@RequestMapping("/changeCheck.do")
		public void changeCheck(int no){
//			int no = Integer.parseInt(req.getParameter("no"));
			try {
				service.updateCheck(no);
			} catch (Exception e) {
				e.printStackTrace();
			} // 체크로 update
		}
}
