package com.sh.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sh.spring.domain.likeVO;
import com.sh.spring.service.likeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/like/*")
@RequiredArgsConstructor
@Slf4j
@Controller
public class likeController {
	
	private final likeService lsv;
	
	@GetMapping(value="/{bno}/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <likeVO> list(@PathVariable("bno") long bno, @PathVariable("email") String email ) {
		
		likeVO lvo = lsv.getLike(bno,email);
		
		log.info(">>>> lvo {} >> ", lvo);
		
		return new ResponseEntity<likeVO>(lvo, HttpStatus.OK);
	}
	
	
}
