package com.sh.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sh.spring.domain.BoardVO;
import com.sh.spring.domain.PagingVO;

public interface BoardDAO {

	int register(BoardVO boardVO);

	List<BoardVO> getList(PagingVO pgvo);

	BoardVO getDetail(int bno);

	int modify(BoardVO bvo);

	int delete(int bno);

	int getTotal(PagingVO pgvo);

	long getOneBno();

	int readCount(int bno);

	int updateCmtCount(long bno);

	int cmtQtyDelete(long bno);

	int hasFileUpdate(@Param("bno") long bno,@Param("cnt") int size);

	int hasFileDelete(long bno);

	List<BoardVO> sortCmt(PagingVO pgvo);

	List<BoardVO> sortRead(PagingVO pgvo);


}
