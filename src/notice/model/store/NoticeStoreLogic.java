package notice.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import notice.model.vo.Notice;
import notice.model.vo.Pagenation;

public class NoticeStoreLogic implements NoticeStore{

	@Override
	public int insertNotice(SqlSession sqlSession, Notice notice) {
		int result = sqlSession.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	@Override
	public int updateNotice(SqlSession sqlSession, Notice notice) {
		int result = sqlSession.update("NoticeMapper.updateNotice", notice);
		return result;
	}

	@Override
	public int deleteNotice(SqlSession sqlSession, int noticeNo) {
		int result = sqlSession.delete("NoticeMapper.deleteNotice", noticeNo);
		return result;
	}
	
	@Override
	public List<Notice> selectAllNotice(SqlSession sqlSession, Pagenation pagenation) {
		List<Notice> nList = sqlSession.selectList("NoticeMapper.selectAllNotice", pagenation);
		return nList;
	}

	@Override
	public String generatePageNavi(SqlSession sqlSession, int currentPage) {
		int totalCount = getRecordTotalCount(sqlSession);			// 전체 게시물 수
		int recordCountPerPage = 10;	// 한 페이지에 보여줄 게시물 수
		int naviTotalCount = 0;			// 네비게이터 전체 페이지수
		if(totalCount % recordCountPerPage > 0) {
			naviTotalCount = totalCount / recordCountPerPage + 1;
		} else {
			naviTotalCount = totalCount / recordCountPerPage;
		}
		int naviCountPerPage = 5;		// 한 페이지당 보여줄 네비게이터의 수
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;	// 최대값으로 다시 세팅
		} 
		StringBuilder sb = new StringBuilder();
		for(int i = startNavi; i <= endNavi; i++) {
			sb.append("<a href='/notice/list.do?page="+i+"'>"+i+" </a>");
		}
		return sb.toString();
	}

	@Override
	public int getRecordTotalCount(SqlSession sqlSession) {
		int result = sqlSession.selectOne("NoticeMapper.selectTotalCount");
		return result;
	}

	@Override
	public Notice selectOneByNo(SqlSession sqlSession, int noticeNo) {
		Notice notice = sqlSession.selectOne("NoticeMapper.selectOneByNo", noticeNo);
		return notice;
	}


	
}
