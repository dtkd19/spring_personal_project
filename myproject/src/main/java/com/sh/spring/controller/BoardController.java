package com.sh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sh.spring.domain.BoardDTO;
import com.sh.spring.domain.BoardVO;
import com.sh.spring.domain.FileVO;
import com.sh.spring.domain.PagingVO;
import com.sh.spring.handler.FileHandler;
import com.sh.spring.handler.PagingHandler;
import com.sh.spring.service.BoardService;
import com.sh.spring.service.likeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequestMapping("/board/*")
@RequiredArgsConstructor
@Slf4j
@Controller
public class BoardController {
	
	private final BoardService bsv;
	private final likeService lsv;
	private final FileHandler fh;
	
	@GetMapping("/register")
	public void register() {}
	

	@PostMapping("/register")
	public String register(BoardVO bvo, MultipartFile[] files) {
		
		log.info(" board register bvo > {} " , bvo);	
		
		List<FileVO> flist = null;
		
		if(files[0].getSize() > 0) {
			// 파일의 내용이 있다면
			flist = fh.uploadFiles(files);
			log.info(">>> flist > {}", flist);
//			int isOk = bsv.hasFile(bvo.getBno());
		}		
		// files 정보를 이용하여 => List<FileVO> 변환을 하는 핸들러
		// FileHandler => return List<FileVO> + 파일 저장 
			
		BoardDTO bdto = new BoardDTO(bvo, flist); // bvo, flist
				
		int isOk = bsv.register(bdto);
		
		return "redirect:/board/list";			
	}
	
	@GetMapping({"/list","/sortCmt","/sortRead"})
	public String list(Model m, PagingVO pgvo, BoardVO bvo, HttpServletRequest request) {
		
		String path = request.getServletPath();
		
		List<BoardVO> list = null;
		
		if(path.equals("/board/list")) {
			 list = bsv.getList(pgvo);
		}
		if(path.equals("/board/sortCmt")) {
			 list = bsv.sortCmt(pgvo);
		}
		if(path.equals("/board/sortRead")) {
			 list = bsv.sortRead(pgvo);
		}
		
		int totalCount = bsv.getTotal(pgvo);

		PagingHandler ph = new PagingHandler(totalCount, pgvo);
				
		m.addAttribute("list",list);
		m.addAttribute("ph", ph);
		
		return "/board/list";
	}
	
	
	@GetMapping({"/detail","/modify"})
	public void detail(Model m, int bno, HttpServletRequest request) {
		
		String path = request.getServletPath();
		
		BoardDTO bdto = bsv.getDetail(bno);
		
		if(path.equals("/board/detail")) {
			int readCountOk = bsv.readCount(bno);
			bdto = bsv.getDetail(bno);
		}
		
		m.addAttribute("bdto",bdto);
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO bvo, @RequestParam(name="files", required = false)MultipartFile[] files) {
		
		List<FileVO> flist = null;
		
		if(files[0].getSize() > 0) {
			flist = fh.uploadFiles(files);
			log.info(">>> flist > {}", flist);
//			int isOk = bsv.hasFile(bvo.getBno());
		}
		
		int isOk = bsv.modify(new BoardDTO(bvo,flist));
					
		return "redirect:/board/detail?bno=" +bvo.getBno();
	}
	
	@GetMapping("/delete")
	public String delete(int bno) {
		int isOk = bsv.delete(bno);
		
		return "redirect:/board/list";
	}
	
	@ResponseBody
	@DeleteMapping(value="/file/{uuid}")
	public String fileDelete(@PathVariable("uuid") String uuid) {
		
		log.info(">>> modfiy uuid > {} ", uuid);
		
		int isOk2 = bsv.hasFileDelete(uuid);

		int isOk= bsv.fileDelete(uuid);
		
		
		return isOk > 0 ? "1" : "0";
	}
	
		
	@ResponseBody
	@GetMapping(value="/like/{bno}/{email}")
	public String isLike(@PathVariable("bno") long bno, @PathVariable("email") String email ) {
			
		log.info(">>>> bno, uno > {},{}", bno, email);
			
		int isOk= lsv.getLike(bno,email);
			
		return isOk>0? "1" : "0";
		
	}
	
	@ResponseBody
	@GetMapping(value="/regLike/{bno}/{email}")
	public String regLike(@PathVariable("bno") long bno, @PathVariable("email") String email) {
		int isOk = lsv.regLike(bno, email);
		
		int isUpdate = lsv.likeCount();
		
		return isOk>0? "1" : "0";
	}
	
	
	@ResponseBody
	@GetMapping(value="/delLike/{bno}/{email}")
	public String delLike(@PathVariable("bno") long bno, @PathVariable("email") String email) {
		int isOk = lsv.delLike(bno, email);
		
		int isUpdate = lsv.likeCount();
		
		return isOk>0? "1" : "0";
	}
	
	
		
	
}
