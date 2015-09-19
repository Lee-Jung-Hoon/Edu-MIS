package kr.co.edumis.admin.assignment.vo;

public class AdminAssVO {

	private int no;
	private String startDate;
	private String endDate;
	private String title;
	private String content;
	private String orgFileNmae;
	private String realFileName;
	private String filePath;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	public String getOrgFileNmae() {
		return orgFileNmae;
	}

	public void setOrgFileNmae(String orgFileNmae) {
		this.orgFileNmae = orgFileNmae;
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

}
