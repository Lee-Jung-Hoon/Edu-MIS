package kr.co.edumis.user.mypage.service;

import kr.co.edumis.user.mypage.vo.MypageVO;

public interface MypageService {

	MypageVO getMyInfo(String id) throws Exception;

	void updateMyinfo(MypageVO mvo) throws Exception;

}
