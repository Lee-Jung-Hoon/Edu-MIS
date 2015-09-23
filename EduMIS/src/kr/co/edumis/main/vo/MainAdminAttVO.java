package kr.co.edumis.main.vo;

public class MainAdminAttVO {
	private int attCount;
	private int absentCount;
	private int lateCount;
    private String absentName;
    private String lateName;
    
	public int getAttCount() {
		return attCount;
	}
	public void setAttCount(int attCount) {
		this.attCount = attCount;
	}
	public int getAbsentCount() {
		return absentCount;
	}
	public void setAbsentCount(int absentCount) {
		this.absentCount = absentCount;
	}
	public int getLateCount() {
		return lateCount;
	}
	public void setLateCount(int lateCount) {
		this.lateCount = lateCount;
	}
	public String getAbsentName() {
		return absentName;
	}
	public void setAbsentName(String absentName) {
		this.absentName = absentName;
	}
	public String getLateName() {
		return lateName;
	}
	public void setLateName(String lateName) {
		this.lateName = lateName;
	}
}