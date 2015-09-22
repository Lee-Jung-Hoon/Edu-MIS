package kr.co.edumis.user.mypage.service;

import java.util.List;

import kr.co.edumis.user.mypage.dao.MypageDAO;
import kr.co.edumis.user.mypage.vo.MypageVO;

public class MypageServiceImpl implements MypageService{
	private MypageDAO dao;
	
	public MypageServiceImpl() {
		dao = new MypageDAO();
	}

	@Override
	public List<MypageVO> getMyinfo(String id) throws Exception{
		// TODO Auto-generated method stub
		return dao.selectMyinfo(id);
	}
	
}
