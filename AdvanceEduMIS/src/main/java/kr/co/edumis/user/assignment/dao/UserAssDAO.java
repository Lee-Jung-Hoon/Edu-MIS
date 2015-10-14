package kr.co.edumis.user.assignment.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.user.assignment.vo.UserAssVO;

@Repository
public class UserAssDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public List<AdminAssVO> selectAssignment(Map<String, String> param) throws Exception{
		
    List<AdminAssVO> list = session.selectList("userAssMapper.adminAssList", param);
		
		return list;
	}
	
	public AdminAssVO selectDetailAssignment(String no) throws Exception{
		return session.selectOne("userAssMapper.adminAssDetail", no);
	}
	public void registAssignment(UserAssVO userass) throws Exception{
		session.insert("userAssMapper.assRegist", userass);

	}
	public UserAssVO userdetail(Map<String, String> param)throws Exception{
		return session.selectOne("userAssMapper.userAssDetail",param);
	}
	
	public void updateUserAss(UserAssVO userass)throws Exception{
		session.update("userAssMapper.userAssUpdate",userass);
	}
	public List<String> userSubmitCheck(String id)throws Exception{
		return session.selectList("userAssMapper.adminAssList",id);
	}
	
	
	//페이징 할 디비목록!!
	public List<AdminAssVO> selectPage(Map<String,Integer> param) throws Exception{
		return session.selectList("userAssMapper.adminAssList", param);
	}
	// 전체 게시물수
	public int AssCount() throws Exception{
		return session.selectOne("userAssMapper.AssCount");
	}
	
	


}
