package kr.co.edumis.admin.comment.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.admin.comment.service.CommentService;
import kr.co.edumis.admin.comment.service.CommentServiceImpl;
import kr.co.edumis.admin.comment.vo.CommentVO;
import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.framework.WebUtil;
import kr.co.edumis.user.member.vo.MemberVO;

@Controller
public class CommentController {

	private CommentService service;

	public CommentController() {
		service = new CommentServiceImpl();
	}
	//수강생 목록
	@RequestMapping("/admin/commentList.do")
	public ModelAndView CommentList(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		try {
			ModelAndView mav = new ModelAndView("/jsp/admin/comment/commentList.jsp");
			List<MemberVO> list = service.getList();
			List<CommentVO> clist=service.getcList();
			
			System.out.println("clist : " + clist.size());
			
			
			mav.addObject("list", list);
			mav.addObject("clist", clist);
			return mav;
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	//수강생 정보(팝업!)
	@RequestMapping("/admin/commentSelect.do")
	public ModelAndView commentSelect(String id, HttpServletRequest req)
			throws ServletException, IOException {
		try{
			
			ModelAndView mav = new ModelAndView("/jsp/admin/comment/commentDetail.jsp");
			MemberVO vo =service.getSelect(req.getParameter("id"));
			mav.addObject("vo", vo);
			return mav;
		}catch(Exception e){
			throw new ServletException(e);
		}
		
	}
	
	
	
	
	
	//코멘트 등록
	@RequestMapping("/admin/commentInsert.do")
	public String commentInsert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		CommentVO comment = (CommentVO) WebUtil.getFromParamToVO("kr.co.edumis.admin.comment.vo.CommentVO", req);

		try {
			service.commentInsert(comment);
			return "redirect:/EduMIS/admin/commentList.do";
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	@RequestMapping("/admin/memberDrop.do")
	public String memberDrop(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		try {
			 Map<String, String> drop = new HashMap<>();
			 String id = req.getParameter("id");
			 String drop_reason = req.getParameter("drop_reason");
			 drop.put("id", id);
			 drop.put("drop_reason", drop_reason);
			service.memberDrop(drop);
			
			return "redirect:/EduMIS/user/commentList.do";
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
