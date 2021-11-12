package com.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.mapper.PersonMapper;
import com.bbs.model.PersonDTO;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonMapper pMapper;
	
	@Override
	public List<PersonDTO> person_list_all() {
		
		return pMapper.person_list_all();
	}

	@Override
	public void insert(PersonDTO dto) {
		pMapper.insert(dto);
		
	}

	@Override
	public PersonDTO personContent(Long pno) {
		// TODO Auto-generated method stub
		return pMapper.personContent(pno);
	}

	@Override
	public void update(PersonDTO dto) {
		pMapper.update(dto);
		
	}

	@Override
	public void delete(Long pno) {
		pMapper.delete(pno);
		
	}

	
}
