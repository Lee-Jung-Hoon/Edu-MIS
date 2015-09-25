package kr.co.edumis.user.vote.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.framework.WebUtil;
import kr.co.edumis.user.vote.service.VoteService;
import kr.co.edumis.user.vote.service.VoteServiceImpl;
import kr.co.edumis.user.vote.vo.VoteVO;

@Controller
public class VoteController {

	private VoteService service;

	public VoteController() {
		service = new VoteServiceImpl();
	}

	@RequestMapping("/user/votelist.do")
	public ModelAndView vote(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		try {
			ModelAndView mav = new ModelAndView("/jsp/user/vote/vote.jsp");
			List<VoteVO> list = service.getList();
			mav.addObject("list", list);
			

			return mav;

		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	@RequestMapping("/user/voteResult.do")
	public ModelAndView voteResult(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		try {
			ModelAndView mav = new ModelAndView("/jsp/user/vote/voteResult.jsp");
			List<VoteVO> list = service.getResult();
			mav.addObject("votelist", list);
			return mav;
		} catch (Exception e) {
			throw new ServletException(e);

		}
	}
	@RequestMapping("/user/voteInsert.do")
	public String voteInsert(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		VoteVO vote = (VoteVO) WebUtil.getFromParamToVO("kr.co.edumis.user.vote.vo.VoteVO", req);
		
	
		try {
			service.voteInsert(vote);
			return "redirect:/EduMIS/user/voteResult.do";
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
