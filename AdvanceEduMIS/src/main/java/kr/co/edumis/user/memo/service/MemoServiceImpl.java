package kr.co.edumis.user.memo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.edumis.user.memo.dao.MemoDAO;
import kr.co.edumis.user.memo.vo.MemoVO;

@Service
public class MemoServiceImpl implements MemoService{
	
	@Autowired
	private MemoDAO dao;

	@Override
	public List<MemoVO> getMemoList(String no) throws Exception {
		return dao.selectMemo(no);
		
	}

	@Override
	public void insertMemo(MemoVO memo) throws Exception {
		int memoNo = dao.selectMemoNo();
		memo.setMemoNo(memoNo);
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
