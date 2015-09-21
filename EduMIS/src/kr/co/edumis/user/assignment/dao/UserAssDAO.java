package kr.co.edumis.user.assignment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.common.db.MyAppSqlConfig;

public class UserAssDAO {
	
	private static SqlSession session = null;
	
	public UserAssDAO(){
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	public List<AdminAssVO> selectAssignment() throws Exception{
		return session.selectList("userAssMapper.assList");
	}
	
	public AdminAssVO selectDetailAssignment(int no) throws Exception{
		return session.selectOne("userAssMapper.assDetailList", no);
	}

}
