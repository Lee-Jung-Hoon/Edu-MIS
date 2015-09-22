package kr.co.edumis.admin.examgrade.service;

import java.util.List;

import kr.co.edumis.admin.examgrade.dao.ExamGradeDAO;
import kr.co.edumis.admin.examgrade.vo.ExamBoardVO;
import kr.co.edumis.admin.examgrade.vo.ExamGradeVO;
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

	@Override
	public List<MemberVO> getMemeberList() throws Exception {
		List<MemberVO> list = dao.selectMember();
		return list;
	}

	@Override
	public ExamBoardVO getBoard(String no) throws Exception {
		ExamBoardVO board = dao.selectBoard(no);
		return board;
	}

	@Override
	public void insertExamGrade(ExamGradeVO grade) throws Exception {
		dao.insertExamGrade(grade);		
	}

	@Override
	public void updateBoardCheck(String no) throws Exception {
		dao.updateBoardCheck(no);
	}

	@Override
	public List<ExamGradeVO> getGradeList(String no) throws Exception {
		List<ExamGradeVO> list = dao.getGradeList(no);
		return list;
	}

	@Override
	public List<ExamGradeVO> getGrade(String id) throws Exception {
		List<ExamGradeVO> list = dao.getGrade(id);
		return list;
	}

	@Override
	public void UpdateScore(ExamGradeVO g) throws Exception {
		dao.UpdateScore(g);
	}

}
