package com.sh.spring.handler;

import java.util.List;

import com.sh.spring.domain.CommentVO;
import com.sh.spring.domain.PagingVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class PagingHandler {
	private int qty; 
	private int startPage; 
	private int endPage; 
	private boolean prev; 
	private boolean next;
	
	private int totalCount; 
	private PagingVO pgvo; 
	
	private int realEndPage; 
	
	private List<CommentVO> cmtList;
	
	// 생성자에서 모든 값들이 계산되어 설정되어야 함.
	public PagingHandler(int totalCount, PagingVO pgvo) {
		this.qty = 10;
		this.pgvo = pgvo;
		this.totalCount = totalCount;
		
		this.endPage = (int) Math.ceil(pgvo.getPageNo() / (double)qty) * qty;
		this.startPage = endPage - (qty-1);	
	
		this.realEndPage = (int)Math.ceil(totalCount / (double)pgvo.getQty());

		this.prev = this.startPage > 1;
		this.next = this.endPage < this.realEndPage;
		
		if(endPage > realEndPage) {
			this.endPage = realEndPage;
		}
	}
	
	// 댓글용 생성자
	public PagingHandler(int totalCount, PagingVO pgvo, List<CommentVO> cmtList) {
		this(totalCount,pgvo);
		this.cmtList = cmtList;
	}
}
