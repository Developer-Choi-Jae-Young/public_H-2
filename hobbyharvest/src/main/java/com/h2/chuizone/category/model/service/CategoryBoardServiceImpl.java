package com.h2.chuizone.category.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.category.model.dao.CategoryBoardDao;
import com.h2.chuizone.category.model.vo.CategoryBoard;
import com.h2.chuizone.common.board.model.service.BoardService;
import com.h2.chuizone.common.board.model.service.BoardServiceImpl;
import com.h2.chuizone.common.board.model.vo.Board;
import com.h2.chuizone.common.boardcategoryboard.model.service.BoardCategoryBoardService;
import com.h2.chuizone.common.boardcategoryboard.model.service.BoardCategoryBoardServiceImpl;
import com.h2.chuizone.common.boardcategoryboard.model.vo.BoardCategoryBoard;
import com.h2.chuizone.common.club.model.service.ClubService;
import com.h2.chuizone.common.club.model.service.ClubServiceImpl;
import com.h2.chuizone.common.club.model.vo.Club;
import com.h2.chuizone.common.kindofboard.model.service.KindOfBoardService;
import com.h2.chuizone.common.kindofboard.model.service.KindOfBoardServiceImpl;
import com.h2.chuizone.common.kindofboard.model.vo.KindOfBoard;
import com.h2.chuizone.common.memberclub.model.service.MemberClubService;
import com.h2.chuizone.common.memberclub.model.service.MemberClubServiceImpl;
import com.h2.chuizone.common.memberclub.model.vo.MemberClub;
import com.h2.chuizone.template.MybatisTemplate;

public class CategoryBoardServiceImpl implements CategoryBoardService {
	private CategoryBoardDao categoryBoardDao = new CategoryBoardDao();
	private ClubService clubService = new ClubServiceImpl();
	private KindOfBoardService kindOfBoardService = new KindOfBoardServiceImpl();
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	public int selectMaxPageNumber(int categoryNo, String keyword) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();

		return categoryBoardDao.selectMaxPageNumber(sqlSession, categoryNo, keyword);
	}

	@Override
	public int insertCategoryBoard(CategoryBoard categoryBoard, Board board ,int userNo) {
		int result = 0;
		int resultCategoryBoard = 0;
		int resultBoard = 0;
		
		int clubResult = clubService.insertClub(new Club(0, board.getTitle()));
		
		if(clubResult > 0) {
			int kindOfBoardId = -1;
			int clubId = -1;
			
			List<KindOfBoard> kindOfBoardList = kindOfBoardService.selectKindOfBoardList();
			
			for(KindOfBoard kindOfBoard : kindOfBoardList) {
				if(kindOfBoard.getKindOfBoardName().equals("카테고리")) {
					kindOfBoardId = kindOfBoard.getKindOfBoardNo();
					break;
				}
			}
			
			List<Club> clubList = clubService.selectClub();
			
			for(Club club : clubList) {
				if(club.getClubName().equals(board.getTitle())) {
					clubId = club.getClubNo();
					break;
				}
			}
			
			categoryBoard.setKindOfBoardNo(kindOfBoardId);
			categoryBoard.setClubNo(clubId);

			board.setMemberNo(userNo);
			board.setKindOfBoardNo(kindOfBoardId);
			resultBoard = boardService.insertBoard(board);

			if(resultBoard > 0) {
				SqlSession sqlSession = MybatisTemplate.getSqlSession();
				resultCategoryBoard = categoryBoardDao.insertCategoryBoard(sqlSession, categoryBoard);
				
				if(resultCategoryBoard > 0) {
					sqlSession.commit();
				} else {
					sqlSession.rollback();
				}
			}
			
			MemberClubService memberClubService = new MemberClubServiceImpl();
			int resultMemberClub = memberClubService.insertJoinClub(new MemberClub(0, userNo, clubId));
			
			BoardCategoryBoardService boardCategoryBoardService = new BoardCategoryBoardServiceImpl();
			int resultBoardCategoryBoard = boardCategoryBoardService.insertBoardCategoryBoard(new BoardCategoryBoard(0, board.getBoardNo(), categoryBoard.getCategoryBoardNo()));
			
			if(resultBoard > 0 && resultCategoryBoard > 0 && resultMemberClub > 0 & resultBoardCategoryBoard > 0) {
				result = resultBoard;
			}
		} else {
			// 실패!!!!
		}
		
		return result;
	}
	
	@Override
	public int updateCategoryBoardByCurCount(int currentHeadCnt, int boardNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = categoryBoardDao.updateCategoryBoardByCurCount(sqlSession, currentHeadCnt, boardNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int updateCategoryBoardByView(int view, int boardNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = categoryBoardDao.updateCategoryBoardByView(sqlSession, view, boardNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int updateCategoryBoardByRecommandPlus(int categoryNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = categoryBoardDao.updateCategoryBoardByRecommandPlus(sqlSession, categoryNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int updateCategoryBoardByRecommandMinus(int categoryNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = categoryBoardDao.updateCategoryBoardByRecommandMinus(sqlSession, categoryNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int updateCategoryBoardByComplainPlus(int categoryNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = categoryBoardDao.updateCategoryBoardByComplainPlus(sqlSession, categoryNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int updateCategoryBoardByComplainMinus(int categoryNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = categoryBoardDao.updateCategoryBoardByComplainMinus(sqlSession, categoryNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int updateCategoryBoard(int categoryBoardNo, int smallGroupCategoryNo, String categoryImage, int maxCount) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = categoryBoardDao.updateCategoryBoard(sqlSession, categoryBoardNo, smallGroupCategoryNo, categoryImage, maxCount);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}	
}
