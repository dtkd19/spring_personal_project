package com.sh.spring.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.sh.spring.dao.CommentDAO;
import com.sh.spring.domain.CommentVO;
import com.sh.spring.domain.PagingVO;
import com.sh.spring.handler.PagingHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
	private final CommentDAO cdao;

	@Override
	public int post(CommentVO cvo) {
		// TODO Auto-generated method stub
		return cdao.post(cvo);
	}

	@Override
	public PagingHandler getList(long bno, PagingVO pgvo) {	
		List<CommentVO> cmtList = cdao.getList(bno,pgvo); 
		int totalCount = cdao.getTotalCount(bno);
		PagingHandler ph = new PagingHandler(totalCount,pgvo,cmtList);
		return ph;
	}

	@Override
	public int modify(CommentVO cvo) {
		// TODO Auto-generated method stub
		return cdao.modify(cvo);
	}

	@Override
	public int delete(long cno) {
		// TODO Auto-generated method stub
		return cdao.delete(cno);
	}

}
