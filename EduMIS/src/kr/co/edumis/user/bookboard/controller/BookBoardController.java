package kr.co.edumis.user.bookboard.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.bookboard.service.BookBoardService;
import kr.co.edumis.user.bookboard.service.BookBoardServiceImpl;
import kr.co.edumis.user.bookboard.vo.BookBoardVO;

@Controller
public class BookBoardController {
	private BookBoardService service;
	private static SqlSession sqlMapper;
	
	public BookBoardController() {
		service = new BookBoardServiceImpl();
	}
	
	@RequestMapping("/bookboard/write.do")
	public ModelAndView write(BookBoardVO board, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
			String realPath = req.getServletContext().getRealPath("/bookFile");
		
			File file = new File(realPath);
			if( !file.exists() ) {
				System.out.println(file.mkdirs());
			} else {
				System.out.println("디렉토리 존재함..");
			}
			
			MultipartRequest multi = new MultipartRequest(
		    		req,
		    		realPath,
					1024*1024*10, 
					"UTF-8",
					new DefaultFileRenamePolicy() //파일의 이름이 같을 때 사용할 정책 설정
					);
		    Enumeration<String> e = multi.getFileNames();

//		    BookBoardVO  board = 
//		    		(BookBoardVO)WebUtil.getFromParamToVO(
//		    				"kr.co.edumis.user.bookboard.vo.BookBoardVO", req);
//		    
		    
		  
		      	while(e.hasMoreElements()){
		    	String filename = e.nextElement();
		    	
		    	File f = multi.getFile(filename);
		    	
		    	if(f != null){
		    	
		    	String orgFileName = multi.getOriginalFileName(filename);
		    	String realFileName = multi.getFilesystemName(filename);
		    	
		    	board.setId(multi.getParameter("id"));
		    	board.setTitle(multi.getParameter("title"));
		    	board.setContent(multi.getParameter("content"));
		    	board.setOrgFileName(orgFileName);
		    	board.setRealFileName(realFileName);
		    	board.setFilePath("/bookFile");
		    	}
		    }
		    
			
		    try {
			service.registBoard(board);
			ModelAndView mav = new ModelAndView("redirect:/EduMIS/bookboard/list.do?call=W");
			return mav;
		}catch(Exception e1) {
			throw new ServletException(e1);
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
			
			mav.addObject("board", list);
			
			if("W".equals(call)) {
				mav.addObject("msg", "게시글이 등록되었습니다.");
			}
			else if("D".equals(call)) {
					mav.addObject("msg2", "게시글이 삭제되었습니다.");
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
	
	@RequestMapping("/bookboard/delete.do")
	public ModelAndView delete(String no, HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		try {
			BookBoardVO detail = service.getDetail(Integer.parseInt(no));
			
			
			service.getDelete(Integer.parseInt(no));
			System.out.println("no : " + no);
			ModelAndView mav = new ModelAndView("redirect:/EduMIS/bookboard/list.do?call=D");
			
			mav.addObject("board", detail);
			return mav;
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	@RequestMapping("/bookboard/search.do")
	public ModelAndView search(BookBoardVO board, HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		try {
			ModelAndView mav = new ModelAndView("/jsp/user/bookboard/list.jsp");
			
			Map<String, String> param = new HashMap<String, String>();
			
			param.put("searchType", req.getParameter("choice"));
			if("searchType".equals("no")) {
				Integer.parseInt(req.getParameter("search"));
			}
			param.put("searchWord", req.getParameter("search"));
			
			
			List<BookBoardVO> list = service.searchBoard(param);
			
			mav.addObject("board", list);
			
			System.out.println(req.getParameter("search"));
			
			return mav;
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}

	
	
	
}
