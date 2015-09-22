package kr.co.edumis.admin.attendance.vo;

public class AdminAttVO {
//	mNo number ,					
//	att_date date default sysdate,	
//	att_type number,	
	
	private int mNo;
	private String mName;
	private String attDate;
	private int attType;
	
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
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
