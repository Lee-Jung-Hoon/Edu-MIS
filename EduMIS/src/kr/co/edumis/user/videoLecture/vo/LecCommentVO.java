package kr.co.edumis.user.videoLecture.vo;

public class LecCommentVO {
	private int no;
	private String id;
	private String comments;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "LecCommentVO [no=" + no + ", id=" + id + ", comments=" + comments + "]";
	}

	
}
