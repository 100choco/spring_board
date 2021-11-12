package com.bbs.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class PersonDTO {
	private int pno;
	private String pname;
	private String pphoneNumber;
	private String paddress;
	private int page;
	private String pgender;
	private Timestamp pregdate;
	
}
