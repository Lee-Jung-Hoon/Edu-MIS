package kr.co.edumis.user.bookboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.bookboard.vo.BookBoardVO;

public class BookBoardDAO {

	private static SqlSession session = null;
	
	public BookBoardDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}

	public void insertBoard(BookBoardVO board) {
		session.insert("bookboard.dao.BoardMapper.insertBoard", board);
		session.commit();
	}
	
	public List<BookBoardVO> selectBoard() throws Exception {
		return session.selectList("bookboard.dao.BoardMapper.selectBoard");
	}
	
	public BookBoardVO detailBoard(int no) throws Exception {
		return session.selectOne("bookboard.dao.BoardMapper.detailBoard", no);
	}

}
