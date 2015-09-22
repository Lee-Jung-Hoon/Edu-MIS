package kr.co.edumis.user.mypage.service;

import java.util.List;

import kr.co.edumis.user.mypage.vo.MypageVO;

public interface MypageService {
	public List<MypageVO> getMyinfo(String id) throws Exception;
}
