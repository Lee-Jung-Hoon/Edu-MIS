package kr.co.edumis.user.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.edumis.user.member.service.PostNoService;
import kr.co.edumis.user.member.vo.PostNoVO;

@Controller
@RequestMapping("/user/member")
public class PostNoController {
	@Autowired
	private PostNoService service;

	@RequestMapping("/PostNo.do")
	public ModelAndView ExamGradeDetail(String dong) throws Exception {
		ModelAndView mav = new ModelAndView("/user/member/post_popup_return");
			List<PostNoVO> list = service.getPostNoList(dong);
			mav.addObject("list", list);
		return mav;
	}
}