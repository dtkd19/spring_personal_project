package com.sh.spring.dao;

import org.apache.ibatis.annotations.Param;

public interface likeDAO {

	int getLike(@Param("bno") long bno, @Param("email") String email);

	int regList(@Param("bno") long bno, @Param("email") String email);

	int delLike(@Param("bno") long bno, @Param("email") String email);

	int likeCount();


}
