package com.sh.spring.service;



import com.sh.spring.domain.CommentVO;
import com.sh.spring.domain.PagingVO;
import com.sh.spring.handler.PagingHandler;


public interface CommentService {

	int post(CommentVO cvo);

	PagingHandler getList(long bno, PagingVO pgvo);

	int modify(CommentVO cvo);

	int delete(long cno);


}
