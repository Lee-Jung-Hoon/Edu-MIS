package kr.co.edumis.user.memo.vo;

public class MemoVO {
	private int memoNo;
	private int userNo;
	private String content;
	private int posX;
	private int posY;
	public int getMemoNo() {
		return memoNo;
	}
	public void setMemoNo(int memoNo) {
		this.memoNo = memoNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	@Override
	public String toString() {
		return "MemoVO [memoNo=" + memoNo + ", userNo=" + userNo + ", content=" + content + ", posX=" + posX + ", posY="
				+ posY + "]";
	}
	
	


}
