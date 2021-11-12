package com.bbs.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardDTO {
	
	private Long bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private Timestamp bregdate;

}
