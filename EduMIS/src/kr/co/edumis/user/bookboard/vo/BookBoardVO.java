package kr.co.edumis.user.bookboard.vo;

public class BookBoardVO {
	private int no;
	private String title;
	private String content;
	private String id;
	private String realFileName;
	private String orgFileName;
	private String filePath; 
	private String regDate;
	private String search;
	private String choice;
	
	 
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
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
	public String getRealFileName() {
		return realFileName;
	}
	public void setRealFileName(String realFileName) {
		this.realFileName = realFileName;
	}
	public String getOrgFileName() {
		return orgFileName;
	}
	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "BookBoardVO [no=" + no + ", title=" + title + ", content=" + content + ", id=" + id + ", realFileName="
				+ realFileName + ", orgFileName=" + orgFileName + ", filePath=" + filePath + ", regDate=" + regDate
				+ "]";
	}
	
	
}
