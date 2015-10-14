package kr.co.edumis.admin.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.edumis.admin.attendance.dao.AdminAttDAO;
import kr.co.edumis.admin.attendance.vo.AdminAttListVO;

@Service
public class AdminAttServiceImpl implements AdminAttService{
	
	@Autowired
	private AdminAttDAO dao;

	public List<AdminAttListVO> selectAttList() throws Exception{
		return dao.selectAttList();
	}
	
	public List<AdminAttListVO> selectAttTermList(AdminAttListVO adm) throws Exception{
		return dao.selectAttTermList(adm);
	}
}
