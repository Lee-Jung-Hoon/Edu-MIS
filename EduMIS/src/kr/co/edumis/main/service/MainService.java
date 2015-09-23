package kr.co.edumis.main.service;

import kr.co.edumis.admin.attendance.vo.AdminAttVO;
import kr.co.edumis.admin.schedule.vo.ScheduleVO;
import kr.co.edumis.main.vo.MainAdminAttVO;

public interface MainService {


	public ScheduleVO selectDailySchedule() throws Exception;

	public MainAdminAttVO selectDailyAttend() throws Exception;



}
