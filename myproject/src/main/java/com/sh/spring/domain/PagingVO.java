package com.sh.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Setter
@Getter
public class PagingVO {
	
	private int pageNo;
	private int qty;
	
	private String type;
	private String keyword;
	
	public PagingVO() {
		this.pageNo = 1;
		this.qty = 10;
	}
	
	public PagingVO(int pageNo, int qty) {
		this.pageNo = pageNo;
		this.qty = qty;
	}

	// DB에서 사용될 시작번지 구하기
	// select * from board limit 번지,개수
	// 1페이지는 limit 0,10 => 2페이지 limit 10,20 => 3페이지 limit 20,30
	public int getPageStart() {
		return (this.pageNo - 1) * this.qty;
	}
	
	// type의 복합 타입을 각각 검색하기 위해 배열로 생성
	// type == twc [t, w, c] 
	public String[] getTypeToArray() {
		return this.type == null ? new String[] {} : this.type.split("");
	}
	
}
