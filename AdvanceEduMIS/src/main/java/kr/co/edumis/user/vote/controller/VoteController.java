package kr.co.edumis.user.vote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.edumis.user.vote.service.VoteService;
import kr.co.edumis.user.vote.vo.VoteVO;

@Controller
@RequestMapping("/user")
public class VoteController {

	@Autowired
	private VoteService service;

	@RequestMapping("/votelist.do")
	public ModelAndView vote()throws Exception{
			ModelAndView mav = new ModelAndView("/user/vote/vote");
			List<VoteVO> list = service.getList();
			mav.addObject("list", list);
			return mav;

	}

	
	@RequestMapping("/voteResult.do")
	public ModelAndView voteResult()throws Exception{
			ModelAndView mav = new ModelAndView("/user/vote/voteResult");
			List<VoteVO> list = service.getResult();
			mav.addObject("votelist", list);
			return mav;
		
	}
	
	@RequestMapping("/voteInsert.do")
	public String voteInsert(VoteVO vote)throws Exception {
			service.voteInsert(vote);
			return "redirect:voteResult.do";
	}

	
}
