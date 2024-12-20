package com.sh.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String isLike(@PathVariable("bno") long bno, @PathVariable("email") String email ) {
		
		log.info(">>>> bno, uno > {},{}", bno, email);
		
		int isOk= lsv.getLike(bno,email);
		
		return isOk>0? "1" : "0";
	}
	
}
