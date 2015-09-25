package kr.co.edumis.user.bookboard.service;

import java.util.List;
import java.util.Map;

import kr.co.edumis.user.bookboard.vo.BookBoardVO;

public interface BookBoardService {
	public void registBoard(BookBoardVO board) throws Exception;

	public List<BookBoardVO> getList() throws Exception;
	
	public BookBoardVO getDetail(int no) throws Exception;
	
	public void getDelete(int no) throws Exception;

	public List<BookBoardVO> searchBoard(Map<String, String> search) throws Exception;
}
 