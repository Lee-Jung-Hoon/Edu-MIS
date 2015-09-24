package kr.co.edumis.main.service;

import java.util.List;

import kr.co.edumis.admin.schedule.vo.ScheduleVO;

public interface MainService {


	public ScheduleVO selectDailySchedule() throws Exception;

	public List<String> selectDailyAttend() throws Exception;
	
	public List<String> selectDailyLate() throws Exception;
	
	public List<String> selectDailyAbsent() throws Exception;

}
