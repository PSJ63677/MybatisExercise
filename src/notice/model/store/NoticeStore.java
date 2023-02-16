package notice.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


import notice.model.vo.Notice;
import notice.model.vo.Pagenation;

public interface NoticeStore {
	
	/**
	 * 공지사항등록 Service
	 * @param notice
	 * @return int
	 */
	public int insertNotice(SqlSession sqlSession, Notice notice);
	
	public int updateNotice(SqlSession sqlSession, Notice notice);
	
	public int deleteNotice(SqlSession sqlSession, int noticeNo);
	
	public List<Notice> selectAllNotice(SqlSession sqlSession, Pagenation pagenation);
	
	public String generatePageNavi(SqlSession sqlSession, int currentPage);
	
	public int getRecordTotalCount(SqlSession sqlSession);
	
	public Notice selectOneByNo(SqlSession sqlSession, int noticeNo);
	
}
