package kr.co.edumis.admin.attendance.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.common.db.MyAppSqlConfig;
import kr.co.edumis.user.member.vo.MemberVO;

public class AdminAttDAO {

	private static SqlSession session = null;

	public AdminAttDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}

	public List<MemberVO> selectMemList() {
		List<MemberVO> memList = session.selectList("attendance.memList");
		// System.out.println("!!!gjgj" + memList.get(1).getName());
		// System.out.println("DAO 부분 사이즈 : " + memList.size());
		return session.selectList("attendance.memList");
	}

	public List<AdminAttVO> selectAttList() {
		List<AdminAttVO> attList = session.selectList("attendance.attList");
		// System.out.println(attList.size());
		return attList;
	}

	public List<AdminAttVO> selectAttMemList(String mNo) {
		List<AdminAttVO> attMemList = session.selectList("attendance.attMemList", mNo);
		// System.out.println(attMemList.size());
		return attMemList;
	}

	public void insertAtt(AdminAttVO att) {
		session.insert("attendance.insertAttendance", att);
		session.commit();
	}

	public void updateAtt(AdminAttVO att) {
		session.update("attendance.updateAttendance", att);
		session.commit();
	}

	public List<AdminAttVO> selectAttList2() {
		List<AdminAttVO> attList2 = session.selectList("attendance.attList2");
		return session.selectList("attendance.attList2");
	}

	public List<AdminAttVO> selectAttendList(int attType) {
		List<AdminAttVO> attendList = session.selectList("attendance.attendList", attType);
		return attendList;
	}

}
