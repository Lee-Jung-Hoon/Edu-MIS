package kr.co.edumis.admin.attendance.vo;

public class AdminAttVO {

	private int mNo;			// 학생번호
	private String mName;		// 학생이름
	private String attDate;		// 출석일
	private int attType;		// 출석타입
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getAttDate() {
		return attDate;
	}
	public void setAttDate(String attDate) {
		this.attDate = attDate;
	}
	public int getAttType() {
		return attType;
	}
	public void setAttType(int attType) {
		this.attType = attType;
	}
	
	
}
