package kr.co.edumis.admin.attendance.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.edumis.admin.attendance.vo.AdminAttListVO;
import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.user.member.vo.MemberVO;


@Repository
public class AdminAttDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	// 출석통계
	public List<AdminAttListVO> selectAttList() throws Exception{
		return sql.selectList("attendance.dao.AdminAttDAO.selectAttList");
	}
	
	public List<MemberVO> selectMemList() {
		return sql.selectList("attendance.memList");
	}

	public List<AdminAttVO> selectAttList2() {
		return sql.selectList("attendance.attList");
	}

	public List<AdminAttVO> selectAttMemList(String mNo) {
		return sql.selectList("attendance.attMemList", mNo);
	}

	public void insertAtt(AdminAttVO att) {
		sql.insert("attendance.insertAttendance", att);
	}

	public void updateAtt(AdminAttVO att) {
		sql.update("attendance.updateAttendance", att);
	
	}
}
