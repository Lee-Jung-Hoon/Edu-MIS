
package kr.co.edumis.admin.schedule.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.edumis.admin.schedule.vo.ScheduleVO;

@Repository
public class ScheduleDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<ScheduleVO> infoSchedule(String day) {
		List<ScheduleVO> list = sqlSession.selectList("schedule.dao.SchduleDAO.listSchedule" , day);
		
		return list;
	}
	
	
	
}