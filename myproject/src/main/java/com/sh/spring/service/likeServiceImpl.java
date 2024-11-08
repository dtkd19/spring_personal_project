package com.sh.spring.service;

import org.springframework.stereotype.Service;

import com.sh.spring.dao.likeDAO;
import com.sh.spring.domain.likeVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class likeServiceImpl implements likeService{
	
	private final likeDAO ldao;

	@Override
	public likeVO getLike(long bno, String email) {
		// TODO Auto-generated method stub
		return ldao.getLike(bno,email);
	}
	
}