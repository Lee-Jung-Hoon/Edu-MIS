package kr.co.edumis.admin.examgrade.vo;

public class ExamGradeVO {

	private String name;
	private String title;
	private int score;
	private String regDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		return "ExamGradeVO [name=" + name + ", title=" + title + ", score=" + score + ", regDate=" + regDate + "]";
	}
}
