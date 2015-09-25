package kr.co.edumis.user.talk.vo;

public class TalkVO {
	private int no;
	private int pNo;
	private int sendMemberNo;
	private int receiveMemberNo;
	private String content;
	private String sendDate;
	private String checkYN;
	private String sendDel;
	private String receiveDel;
	private String name;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public int getSendMemberNo() {
		return sendMemberNo;
	}

	public void setSendMemberNo(int sendMemberNo) {
		this.sendMemberNo = sendMemberNo;
	}

	public int getReceiveMemberNo() {
		return receiveMemberNo;
	}

	public void setReceiveMemberNo(int receiveMemberNo) {
		this.receiveMemberNo = receiveMemberNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getCheckYN() {
		return checkYN;
	}

	public void setCheckYN(String checkYN) {
		this.checkYN = checkYN;
	}

	public String getSendDel() {
		return sendDel;
	}

	public void setSendDel(String sendDel) {
		this.sendDel = sendDel;
	}

	public String getReceiveDel() {
		return receiveDel;
	}

	public void setReceiveDel(String receiveDel) {
		this.receiveDel = receiveDel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
