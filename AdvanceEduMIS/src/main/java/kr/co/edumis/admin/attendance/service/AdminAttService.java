package kr.co.edumis.admin.attendance.service;

import java.util.List;

import kr.co.edumis.admin.attendance.vo.AdminAttListVO;



public interface AdminAttService {
	
	public List<AdminAttListVO> selectAttList() throws Exception;
	
	public List<AdminAttListVO> selectAttTermList(AdminAttListVO adm) throws Exception;

}
