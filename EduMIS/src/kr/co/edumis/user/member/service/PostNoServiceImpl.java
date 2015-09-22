package kr.co.edumis.user.member.service;

import java.util.List;

import kr.co.edumis.user.member.dao.PostNoDAO;
import kr.co.edumis.user.member.vo.PostNoVO;

public class PostNoServiceImpl implements PostNoService{
	private PostNoDAO dao = null;
	
	public PostNoServiceImpl() {
		dao = new PostNoDAO();
	}
	
	public List<PostNoVO> getPostNoList(String dong) throws Exception {
		List<PostNoVO> list = dao.getPostNoList(dong);
		return list;
	}
}
