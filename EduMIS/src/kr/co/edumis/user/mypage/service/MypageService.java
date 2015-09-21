package kr.co.edumis.user.mypage.service;

import kr.co.edumis.user.mypage.vo.MypageVO;

public interface MypageService {
	public MypageVO getMyinfo(String id) throws Exception;
}
