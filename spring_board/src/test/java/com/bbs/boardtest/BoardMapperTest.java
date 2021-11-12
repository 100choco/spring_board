package com.bbs.boardtest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbs.mapper.BoardMapper;
import com.bbs.model.BoardDTO;
import com.bbs.page.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {
	
	@Autowired
	private BoardMapper boardMapper;
	
	//@Test
	public void boardInsertTest() {
	
		for(int i = 1; i<=1000; i++) {
			BoardDTO dto = new BoardDTO();
			dto.setBtitle(i+"�� �����Դϴ�.");
			dto.setBcontent(i + "�� �����Դϴ�.");
			dto.setBwriter(i+ "�� �ۼ����Դϴ�.");
			
			boardMapper.insert(dto);
		}

	}
	
	//@Test
	public void boardListAllTest() {
		List<BoardDTO> list = boardMapper.list_all();
		for(BoardDTO i : list) {
			System.out.println(i);
		}
	}
	
	//@Test
	public void deleteTest() {
		boardMapper.delete(2L);
	}
	
	//@Test
	public void boardContentTest() {
		BoardDTO dto = boardMapper.boardContent(1L);
		System.out.println(dto);
	}
	
//	@Test
	public void boardUpdateTest() {
		BoardDTO dto = new BoardDTO();
		dto.setBno(1L);
		dto.setBtitle("������ �����Դϴ�.");
		dto.setBcontent("������ �����Դϴ�.");
		
		boardMapper.update(dto);
	}

//	//@Test
//	public void update() {
//		BoardDTO dto = new BoardDTO();
//		dto.setBno(1L);
//		dto.setBtitle("��������");
//		dto.setBcontent("��������");
//		dto.setBwriter("������");
//		boardMapper.update(dto);
//		
//		System.out.println(dto);
//	}
//	
//	//@Test
//	public void delete() {
//		boardMapper.delete(4L);
//	}
	
	@Test
	public void pagingTest() {
		Criteria cri = new Criteria();
		cri.setPageNum(10);
		cri.setAmount(30);
		List<BoardDTO> list = boardMapper.getListPaging(cri);
		list.forEach(i->System.out.println(i));
	}

}
