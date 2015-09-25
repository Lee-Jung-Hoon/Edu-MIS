package kr.co.edumis.user.memo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.login.vo.LoginVO;
import kr.co.edumis.user.memo.service.MemoService;
import kr.co.edumis.user.memo.service.MemoServiceImpl;
import kr.co.edumis.user.memo.vo.MemoVO;

@Controller
public class MemoController {
	MemoService service;

	public MemoController() {
		service = new MemoServiceImpl();
	}

	@RequestMapping("/user/memo/open.do")
	public ModelAndView openMemo(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/user/memo/memo.jsp");
		HttpSession session = req.getSession();
		LoginVO member = (LoginVO) session.getAttribute("user");
		ArrayList<MemoVO> list;
		if (member == null) {
			list = service.getMemoList("0");
		} else {
			list = service.getMemoList(member.getNo() + "");
		}
		mav.addObject("list", list);

		return mav;
	}

}
