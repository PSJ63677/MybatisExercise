package notice.model.vo;

public class Pagenation {	
	private int currentPage;
	private int recordCountPerPage;
	private int start;
	private int end;
	
	
	public Pagenation() {}
	
	public Pagenation(int currentPage, int recordCountPerPage) {
		super();
		this.currentPage = currentPage;
		this.recordCountPerPage = recordCountPerPage;
		this.start = currentPage*recordCountPerPage - (recordCountPerPage - 1);;
		this.end = currentPage*recordCountPerPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage() {
		this.currentPage = currentPage;
	}

	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}	
	
	
}
