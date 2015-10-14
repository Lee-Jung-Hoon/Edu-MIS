package kr.co.edumis.admin.attendance.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.edumis.admin.attendance.vo.AdminAttListVO;


@Repository
public class AdminAttDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public List<AdminAttListVO> selectAttList() throws Exception{
		return sql.selectList("attendance.dao.AdminAttDAO.selectAttList");
	}
	public List<AdminAttListVO> selectAttTermList(AdminAttListVO adm) throws Exception{
		return sql.selectList("attendance.dao.AdminAttDAO.selectAttList2",adm);
	}
}
