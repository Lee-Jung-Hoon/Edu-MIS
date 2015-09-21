package kr.co.edumis.user.memo.controller;

import java.util.ArrayList;

import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.memo.service.MemoService;
import kr.co.edumis.user.memo.service.MemoServiceImpl;
import kr.co.edumis.user.memo.vo.MemoVO;

@Controller
public class MemoController {
	MemoService service;

	public MemoController() {
		service = new MemoServiceImpl();
	}
	
	@RequestMapping("/memo/open.do")
	public ModelAndView openMemo() throws Exception{
		ModelAndView mav = new ModelAndView("/template/memo.jsp");
		ArrayList<MemoVO> list = service.getMemoList();
		
		mav.addObject("list", list);
		
		return mav;
	}
	

}
