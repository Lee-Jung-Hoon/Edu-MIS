package kr.co.edumis.admin.comment.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.admin.comment.vo.CommentVO;
import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.member.vo.MemberVO;

public class CommentDAO {
	
	private static SqlSession session = null;
	
	public CommentDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	

	public List<MemberVO> selectList() throws Exception {
		return session.selectList("comment.dao.commentMapper.commentList");
	}

	public MemberVO commentSelect(String id)throws Exception {

		return (MemberVO) session.selectOne("comment.dao.commentMapper.commentSelect", id);
	}

	public void commentInsert(CommentVO comment) throws Exception{
		session.insert("comment.dao.commentMapper.commentInsert",comment);
		session.commit();
	}


	public void memberDrop(Map<String, String> drop) throws Exception{
		session.update("comment.dao.commentMapper.memberDrop",drop);
		session.commit();	
	}

	public void commentModify(CommentVO comment) throws Exception{
		session.update("comment.dao.commentMapper.commentModify",comment);
		session.commit();	
	}
	


}
