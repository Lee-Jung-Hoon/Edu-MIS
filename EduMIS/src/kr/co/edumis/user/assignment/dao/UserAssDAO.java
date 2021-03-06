package kr.co.edumis.user.assignment.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.assignment.vo.UserAssVO;

public class UserAssDAO {
	
	private static SqlSession sqls = null;
	
	public UserAssDAO(){
		sqls = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	public List<AdminAssVO> selectAssignment(Map<String, String> param) throws Exception{
		
    List<AdminAssVO> list = sqls.selectList("userAssMapper.adminAssList", param);
		
		return list;
	}
	
	public AdminAssVO selectDetailAssignment(String no) throws Exception{
		return sqls.selectOne("userAssMapper.adminAssDetail", no);
	}
	public void registAssignment(UserAssVO userass) throws Exception{
		sqls.insert("userAssMapper.assRegist", userass);
		sqls.commit();
	}
	public UserAssVO userdetail(Map<String, String> param)throws Exception{
		return sqls.selectOne("userAssMapper.userAssDetail",param);
	}
	
	public void updateUserAss(UserAssVO userass)throws Exception{
		sqls.update("userAssMapper.userAssUpdate",userass);
		sqls.commit();
	}
	public List<String> userSubmitCheck(String id)throws Exception{
		return sqls.selectList("userAssMapper.adminAssList",id);
	}
	
	
	//페이징 할 디비목록!!
	public List<AdminAssVO> selectPage(Map<String,Integer> param) throws Exception{
		return sqls.selectList("userAssMapper.adminAssList", param);
	}
	// 전체 게시물수
	public int AssCount() throws Exception{
		return sqls.selectOne("userAssMapper.AssCount");
	}
	
	


}
