package kr.co.edumis.user.mypage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.edumis.user.mypage.dao.MypageDAO;
import kr.co.edumis.user.mypage.vo.MypageVO;

@Service
public class MypageServiceImpl implements MypageService{
	@Autowired
	private MypageDAO dao;

	@Override
	public MypageVO getMyInfo(String id) throws Exception {
		return dao.selectMyinfo(id);
	}

	@Override
	public void updateMyinfo(MypageVO mvo) throws Exception {
		dao.updateMyinfo(mvo);
	}
}
