package com.sh.spring.service;

public interface likeService {

	int getLike(long bno, String email);

	int regLike(long bno, String email);

	int delLike(long bno, String email);

	int likeCount();


}
