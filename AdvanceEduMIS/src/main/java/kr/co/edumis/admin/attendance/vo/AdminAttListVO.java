package kr.co.edumis.admin.attendance.vo;

public class AdminAttListVO {
	
	private String mName;
	private int type1;
	private int type2;
	private int type3;
	private int type4;
	private String year;
	private String month;
	private String day;
	private String endyear;
	private String endmonth;
	private String endday;
	private String startDate;
	private String endDate;
	
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
	public String getEndyear() {
		return endyear;
	}
	public void setEndyear(String endyear) {
		this.endyear = endyear;
	}
	public String getEndmonth() {
		return endmonth;
	}
	public void setEndmonth(String endmonth) {
		this.endmonth = endmonth;
	}
	public String getEndday() {
		return endday;
	}
	public void setEndday(String endday) {
		this.endday = endday;
	}

	
	
	public String getStartDate() {
		setStartDate(year,month,day);
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public void setStartDate(String year, String month, String day) {
		this.startDate = (year+month+day);
	}
	public String getEndDate() {
		setEndDate(endyear,endmonth,endday);
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public void setEndDate(String endyear, String endmonth, String endday) {
		this.endDate = (endyear+endmonth+endday);
	}
	

	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getType1() {
		return type1;
	}
	public void setType1(int type1) {
		this.type1 = type1;
	}
	public int getType2() {
		return type2;
	}
	public void setType2(int type2) {
		this.type2 = type2;
	}
	public int getType3() {
		return type3;
	}
	public void setType3(int type3) {
		this.type3 = type3;
	}
	public int getType4() {
		return type4;
	}
	public void setType4(int type4) {
		this.type4 = type4;
	}
	
	public String sum(){
		return startDate = (year+month+day);
	}
	public String endSum(){
		return endDate = (endyear+endmonth+endday);
		
	}
	@Override
	public String toString() {
		return "AdminAttListVO [mName=" + mName + ", type1=" + type1 + ", type2=" + type2 + ", type3=" + type3
				+ ", type4=" + type4 + ", year=" + year + ", month=" + month + ", day=" + day + ", endyear=" + endyear
				+ ", endmonth=" + endmonth + ", endday=" + endday + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}
	
	
	
	
	
	

}
