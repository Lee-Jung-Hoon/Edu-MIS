package kr.co.edumis.user.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.edumis.user.member.dao.PostNoDAO;
import kr.co.edumis.user.member.vo.PostNoVO;

@Service
public class PostNoServiceImpl implements PostNoService{
	
	@Autowired
	private PostNoDAO dao;

	
	public List<PostNoVO> getPostNoList(String dong) throws Exception {
		List<PostNoVO> list = dao.getPostNoList(dong);
		return list;
	}
	
	public String getAddr(String zipcode) throws Exception{
		return dao.selectAddr(zipcode);
	}
}
