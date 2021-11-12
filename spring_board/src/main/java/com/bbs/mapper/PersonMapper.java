package com.bbs.mapper;

import java.util.List;

import com.bbs.model.PersonDTO;

public interface PersonMapper {

	public List<PersonDTO> person_list_all();

	public void insert(PersonDTO dto);

	public PersonDTO personContent(Long pno);

	public void update(PersonDTO dto);

	public void delete(Long pno);

}
