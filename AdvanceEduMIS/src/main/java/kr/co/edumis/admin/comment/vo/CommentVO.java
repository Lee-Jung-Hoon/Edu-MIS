package kr.co.edumis.admin.comment.vo;

public class CommentVO {
	private int no;
	private String id;
	private String reg_date;
	private String content;

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

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CommentVO [no=" + no + ", id=" + id + ", reg_date=" + reg_date + ", content=" + content + "]";
	}

}
