package kr.co.edumis.user.bookboard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.bookboard.vo.BookBoardVO;

public class BookBoardDAO {
	
	private static SqlSession session = null;
	
	public BookBoardDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	public void deleteBoard(int no) {
		session.delete("bookboard.dao.BoardMapper.deleteBoard", no);
		System.out.println(no);
		session.commit();
	}
	
	public void insertBoard(BookBoardVO board) {
		session.insert("bookboard.dao.BoardMapper.insertBoard", board); 
		session.commit();
	}
	
	public List<BookBoardVO> searchBoard(Map<String, String> param) {
		return session.selectList("bookboard.dao.BoardMapper.searchBoard", param);
	}
	
	public List<BookBoardVO> selectBoard() throws Exception {
		return session.selectList("bookboard.dao.BoardMapper.selectBoard");
	}
	
	public BookBoardVO detailBoard(int no) throws Exception {
		return session.selectOne("bookboard.dao.BoardMapper.detailBoard", no);
	}
	
}
