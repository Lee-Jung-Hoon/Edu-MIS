package kr.co.edumis.user.login.vo;

public class LoginVO {
	private String id;
	private String pass;
	private String name;
	
	
	
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



	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + pass + ", name="
				+ name + "]";
	}
}
