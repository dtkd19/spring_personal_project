package com.sh.spring.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sh.spring.domain.CommentVO;
import com.sh.spring.domain.PagingVO;
import com.sh.spring.handler.PagingHandler;
import com.sh.spring.service.BoardService;
import com.sh.spring.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Slf4j
@RequestMapping("/comment/*")
@RestController
public class CommentController {
	private final CommentService csv;
	private final BoardService bsv;
	
	
	@PostMapping("/post")
	public ResponseEntity<String> post(@RequestBody CommentVO cvo) {
		log.info(">>>>> post cvo >  {} ", cvo );
		
		int isOk = csv.post(cvo);
		
		 if (isOk > 0) {
			 bsv.updateCmtCount(cvo.getBno()); 
	            return new ResponseEntity<String>("1", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);  
	        }
	}
	

	@GetMapping(value="/{bno}/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <PagingHandler> list(@PathVariable("bno") long bno, @PathVariable("page") int page ) {
		
		PagingVO pgvo = new PagingVO(page, 5);  
		
		PagingHandler ph = csv.getList(bno,pgvo);
		
		return new ResponseEntity<PagingHandler>(ph, HttpStatus.OK);
	}
	
	@ResponseBody
	@PutMapping("/modify")
	public String modify(@RequestBody CommentVO cvo) {			
		int isOk = csv.modify(cvo);
		
		  if (isOk > 0) {
	            return "1";
	        } else {
	            return "0";
	        }
	}	
	
	@ResponseBody
	@DeleteMapping(value="/{cno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@PathVariable("cno") long cno) {	
		
		
		int isOk2 = bsv.cmtQtyDelete(cno);
		int isOk = csv.delete(cno);
			
		return isOk > 0 ? "1" : "0";
	}
	
}
