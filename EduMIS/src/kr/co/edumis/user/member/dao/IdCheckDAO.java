package kr.co.edumis.user.member.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.common.db.MyAppSqlConfig;

public class IdCheckDAO {

	private static SqlSession session = null;
	
	public IdCheckDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}

	public int selectId(String id) {
		
		return 0;
	}
}
	
	
	
	
	
	
//	public int selectId(String id) throws Exception {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "hr", "hr");
//		String sql = " select count(*) "
//				   + " from mvc_member "
//				   + " where id = ?    ";
//		PreparedStatement pstmt = con.prepareStatement(sql);
//		pstmt.setString(1, id);
//		ResultSet rs = pstmt.executeQuery();
//		if(rs.next()) {
//			return rs.getInt(1);
//		}
//		else return 0;
//	}

