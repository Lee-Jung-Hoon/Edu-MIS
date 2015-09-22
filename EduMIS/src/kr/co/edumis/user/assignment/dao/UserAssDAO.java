package kr.co.edumis.user.assignment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.assignment.vo.UserAssVO;

public class UserAssDAO {
	
	private static SqlSession sqls = null;
	
	public UserAssDAO(){
		sqls = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	public List<AdminAssVO> selectAssignment() throws Exception{
		return sqls.selectList("userAssMapper.adminAssList");
	}
	
	public AdminAssVO selectDetailAssignment(int no) throws Exception{
		return sqls.selectOne("userAssMapper.adminAssDetail", no);
	}
	public void registAssignment(UserAssVO userass) throws Exception{
		sqls.insert("userAssMapper.assRegist", userass);
		sqls.commit();
	}
	public UserAssVO userdetail(int no)throws Exception{
		return sqls.selectOne("userAssMapper.userAssDetail",no);
	}
	
	public void updateUserAss(UserAssVO userass)throws Exception{
		sqls.update("userAssMapper.userAssUpdate",userass);
		sqls.commit();
	}
	

}
