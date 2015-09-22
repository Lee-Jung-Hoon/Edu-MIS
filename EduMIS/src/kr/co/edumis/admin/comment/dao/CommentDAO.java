package kr.co.edumis.admin.comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.admin.comment.vo.CommentVO;

public class CommentDAO {
	
	private static SqlSession session = null;
	

	public List<CommentVO> selectList() throws Exception {
		return session.selectList("comment.dao.commentMapper.commentList");
	}

}
