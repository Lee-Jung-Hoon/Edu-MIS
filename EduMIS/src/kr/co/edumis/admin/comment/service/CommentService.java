package kr.co.edumis.admin.comment.service;

import java.util.List;

import kr.co.edumis.admin.comment.vo.CommentVO;

public interface CommentService {


	public List<CommentVO> getList() throws Exception;

}
