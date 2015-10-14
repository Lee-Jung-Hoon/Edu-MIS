package kr.co.edumis.admin.schedule.service;

import java.util.List;

import kr.co.edumis.admin.schedule.vo.ScheduleVO;

public interface ScheduleService {

	public List<List<ScheduleVO>> infoSchedule(ScheduleVO scheduleVO) throws Exception;

	public List<ScheduleVO> listInfoSchedule(String day);
	
}
