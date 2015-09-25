package kr.co.edumis.user.videoLecture.service;

import java.util.List;

import kr.co.edumis.user.videoLecture.vo.LecCommentVO;

public interface LecCommentService {

	void lecCommentRegist(LecCommentVO lecComment) throws Exception;

	List<LecCommentVO> lecCommentList(int no) throws Exception;

	void lecCommentDelete(int comno) throws Exception;
}
