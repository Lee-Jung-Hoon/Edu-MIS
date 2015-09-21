package kr.co.edumis.user.memo.service;

import java.util.ArrayList;

import kr.co.edumis.user.memo.dao.MemoDAO;
import kr.co.edumis.user.memo.vo.MemoVO;

public class MemoServiceImpl implements MemoService{
	MemoDAO dao;
	
	public MemoServiceImpl() {
		dao = new MemoDAO();
	}

	@Override
	public ArrayList<MemoVO> getMemoList() throws Exception {
		return (ArrayList<MemoVO>) dao.selectMemo();
		
	}

	@Override
	public void insertMemo(MemoVO memo) throws Exception {
		dao.insertMemo(memo);
		
	}

	@Override
	public void deleteMemo(String id) throws Exception{
		dao.deleteMemo(id);
	}

	@Override
	public void updateMemo(MemoVO memo) throws Exception {
		dao.updateMemo(memo);
		
	}

}
