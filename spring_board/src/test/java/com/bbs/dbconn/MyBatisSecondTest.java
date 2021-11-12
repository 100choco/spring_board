package com.bbs.dbconn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbs.mapper.TestMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MyBatisSecondTest {
	
	@Autowired
	private TestMapper testMapper;
	
	@Test
	public void testTime() {
		
		log.info("==============================");
		log.info("현재시간은? ----->>>>>> "+testMapper.nowTime());
		log.info("==============================");
	}

}
