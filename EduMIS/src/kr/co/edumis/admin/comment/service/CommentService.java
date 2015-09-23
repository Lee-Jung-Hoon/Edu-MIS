package kr.co.edumis.admin.comment.service;

import java.util.List;
import java.util.Map;

import kr.co.edumis.admin.comment.vo.CommentVO;

public interface CommentService {


	public List<CommentVO> getList() throws Exception;

	public CommentVO getSelect(String no) throws Exception;

	public void commentInsert(CommentVO comment) throws Exception;

	public void memberDrop(Map<String, String> drop) throws Exception;


}
