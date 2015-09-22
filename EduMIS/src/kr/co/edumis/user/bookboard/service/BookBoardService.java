package kr.co.edumis.user.bookboard.service;

import java.util.List;

import kr.co.edumis.user.bookboard.vo.BookBoardVO;

public interface BookBoardService {
	public void registBoard(BookBoardVO board) throws Exception;
	
	public List<BookBoardVO> getList() throws Exception;
	
	public BookBoardVO getDetail(int no) throws Exception;
	
}
