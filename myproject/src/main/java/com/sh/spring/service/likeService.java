package com.sh.spring.service;

import com.sh.spring.domain.likeVO;

public interface likeService {

	likeVO getLike(long bno, String email);

}
