package kr.co.edumis.admin.comment.service;

import java.util.List;
import java.util.Map;

import kr.co.edumis.admin.comment.dao.CommentDAO;
import kr.co.edumis.admin.comment.vo.CommentVO;
import kr.co.edumis.user.member.vo.MemberVO;

public class CommentServiceImpl implements CommentService {

	private CommentDAO dao;
	public CommentServiceImpl(){
		dao = new CommentDAO();
		
	}
	
	@Override
	public List<MemberVO> getList() throws Exception {
		
		List<MemberVO> list = dao.selectList();
		return list;
	}

	@Override
	public MemberVO getSelect(String no) throws Exception {
		MemberVO list = dao.commentSelect(no);
		return list;
	}
	@Override
	public void commentInsert(CommentVO comment) throws Exception {
		dao.commentInsert(comment);
		
	}

	@Override
	public void memberDrop(Map<String, String> drop) throws Exception {
		dao.memberDrop(drop);
		
	}

	@Override
	public List<CommentVO> getcList() throws Exception {
		List<CommentVO> clist = dao.selectcList();
		return clist;
	}


}
