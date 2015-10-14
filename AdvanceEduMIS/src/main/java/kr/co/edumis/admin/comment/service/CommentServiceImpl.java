package kr.co.edumis.admin.comment.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.edumis.admin.comment.dao.CommentDAO;
import kr.co.edumis.admin.comment.vo.CommentVO;
import kr.co.edumis.user.member.vo.MemberVO;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO dao;
	
	
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
	public List<CommentVO> getcList() throws Exception {
		List<CommentVO> clist = dao.selectcList();
		return clist;
	}

	@Override
	public void deleteComment(String no) throws Exception {
		dao.deleteCom(no);
	}

	@Override
	public CommentVO selectOneComment() throws Exception {
		return dao.selectLast();
	}


	/*
	@Override
	public void memberDrop(Map<String, String> drop) throws Exception {
		dao.memberDrop(drop);
		
	}

	 */
}
