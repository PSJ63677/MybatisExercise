package notice.model.vo;

import java.util.List;

public class PageData {
	private List<Notice> noticeList;
	private String pageNavigator;
	
	public PageData() {
	}
	public List<Notice> getNoticeList() {
		return noticeList;
	}
	public void setNoticeList(List<Notice> noticeList) {
		this.noticeList = noticeList;
	}
	public String getPageNavigator() {
		return pageNavigator;
	}
	public void setPageNavigator(String pageNavigator) {
		this.pageNavigator = pageNavigator;
	}
	
	
}
