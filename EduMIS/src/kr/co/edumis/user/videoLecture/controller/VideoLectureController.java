package kr.co.edumis.user.videoLecture.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.edumis.framework.Controller;
import kr.co.edumis.framework.ModelAndView;
import kr.co.edumis.framework.RequestMapping;
import kr.co.edumis.user.videoLecture.service.LecCommentService;
import kr.co.edumis.user.videoLecture.service.LecCommentServiceImpl;
import kr.co.edumis.user.videoLecture.service.VideoLectureService;
import kr.co.edumis.user.videoLecture.service.VideoLectureServiceImpl;
import kr.co.edumis.user.videoLecture.vo.LecCommentVO;
import kr.co.edumis.user.videoLecture.vo.VideoLectureVO;

@Controller
public class VideoLectureController {
	final double page = 10;

	private VideoLectureService service;
	private LecCommentService lecService;

	public VideoLectureController() {
		service = new VideoLectureServiceImpl();
		lecService = new LecCommentServiceImpl();
	}

	@RequestMapping("/user/lectureRegist.do")
	public String lectureRegist(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		String video = req.getParameter("video");

		VideoLectureVO lecture = new VideoLectureVO();
		lecture.setTitle(title);
		lecture.setContents(contents);
		lecture.setVideo(video);

		service.lectureRegist(lecture);
		return "redirect:/EduMIS/user/lectureList.do";
	}

	@RequestMapping("/user/lectureList.do")
	public ModelAndView lectureList(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageNum = req.getParameter("pageNum");

		int pagingNum = service.lectureCount();
		if (pageNum == null) {
			pageNum = "1";
		}

		int startPage = (int) (1 + ((Integer.parseInt(pageNum) - 1) * (double) page));
		int endPage = (int) (Integer.parseInt(pageNum) * (double) page);

		ModelAndView mav = new ModelAndView("/jsp/user/videolecture/lectureList.jsp");
		int leng = (int) Math.ceil(pagingNum / (double) page);
		System.out.println(leng);
		List<VideoLectureVO> list = service.lectureList(startPage, endPage);
		mav.addObject("lectureList", list);
		mav.addObject("paging", leng);
		return mav;
	}

	@RequestMapping("/user/lectureDetail.do")
	public ModelAndView lectureDetail(int no) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/user/videolecture/lectureDetail.jsp");
		VideoLectureVO lecture = service.lectureDetail(no);
		List<LecCommentVO> lecComment = lecService.lecCommentList(no);
		mav.addObject("lecture", lecture);
		mav.addObject("lecComment", lecComment);
		return mav;
	}

	@RequestMapping("/user/lecCommentRegist.do")
	public ModelAndView lecCommentRegist(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/user/videolecture/lectureList.jsp");
		int no = Integer.parseInt(req.getParameter("no"));
		String comments = req.getParameter("comments");

		LecCommentVO lecComment = new LecCommentVO();
		lecComment.setNo(no);
		lecComment.setComments(comments);

		lecService.lecCommentRegist(lecComment);
		return mav;
	}

	@RequestMapping("/user/lectureDelete.do")
	public String lectureDelete(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int no = Integer.parseInt(req.getParameter("no"));
		service.lectureDelete(no);
		return "redirect:/EduMIS/user/lectureList.do";
	}

	@RequestMapping("/user/lectureSelect.do")
	public ModelAndView lectureSelect(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/user/videolecture/lectureModify.jsp");
		int no = Integer.parseInt(req.getParameter("no"));
		
		VideoLectureVO lecture = service.lectureSelect(no);
		mav.addObject("lecture", lecture);
		
		return mav;
	}

	@RequestMapping("/user/lectureModify.do")
	public ModelAndView lectureModify(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/user/videolecture/lectureDetail.jsp");

		int no = Integer.parseInt(req.getParameter("no"));
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		String video = req.getParameter("video");

		VideoLectureVO lecture = new VideoLectureVO();
		lecture.setNo(no);
		lecture.setTitle(title);
		lecture.setContents(contents);
		lecture.setVideo(video);
		
		List<LecCommentVO> lecComment = lecService.lecCommentList(no);
		service.lectureModify(lecture);
		mav.addObject("lecture", lecture);
		mav.addObject("lecComment", lecComment);
		return mav;
	}

}
