package kr.co.edumis.admin.examgrade.service;

import java.util.List;

import kr.co.edumis.admin.examgrade.dao.ExamGradeDAO;
import kr.co.edumis.admin.examgrade.vo.ExamBoardVO;
import kr.co.edumis.user.member.vo.MemberVO;

public class ExamGradeServiceImpl implements ExamGradeService {
	private ExamGradeDAO dao = null;
	
	public ExamGradeServiceImpl() {
		dao = new ExamGradeDAO();
	}

	@Override
	public void insertExamBoard(ExamBoardVO board) throws Exception {
		dao.insertExamBoard(board);
	}

	@Override
	public List<ExamBoardVO> getBoardList() throws Exception {
		List<ExamBoardVO> list = dao.selectBoard();
		return list;
	}

}
