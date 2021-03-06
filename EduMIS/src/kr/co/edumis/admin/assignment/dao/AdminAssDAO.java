package kr.co.edumis.admin.assignment.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.assignment.vo.UserAssVO;
import kr.co.edumis.user.member.vo.MemberVO;

public class AdminAssDAO {
	
	private static SqlSession sqlMapper;
	
	public AdminAssDAO(){
		sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
	}

	public void insertAss(AdminAssVO adAssvo) {
		
		
		sqlMapper.insert("adminAssignment.registAssignment", adAssvo);
		sqlMapper.commit();
	}
	
	public List<AdminAssVO> selectList(Map<String, Integer> param) {
		List<AdminAssVO> list = sqlMapper.selectList("adminAssignment.selectAssignment", param);
		
		return list;
	}

	public AdminAssVO selectDetail(String no) {
		
		 return sqlMapper.selectOne("adminAssignment.selectDetail",no);
	}

	public void updateAss(AdminAssVO adAssvo) {
		// TODO Auto-generated method stub
		sqlMapper.update("adminAssignment.modifyAssignment", adAssvo);
		System.out.println("여기 : " + adAssvo.getTitle());
		sqlMapper.commit();
	}

	public void delete(String no) {
		// TODO Auto-generated method stub
		sqlMapper.update("adminAssignment.deleteAssignment", no);
	}

	public List<MemberVO> selectMember() {
		// TODO Auto-generated method stub
		return sqlMapper.selectList("adminAssignment.studentList");
	}

	public List<UserAssVO> selectSubmit() {

		return sqlMapper.selectList("adminAssignment.submitList");
	}

	public UserAssVO selectSubject(Map<String, String> param) {
		return (UserAssVO)sqlMapper.selectOne("adminAssignment.getSubject", param);
	}
	
	public int selectCount() {
		
		return sqlMapper.selectOne("adminAssignment.selectCount");
	}
}
