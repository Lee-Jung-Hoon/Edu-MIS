package kr.co.edumis.admin.examgrade.vo;

public class ExamGradeVO {
	private String id;
	private String name;
	private int score;
	private String regDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "ExamGradeVO [name=" + name + ", score=" + score + ", regDate=" + regDate + "]";
	}
}
