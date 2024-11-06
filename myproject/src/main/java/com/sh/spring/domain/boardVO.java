package com.sh.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class boardVO {
	private long bno;
	private String title;
	private String writer;
	private String content;
	private String isDel;
	private String regDate;
	private int readCount;
}
