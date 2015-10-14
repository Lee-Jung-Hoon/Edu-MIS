package kr.co.edumis.user.videoLecture.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.edumis.user.videoLecture.service.VideoLectureService;
import kr.co.edumis.user.videoLecture.vo.LecCommentVO;
import kr.co.edumis.user.videoLecture.vo.VideoLectureVO;

@Controller
@RequestMapping("/user")
public class VideoLectureController {
	final double page = 10;

	@Autowired
	private VideoLectureService service;

	@RequestMapping("/lectureRegist.do")
	public String lectureRegist(VideoLectureVO lecture) throws Exception {
		service.lectureRegist(lecture);
		return "redirect:lectureList.do";
	}

	@RequestMapping("/lectureList.do")
	public ModelAndView lectureList(@RequestParam(value = "pageNum", required = false, defaultValue = "1" ) int pageNum) throws Exception {
		String pageNum2 = String.valueOf(pageNum);

		int pagingNum = service.lectureCount();
		if (pageNum2 == null) {
			pageNum2 = "1";
		}

		int startPage = (int) (1 + ((Integer.parseInt(pageNum2) - 1) * (double) page));
		int endPage = (int) (Integer.parseInt(pageNum2) * (double) page);

		ModelAndView mav = new ModelAndView("/user/videolecture/lectureList");
		int leng = (int) Math.ceil(pagingNum / (double) page);
		List<VideoLectureVO> list = service.lectureList(startPage, endPage);
		mav.addObject("lectureList", list);
		mav.addObject("paging", leng);
		return mav;
	}

	@RequestMapping("/lectureDetail.do")
	public ModelAndView lectureDetail(@RequestParam("no") int no) throws Exception {
		ModelAndView mav = new ModelAndView("/user/videolecture/lectureDetail");
		VideoLectureVO lecture = service.lectureDetail(no);
		List<LecCommentVO> lecComment = service.lecCommentList(no);
		mav.addObject("lecture", lecture);
		mav.addObject("lecComment", lecComment);
		return mav;
	}

	@RequestMapping("/lectureDelete.do")
	public String lectureDelete(@RequestParam("no") int no) throws Exception {
		service.lectureDelete(no);
		return "redirect:lectureList.do";
	}

	@RequestMapping("/lectureSelect.do")
	public ModelAndView lectureSelect(@RequestParam("no") int no) throws Exception {
		ModelAndView mav = new ModelAndView("/user/videolecture/lectureModify");
		VideoLectureVO lecture = service.lectureSelect(no);
		mav.addObject("lecture", lecture);
		return mav;
	}

	@RequestMapping("/lectureModify.do")
	public ModelAndView lectureModify(VideoLectureVO lecture) throws Exception {
		ModelAndView mav = new ModelAndView("/user/videolecture/lectureDetail");
		List<LecCommentVO> lecComment = service.lecCommentList(lecture.getNo());
		service.lectureModify(lecture);
		mav.addObject("lecture", lecture);
		mav.addObject("lecComment", lecComment);
		return mav;
	}

	@RequestMapping("/lecCommentRegist.do")
	public void lecCommentRegist(LecCommentVO lecComment) throws Exception {
		service.lecCommentRegist(lecComment);
	}

	@RequestMapping("/lecCommentDelete.do")
	public void lecCommentDelete(@RequestParam("comno") int comno) throws Exception {
		service.lecCommentDelete(comno);
	}

	@RequestMapping("/lecCommentList.do")
	public List<LecCommentVO> lecCommentList(@RequestParam("no") int no, HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8");
		List<LecCommentVO> list = null;
		try {
			list = service.lecCommentList(no);
			PrintWriter out = res.getWriter();
			String str = "";
			str += "[";
			for (LecCommentVO lec : list) {
				str += "{";
				str += " 'comno' : '" + lec.getComno() + "' ,";
				str += " 'id' : '" + lec.getId() + "' ,";
				str += " 'comments' : '" + lec.getComments() + "'";
				str += "},";
			}
			str += "]";
			out.println(str);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
