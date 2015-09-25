package kr.co.edumis.user.login.vo;

public class LoginVO {
	private int no;
	private String id;
	private String pass;
	private String name;
	private String grade;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "LoginVO [id=" + id + ", pass=" + pass + ", name=" + name + ", grade=" + grade + "]";
	}
	
	
	
}
