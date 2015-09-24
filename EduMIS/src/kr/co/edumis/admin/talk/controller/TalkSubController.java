package kr.co.edumis.admin.talk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.edumis.admin.talk.service.TalkService;
import kr.co.edumis.admin.talk.service.TalkServiceImpl;
import kr.co.edumis.admin.talk.vo.MemberTestVO;
import kr.co.edumis.admin.talk.vo.TalkVO;

@WebServlet("/talk/sub")
public class TalkSubController extends HttpServlet {
	private TalkService service;

	public TalkSubController() {
		service = new TalkServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		MemberTestVO member = (MemberTestVO)session.getAttribute("member");
		
		String type = req.getParameter("type");
		String content = req.getParameter("content");
		
		try {
			if (type.equals("count")) {
				List<TalkVO> list = service.selectReList(member.getNo());
				PrintWriter out = res.getWriter();
				out.println(list.size());
				out.close();
			} else if (type.equals("check")) {
				int no = Integer.parseInt(req.getParameter("no"));
				service.updateCheck(no); // 체크로 update
			} else if (type.equals("re")) {
				int no = Integer.parseInt(req.getParameter("no"));
				service.updateCheck(no); // 체크로 update
				TalkVO talk = service.selectNo(no); // 글번호로 보낸 사람 번호와 부모 넘버를 받아옴(부모번호, 보낸사람번호, 받는사람 번호, 내용,)
				talk.setReceiveMemberNo(talk.getSendMemberNo());
				talk.setSendMemberNo(member.getNo()); // session number 로 지정해야 함
				talk.setContent(content);
				service.insertTalk(talk);
			} else {
				String[] arr = req.getParameter("name").split("/");

				for (int i = 1; i < arr.length; i++) {
					TalkVO talk = new TalkVO();
					int seq = service.selectSeq();
					talk.setNo(seq);
					talk.setpNo(seq);
					talk.setSendMemberNo(member.getNo()); // session number 로 지정해야 함
					talk.setReceiveMemberNo(Integer.parseInt(arr[i]));
					talk.setContent(content);
					service.insertNewTalk(talk);
				}
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
