package kr.co.edumis.user.videoLecture.service;

import java.util.List;

import kr.co.edumis.user.videoLecture.dao.LecCommentDAO;
import kr.co.edumis.user.videoLecture.vo.LecCommentVO;

public class LecCommentServiceImpl implements LecCommentService{
	private LecCommentDAO dao;
	
	public LecCommentServiceImpl(){
		dao = new LecCommentDAO();
	}

	@Override
	public void lecCommentRegist(LecCommentVO lecComment) {
		dao.lecCommentRegist(lecComment);
	}

	@Override
	public List<LecCommentVO> lecCommentList(int no) throws Exception {
		List<LecCommentVO> list = dao.lecCommentList(no);
		return list;
	}

}
