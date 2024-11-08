package com.sh.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class likeVO {
	private int lno;
	private String likeEmail;
	private int likeBno;
	private int lyn;
}
