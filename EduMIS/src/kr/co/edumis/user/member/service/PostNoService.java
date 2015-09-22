package kr.co.edumis.user.member.service;

import java.util.List;

import kr.co.edumis.user.member.vo.PostNoVO;

public interface PostNoService {
		public List<PostNoVO> getPostNoList(String dong) throws Exception;
		public String getAddr(String zipcode) throws Exception;
}
