package kr.co.edumis.user.vote.vo;

public class VoteVO {
	private String id;
	private String name;
	private int vCount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getvCount() {
		return vCount;
	}

	public void setvCount(int vCount) {
		this.vCount = vCount;
	}

}
