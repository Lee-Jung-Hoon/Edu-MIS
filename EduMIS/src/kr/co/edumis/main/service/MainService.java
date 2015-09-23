package kr.co.edumis.main.service;

import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.admin.schedule.vo.ScheduleVO;

public interface MainService {

	public AdminAttVO selectDailyAttend();

	public ScheduleVO selectDailySchedule();



}
