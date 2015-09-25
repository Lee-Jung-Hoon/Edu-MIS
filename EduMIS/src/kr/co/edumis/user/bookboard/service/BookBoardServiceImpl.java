package kr.co.edumis.user.bookboard.service;

import java.util.List;
import java.util.Map;

import kr.co.edumis.user.bookboard.dao.BookBoardDAO;
import kr.co.edumis.user.bookboard.vo.BookBoardVO;

public class BookBoardServiceImpl implements BookBoardService{

	private BookBoardDAO dao;
	
	public BookBoardServiceImpl() {
		dao = new BookBoardDAO();
	}
	
	@Override
	public void registBoard(BookBoardVO board) throws Exception {
		dao.insertBoard(board);
	}

	@Override
	public List<BookBoardVO> getList() throws Exception {
		
		return dao.selectBoard();
	}

	@Override
	public BookBoardVO getDetail(int no) throws Exception {
		return dao.detailBoard(no);
	}

	@Override
	public void getDelete(int no) throws Exception {
		dao.deleteBoard(no);
	}

	@Override
	public List<BookBoardVO> searchBoard(Map<String, String> search) throws Exception {
		return dao.searchBoard(search);
	}

	
}
