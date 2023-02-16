package notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import notice.model.store.NoticeStore;
import notice.model.store.NoticeStoreLogic;
import notice.model.vo.Notice;
import notice.model.vo.PageData;
import notice.model.vo.Pagenation;

public class NoticeServiceImpl implements NoticeService{
	
	private NoticeStore nStore;
	
	public NoticeServiceImpl() {
		nStore = new NoticeStoreLogic();
	}

	@Override
	public int insertNotice(Notice notice) {
		//연결생성 - 스토어전달
		//커밋롤백
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		NoticeStore nStore = new NoticeStoreLogic();
		int result = nStore.insertNotice(sqlSession, notice);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	@Override
	public int modifyNotice(Notice notice) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		int result = nStore.updateNotice(sqlSession, notice);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int removeNotice(int noticeNo) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		int result = nStore.deleteNotice(sqlSession, noticeNo);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public PageData printAllNotice(Pagenation pagenation) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		List<Notice> nList = nStore.selectAllNotice(sqlSession, pagenation);
		
		String pageNavigator = nStore.generatePageNavi(sqlSession, pagenation.getCurrentPage());
		PageData pageData = new PageData();
		pageData.setNoticeList(nList);
		pageData.setPageNavigator(pageNavigator);
		return pageData;
	}

	@Override
	public Notice printOneByNo(int noticeNo) {
		SqlSession sqlSession = SqlSessionTemplate.getSqlSession();
		Notice notice = nStore.selectOneByNo(sqlSession, noticeNo);
		return notice;
	}
	
}
