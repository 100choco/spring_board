package com.bbs.model;

import lombok.Data;

@Data
public class AttachFileDTO {

	private String fileName;	//파일이름
	private String uploadPath;	//경로
	private String uuid;		// 구별하기
	private boolean image;		//이미지인지아닌지
	// 다시 업로드컨트롤러로 간다. 업로드 에이젝스 액션에 있는 메서드로 간다. (대충 65~70라인에 있음)
	
}
