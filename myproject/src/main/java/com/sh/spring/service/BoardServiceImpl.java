package com.sh.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sh.spring.dao.BoardDAO;
import com.sh.spring.dao.CommentDAO;
import com.sh.spring.dao.FileDAO;
import com.sh.spring.domain.BoardDTO;
import com.sh.spring.domain.BoardVO;
import com.sh.spring.domain.CommentVO;
import com.sh.spring.domain.FileVO;
import com.sh.spring.domain.PagingVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
	
	private final BoardDAO bdao;
	private final FileDAO fdao;
	private final CommentDAO cdao;

	@Transactional // insert를 하는동안은 락을 걸어서 다른 접근을 못하게 막음
	@Override
	public int register(BoardDTO bdto) {
	
		int isOk = bdao.register(bdto.getBvo());
		if(bdto.getFlist() == null) { // 첨부파일이 없을 경우
			return isOk;
		}			
		// 첨부파일이 있는 케이스 
		if(isOk > 0 && bdto.getFlist().size() > 0) {
			// bno setting
			long bno = bdao.getOneBno(); // 가장 마지막에 저장된 bno
			for(FileVO fvo : bdto.getFlist()) {
				fvo.setBno(bno);
				isOk *= fdao.insertFile(fvo);				
			}			
		int size = bdto.getFlist().size();
		isOk = bdao.hasFileUpdate(bno, size);		
		}		
		return isOk;
	}
	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.getList(pgvo);
	}
	
	@Transactional
	@Override
	public BoardDTO getDetail(int bno) {
		
		BoardVO bvo = bdao.getDetail(bno);
		List<FileVO> flist = fdao.getList(bno);
		
		BoardDTO bdto = new BoardDTO(bvo, flist);
		
		return bdto;
	}

	@Override
	public int modify(BoardDTO boardDTO) {
		
		int isOk = bdao.modify(boardDTO.getBvo());
		if(boardDTO.getFlist() == null) {
			return isOk;
		}
		if(isOk > 0 && boardDTO.getFlist().size() > 0) {
			for(FileVO fvo : boardDTO.getFlist()) {
				fvo.setBno(boardDTO.getBvo().getBno());
				isOk *= fdao.insertFile(fvo);
			}
		int size = boardDTO.getFlist().size();
		isOk = bdao.hasFileUpdate(boardDTO.getBvo().getBno(), size);
		}
		return isOk;
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return bdao.delete(bno);
	}
	@Override
	public int getTotal(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.getTotal(pgvo);
	}
	
	@Override
	public int fileDelete(String uuid) {
		
		return fdao.fileDelete(uuid);
	}
	@Override
	public int readCount(int bno) {
		// TODO Auto-generated method stub
		return bdao.readCount(bno);
	}
	@Override
	public int updateCmtCount(long bno) {
		
		return bdao.updateCmtCount(bno);
	}
	
	@Override
	public int cmtQtyDelete(long cno) {		
		CommentVO cvo = cdao.getCvo(cno);	
		int isOk = bdao.cmtQtyDelete(cvo.getBno());
		return isOk;
	}
	@Override
	public int hasFileDelete(String uuid) {	
		
		FileVO fvo = fdao.getFvo(uuid);		
		int isOk = bdao.hasFileDelete(fvo.getBno());
		
		return isOk;
	}
	@Override
	public List<BoardVO> sortCmt(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.sortCmt(pgvo);
	}
	@Override
	public List<BoardVO> sortRead(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.sortRead(pgvo);
	}


}
