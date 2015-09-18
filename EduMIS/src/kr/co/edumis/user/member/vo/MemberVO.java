package kr.co.edumis.user.member.vo;

public class MemberVO {
	private String mNo;
	private String mId;
	private String mPw;
	private String mName;
	private String mZcode;
	private String mZaddr;
	private String mEmail;
	private String mBirth;
	private String mPhone;
	private String mMajor;
	public String getmNo() {
		return mNo;
	}
	public void setmNo(String mNo) {
		this.mNo = mNo;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmZcode() {
		return mZcode;
	}
	public void setmZcode(String mZcode) {
		this.mZcode = mZcode;
	}
	public String getmZaddr() {
		return mZaddr;
	}
	public void setmZaddr(String mZaddr) {
		this.mZaddr = mZaddr;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public String getmBirth() {
		return mBirth;
	}
	public void setmBirth(String mBirth) {
		this.mBirth = mBirth;
	}
	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	public String getmMajor() {
		return mMajor;
	}
	public void setmMajor(String mMajor) {
		this.mMajor = mMajor;
	}
	@Override
	public String toString() {
		return "JoinVO [mNo=" + mNo + ", mId=" + mId + ", mPw=" + mPw + ", mName=" + mName + ", mZcode=" + mZcode
				+ ", mZaddr=" + mZaddr + ", mEmail=" + mEmail + ", mBirth=" + mBirth + ", mPhone=" + mPhone
				+ ", mMajor=" + mMajor + "]";
	}
}
