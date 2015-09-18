package kr.co.edumis.user.assignment.vo;

public class UserAssVO {
	private String id;
	private String name;
	private int no;
	private String content;
	private String orgFileName;
	private String realFileName;
	private String filePath;
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
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOrgFileName() {
		return orgFileName;
	}
	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}
	public String getRealFileName() {
		return realFileName;
	}
	public void setRealFileName(String realFileName) {
		this.realFileName = realFileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	@Override
	public String toString() {
		return "UserAssVO [id=" + id + ", name=" + name + ", no=" + no + ", content=" + content + ", orgFileName="
				+ orgFileName + ", realFileName=" + realFileName + ", filePath=" + filePath + "]";
	}
	
	

}


/*
create table t_user_assignment_board(
id varchar2(30) not null,
name varchar2(30) not null,
no number not null,
content varchar2(3000),
org_File_Name varchar2(1000),
real_File_Name varchar2(1000),
file_Path varchar2(1000),
primary key(id,no)
);



 */
