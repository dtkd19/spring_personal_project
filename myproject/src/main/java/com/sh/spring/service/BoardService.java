package com.sh.spring.service;

import java.util.List;

import com.sh.spring.domain.BoardDTO;
import com.sh.spring.domain.BoardVO;
import com.sh.spring.domain.PagingVO;

public interface BoardService {

	int register(BoardDTO bdto);

	List<BoardVO> getList(PagingVO pgvo);

	BoardDTO getDetail(int bno);

	int modify(BoardDTO boardDTO);

	int delete(int bno);

	int getTotal(PagingVO pgvo);

	int fileDelete(String uuid);

	int readCount(int bno);

	int updateCmtCount(long bno);

	int cmtQtyDelete(long cno);

	int hasFileDelete(String uuid);

	List<BoardVO> sortCmt(PagingVO pgvo);

	List<BoardVO> sortRead(PagingVO pgvo);



}
