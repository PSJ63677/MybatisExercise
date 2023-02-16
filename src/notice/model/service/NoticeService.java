package notice.model.service;

import java.util.List;

import notice.model.vo.Notice;
import notice.model.vo.PageData;
import notice.model.vo.Pagenation;

public interface NoticeService {
	
	/**
	 * 공지사항등록 Store
	 * @param sqlSession
	 * @param notice
	 * @return int
	 */
	public int insertNotice(Notice notice);
	
	public int modifyNotice(Notice notice);
	
	public int removeNotice(int noticeNo);

	public PageData printAllNotice(Pagenation pagenation);
	
	public Notice printOneByNo(int noticeNo);

	
	
}
