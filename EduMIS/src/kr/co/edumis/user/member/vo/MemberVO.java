package kr.co.edumis.user.member.vo;

/*
 * create table t_member(
   no number primary key,
   id varchar2(10) not null,
   name varchar2(30) not null,
   pass varchar2(30) not null,
   pass_chk varchar2(30) not null,
   year varchar2(4) not null,
   month varchar2(4) not null,
   day varchar2(4) not null,
   post_no char(7) not null,  
   basic_addr varchar2(50) not null,
   detail_addr varchar2(50) not null,
   phone1 char(3) not null,
   phone2 char(3) not null,
   phone3 char(3) not null,
   email varchar2(30) not null,
   major varchar2(10) not null,
   join_date date not null,
   drop_check varchar2(3),
   drop_date date,
   drop_reason varchar2(100),
   team varchar2(5),
   tech_leader char(1),
   grade varchar2(1)   
);
 */

public class MemberVO {
	private String no;
	private String id;
	private String name;
	private String pass;
	private String pass_chk;
	private String year;
	private String month;
	private String day;
	private String postNo;
	private String basicAddr;
	private String detailAddr;
	private String phone1;
	private String phone2;
	private String phone3;
	private String email;
	private String major;
	private String joinDate;
	private String dropCheck;
	private String dropDate;
	private String dropReason;
	private String team;
	private String techLeader;
	private String grade;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass_chk() {
		return pass_chk;
	}

	public void setPass_chk(String pass_chk) {
		this.pass_chk = pass_chk;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public String getBasicAddr() {
		return basicAddr;
	}

	public void setBasicAddr(String basicAddr) {
		this.basicAddr = basicAddr;
	}

	public String getDetailAddr() {
		return detailAddr;
	}

	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getDropCheck() {
		return dropCheck;
	}

	public void setDropCheck(String dropCheck) {
		this.dropCheck = dropCheck;
	}

	public String getDropDate() {
		return dropDate;
	}

	public void setDropDate(String dropDate) {
		this.dropDate = dropDate;
	}

	public String getDropReason() {
		return dropReason;
	}

	public void setDropReason(String dropReason) {
		this.dropReason = dropReason;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getTechLeader() {
		return techLeader;
	}

	public void setTechLeader(String techLeader) {
		this.techLeader = techLeader;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}