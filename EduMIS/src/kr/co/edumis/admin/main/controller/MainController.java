package kr.co.edumis.admin.main.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.edumis.admin.assignment.vo.AdminAssVO;
import kr.co.edumis.admin.schedule.vo.ScheduleVO;
import kr.co.edumis.admin.talk.service.TalkService;
import kr.co.edumis.admin.talk.service.TalkServiceImpl;
import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.main.service.MainService;
import kr.co.edumis.main.service.MainServiceImpl;
import kr.co.edumis.user.bookboard.vo.BookBoardVO;
import kr.co.edumis.user.login.vo.LoginVO;

@Controller
public class MainController extends HttpServlet {

	private static MainService service;
	private static TalkService talkService;

	public MainController() {
		service = new MainServiceImpl();
		talkService = new TalkServiceImpl();
	}
	@RequestMapping("/admin/main.do")
	public ModelAndView main(HttpServletRequest req) throws Exception {
		try {
			// main페이지 일일 출석 결과 불러오기
			ModelAndView mav = new ModelAndView("/jsp/admin/main.jsp");

			List<String> attend = service.selectDailyAttend();
			List<String> absent = service.selectDailyAbsent();
			List<String> late = service.selectDailyLate();
			mav.addObject("attend", attend.size());
			mav.addObject("absent", absent.size());
			mav.addObject("absentName", absent);
			mav.addObject("late", late.size());
			mav.addObject("lateName", late);

			// main페이지 일일 관리자 일정 결과 불러오기
			ScheduleVO schedule = service.selectDailySchedule();

			// 읽지 않은 메시지 개수
			HttpSession session = req.getSession();
			LoginVO login = (LoginVO) session.getAttribute("admin");
			if (login != null) {
				mav.addObject("msgCount", talkService.selectReCount(login.getNo()));
			}
			
			// main페이지 일일 자리 배치도 불러오기
				
			/*
			// 과제게시판 리스트 5개
			List<BookBoardVO> bookList = service.selectBookBoardList();

			// 과제게시판 리스트 5개 //
			List<AdminAssVO> assList = service.selectAssList();
			 * 사용자	
			// 성적게시판 본인꺼 최근 리스트 5개 //
			HttpSession session = req.getSession();
			MemberVO loginMember = (MemberVO) session.getAttribute("admin");
			List<ExamGradeVO> gardeList = service.selectGrade(loginMember.getId());

			// 영상게시판 5개 가져오기 //
			List<VideoLectureVO> videoList = service.selectVideo();

			// 본인 현재 월 출석 가져오기 //
			Calendar cal = Calendar.getInstance();
			int month = cal.get(Calendar.MONTH) + 1;
			List<AdminAttVO> attList = service.getAttList(month);

			// 오늘 일정 가져오기
			Calendar cal2 = Calendar.getInstance();
			int month2 = cal2.get(Calendar.MONTH) + 1;
			int day = cal2.get(Calendar.DAY_OF_MONTH);
			List<ScheduleVO> schList = service.getScheduleList(month2, day);
			 */
			
			return mav;
		} catch (Exception e) {
			throw e;
		}
	}
}