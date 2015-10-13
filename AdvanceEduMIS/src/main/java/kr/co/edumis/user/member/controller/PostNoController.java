package kr.co.edumis.user.member.controller;

import java.util.List;

import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.member.service.PostNoService;
import kr.co.edumis.user.member.service.PostNoServiceImpl;
import kr.co.edumis.user.member.vo.PostNoVO;

@Controller
public class PostNoController {
	private PostNoService service;

	public PostNoController() {
		service = new PostNoServiceImpl();
	}
	
	@RequestMapping("/postno/PostNo.do")
	public ModelAndView ExamGradeDetail(String dong) {
		ModelAndView mav = new ModelAndView("/jsp/user/member/post_popup_return.jsp");

		try {
			List<PostNoVO> list = service.getPostNoList(dong);
			mav.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}