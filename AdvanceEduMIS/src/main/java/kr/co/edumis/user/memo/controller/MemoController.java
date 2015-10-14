package kr.co.edumis.user.memo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.edumis.user.login.vo.LoginVO;
import kr.co.edumis.user.memo.service.MemoService;
import kr.co.edumis.user.memo.vo.MemoVO;

@Controller
@RequestMapping(value={"/user/memo", "/admin/memo"})
public class MemoController {
	
	@Autowired
	private MemoService service;

	@RequestMapping("/open.do")
	public ModelAndView openMemo(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String reqPath = req.getRequestURI();
		String type = reqPath.contains("admin") ? "/admin" : "/user";
		ModelAndView mav = new ModelAndView(type + "/memo/memo");
		HttpSession session = req.getSession();
		LoginVO member = (LoginVO) session.getAttribute("user");
		List<MemoVO> list;
		if (member == null) {
			list = service.getMemoList("0");
		} else {
			list = service.getMemoList("0");//member.getNo() + "");
		}
		mav.addObject("list", list);

		return mav;
	}
	
	@RequestMapping("/delete.json")
	@ResponseBody
	public void deleteMemo(String memoNo) throws Exception{
		service.deleteMemo(memoNo);
	}
	
	@RequestMapping("/insert.json")
	@ResponseBody
	public int insertMemo(MemoVO memo) throws Exception{
		System.out.println(memo);
		service.insertMemo(memo);
		return memo.getMemoNo();
	}
	
	
	@RequestMapping("/update.json")
	@ResponseBody
	public void updateMemo(MemoVO memo) throws Exception{
		service.updateMemo(memo);
	}
	
	
	
	

}
