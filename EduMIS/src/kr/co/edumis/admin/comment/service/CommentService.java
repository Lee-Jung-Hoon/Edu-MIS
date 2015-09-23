package kr.co.edumis.admin.comment.service;

import java.util.List;
import java.util.Map;

import kr.co.edumis.admin.comment.vo.CommentVO;
import kr.co.edumis.user.member.vo.MemberVO;

public interface CommentService {


	public List<MemberVO> getList() throws Exception;

	public MemberVO getSelect(String id) throws Exception;

	public void commentInsert(CommentVO comment) throws Exception;

	public void memberDrop(Map<String, String> drop) throws Exception;


}
