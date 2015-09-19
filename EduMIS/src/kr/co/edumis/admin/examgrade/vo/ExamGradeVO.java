package kr.co.edumis.admin.examgrade.vo;

/*
 * create table t_exam_grade(	
 * 	id varchar2(100) not null
	name varchar2(30) not null,
	title varchar2(100) not null,
	content varchar2(300) not null,
	no number not null,
	score number not null,
	reg_date date default sysdate
)
 */

public class ExamGradeVO {
	private String id;
	private String name;
	private String no;
	private int score;
	private String regDate;
	private String title;
	private String content;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

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
		return "ExamGradeVO [id=" + id + ", name=" + name + ", no=" + no + ", score=" + score + ", regDate=" + regDate
				+ ", title=" + title + ", content=" + content + "]";
	}
	
	
}
