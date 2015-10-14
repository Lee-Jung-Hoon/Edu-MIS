package kr.co.edumis.common;

public class PageVO {

	private int pageNo;
	
	private int count;
	
	private int listSize = Constants.PAGE_LIST_COUNT;
	
	private int tabSize = Constants.PAGE_TAB_COUNT;
	
	private int lastPage;
	
	private int currTab;
	
	private int beginPage;

	private int endPage;
	
	private String uri;
	

	public PageVO(String uri, int pageNo, int count) {
		this.uri 		= uri;
		this.pageNo 	= pageNo;
		this.count 	= count;
		
		setup();
	}
	
	public void setup() {
		lastPage = (count % listSize == 0) ? count / listSize 
				: count / listSize + 1;
		//현재 페이지에 해당하는 탭 위치
		currTab = (pageNo -1) / tabSize + 1;
		// 페이지 블럭의 시작페이지 번호
		beginPage = (currTab - 1) * tabSize + 1;
		// 페이지 블럭의 마지막 페이지 번호
		endPage = (currTab * tabSize < lastPage) ? currTab * tabSize : lastPage;
	}
	
	public String getUri() { return uri; }
	public int getPageNo() { return pageNo; }
	public int getLastPage() { return lastPage; }
	public int getBeginPage() { return beginPage; }
	public int getEndPage() { return endPage; }
	
}
