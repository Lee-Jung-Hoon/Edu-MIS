package kr.co.edumis.admin.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.edumis.admin.comment.service.CommentService;
import kr.co.edumis.admin.comment.vo.CommentVO;
import kr.co.edumis.user.member.vo.MemberVO;

@Controller
@RequestMapping("/admin")
public class CommentController {

	@Autowired
	private CommentService service;

	
	//수강생 목록
	@RequestMapping("/commentList.do")
	public ModelAndView CommentList()throws Exception{

		
			ModelAndView mav = new ModelAndView("/admin/comment/commentList");
			List<MemberVO> list = service.getList();
			List<CommentVO> clist=service.getcList();

			mav.addObject("list", list);
			mav.addObject("clist", clist);
			
			return mav;
		
	}
	
	//수강생 정보(팝업!)
	@RequestMapping("/commentSelect.do")
	public ModelAndView commentSelect(String id)throws Exception{
		
			ModelAndView mav = new ModelAndView("/admin/comment/commentDetail");
			MemberVO vo =service.getSelect(id);
			mav.addObject("vo", vo);
			return mav;
	
	}
	
	

	
	
	
	/*
	//코멘트 등록
	@RequestMapping("/commentInsert.do")
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
 */
}
