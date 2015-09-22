package kr.co.edumis.user.bookboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.bookboard.service.BookBoardService;
import kr.co.edumis.user.bookboard.service.BookBoardServiceImpl;
import kr.co.edumis.user.bookboard.vo.BookBoardVO;

@Controller
public class BookBoardController {
	private BookBoardService service;
	
	public BookBoardController() {
		service = new BookBoardServiceImpl();
	}

	@RequestMapping("/bookboard/write.do")
	public ModelAndView write(BookBoardVO board ,HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try {
			service.registBoard(board);
			ModelAndView mav = new ModelAndView("redirect:/EduMIS/bookboard/list.do?call=W");
			return mav;
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	@RequestMapping("/bookboard/writeForm.do")
	public ModelAndView writeForm(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		ModelAndView mav = new ModelAndView("redirect:/EduMIS/jsp/user/bookboard/writeForm.jsp");
		return mav;
	}
	
	@RequestMapping("/bookboard/list.do")
	public ModelAndView list(BookBoardVO board, HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		String call = req.getParameter("call");
		try {
			ModelAndView mav = new ModelAndView("/jsp/user/bookboard/list.jsp");
			
			List<BookBoardVO> list = service.getList();
			
			mav.addObject("list", list);
			
			if("W".equals(call)) {
				mav.addObject("msg", "게시글이 등록되었습니다.");
			}
			return mav;
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	@RequestMapping("/bookboard/detail.do")
	public ModelAndView detail(String no, HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		try {
			ModelAndView mav = new ModelAndView("/jsp/user/bookboard/detail.jsp");
			
			BookBoardVO detail = service.getDetail(Integer.parseInt(no));
			
			mav.addObject("board", detail);
			return mav;
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	
}