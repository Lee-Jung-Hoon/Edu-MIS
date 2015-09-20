package kr.co.edumis.admin.talk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.admin.talk.service.TalkService;
import kr.co.edumis.admin.talk.service.TalkServiceImpl;
import kr.co.edumis.admin.talk.vo.TalkVO;
import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;

@Controller
public class TalkController {
	private TalkService service;
	
	public TalkController(){
		service = new TalkServiceImpl();
	}
	
	@RequestMapping("/talk/receiveList.do")
	public ModelAndView ReceiveTalkList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView();
		
		try {
			List<TalkVO> list =service.selectReceiveTalkList(1);
			mav.addObject("list", list);
			System.out.println(list.get(0).getContent());
			
			mav.setView("/jsp/admin/talk/receiveHistory.jsp");
			return mav;
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	@RequestMapping("/talk/sendList.do")
	public ModelAndView SendTalkList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView();
		
		try {
			List<TalkVO> list =service.selectSendTalkList(1);
			mav.addObject("list", list);			
			System.out.println(list.get(0).getContent());
			
			mav.setView("/jsp/admin/talk/sendHistory.jsp");
			return mav;
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	public ModelAndView DetailTalk(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
				
			mav.setView("/jsp/admin/talk/detailTalk.jsp");
			return mav;
		
	}
}
