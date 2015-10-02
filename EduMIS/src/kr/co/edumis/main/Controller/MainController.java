package kr.co.edumis.main.Controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.main.service.MainService;
import kr.co.edumis.main.service.MainServiceImpl;
import kr.co.edumis.user.login.vo.LoginVO;
import kr.co.edumis.user.talk.service.TalkService;
import kr.co.edumis.user.talk.service.TalkServiceImpl;

@Controller
public class MainController extends HttpServlet{
	
	private static MainService service;
	private static TalkService talkService;
	
	public MainController() {
		service = new MainServiceImpl();
		talkService = new TalkServiceImpl();
	}
	@RequestMapping("/user/main.do")
	public ModelAndView main (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView("/jsp/user/main.jsp");
		try{
			
			// main페이지 일일 출석 결과 불러오기
			List<String> attend = service.selectDailyAttend();
			List<String> absent = service.selectDailyAbsent();
			List<String> late = service.selectDailyLate();
			
			mav.addObject("attend", attend.size());
			mav.addObject("absent", absent.size());
			mav.addObject("absentName", absent);
			mav.addObject("late", late.size());
			mav.addObject("lateName", late);
			/*
			// main페이지 일일 관리자 일정 결과 불러오기
			ScheduleVO schedule = service.selectDailySchedule();
			
			
			// main페이지 일일 자리 배치도 불러오기
				
			//과제게시판 리스트 5개 
			 List<BookBoardVO> bookList = service.selectBookBoardList();
		      
		      // 과제게시판 리스트 5개 //
		      List<AdminAssVO> assList = service.selectAssList();
		      
		      // 성적게시판 본인꺼 최근 리스트 5개 //
		      HttpSession session = req.getSession();
		      MemberVO loginMember = (MemberVO) session.getAttribute("user");
		      List<ExamGradeVO> gardeList = service.selectGrade(loginMember.getId());
		      
		      // 영상게시판 5개 가져오기 //
		      List<VideoLectureVO> videoList = service.selectVideo();
		            
		      // 본인 현재 월 출석 가져오기 //
		      Calendar cal = Calendar.getInstance();
		      int month = cal.get(Calendar.MONTH)+1;
		      List<AdminAttVO> attList = service.getAttList(month);
		      
		      // 오늘 일정 가져오기
		      Calendar cal2 = Calendar.getInstance();
		      int month2 = cal2.get(Calendar.MONTH)+1;
		      int day = cal2.get(Calendar.DAY_OF_MONTH);
		      List<ScheduleVO> schList = service.getScheduleList(month2,day);
			*/	
			
			// 읽지 않은 메시지 개수
			HttpSession session = req.getSession();
			LoginVO login = (LoginVO) session.getAttribute("user");
			if (login != null) {
				mav.addObject("msgCount", talkService.selectReCount(login.getNo()));
			}
			return mav;
		}catch(Exception e) { 
			throw new ServletException(e);
		}
	}
}

