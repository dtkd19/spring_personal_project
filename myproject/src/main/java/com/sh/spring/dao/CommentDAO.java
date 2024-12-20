package com.sh.spring.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sh.spring.domain.CommentVO;
import com.sh.spring.domain.PagingVO;

public interface CommentDAO {

	int post(CommentVO cvo);

	List<CommentVO> getList(@Param("bno") long bno,@Param("pgvo") PagingVO pgvo);

	int getTotalCount(long bno);

	int modify(CommentVO cvo);

	int delete(long cno);

	CommentVO getCvo(long cno);



}
