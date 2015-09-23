package kr.co.edumis.admin.comment.service;

import java.util.List;

import kr.co.edumis.admin.comment.dao.CommentDAO;
import kr.co.edumis.admin.comment.vo.CommentVO;

public class CommentServiceImpl implements CommentService {

	private CommentDAO dao;
	public CommentServiceImpl(){
		dao = new CommentDAO();
		
	}
	
	@Override
	public List<CommentVO> getList() throws Exception {
		
		List<CommentVO> list = dao.selectList();
		return list;
	}

	@Override
	public CommentVO getSelect(String no) throws Exception {
		CommentVO list = dao.commentSelect(no);
		return list;
	}
	@Override
	public void commentInsert(CommentVO comment) throws Exception {
		dao.commentInsert(comment);
		
	}

	@Override
	public void memberDrop(String id) throws Exception {
		dao.memberDrop(id);
		
	}


}
