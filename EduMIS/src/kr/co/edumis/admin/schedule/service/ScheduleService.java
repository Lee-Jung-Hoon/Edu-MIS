package kr.co.edumis.admin.schedule.service;

import java.util.List;

import kr.co.edumis.admin.schedule.vo.ScheduleVO;

public interface ScheduleService {
	// 등록처리
	public void registSchedule(ScheduleVO schedule) throws Exception;
	
	// 날짜에맞는 일정보여주기처리
	public List<ScheduleVO> listSchedule(ScheduleVO schedule) throws Exception;
}
