/*
	CREATE TABLE MVC_BOARD
	(
	  NO        NUMBER(6) primary key,
	  TITLE     VARCHAR2(200) NOT NULL,
	  WRITER    VARCHAR2(30),
	  CONTENT   VARCHAR2(4000),
	  REG_DATE  DATE DEFAULT sysdate
	);
	
	create sequence seq_mvc_board_no
 */
package kr.co.edumis.admin.schedule.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.edumis.admin.schedule.vo.ScheduleVO;
import kr.co.edumis.common.db.MyAppSqlConfig;


public class ScheduleDAO {
	
	
	private static SqlSession session = null;
	
	
	public ScheduleDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		
	}
	//스케줄 등록
	public int registSchedule(ScheduleVO schedule) throws Exception {
		session.insert("schedule.dao.SchduleMapper.registSchedule",schedule);
		session.commit();
		return 1;
	}
	
	public List<ScheduleVO> listSchedule(ScheduleVO schedule) throws Exception {
		return session.selectList("schedule.dao.SchduleMapper.listSchedule",schedule);
	}
	
	public ScheduleVO detailSchedule(ScheduleVO schedule)throws Exception{
		return session.selectOne("schedule.dao.SchduleMapper.detailSchedule", schedule);
	}
	
}