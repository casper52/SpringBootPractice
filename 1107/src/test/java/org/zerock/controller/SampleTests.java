package org.zerock.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;
import org.zerock.mapper.TimeMapper;
import org.zerock.service.SampleBean;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class SampleTests {

	@Setter(onMethod_=@Autowired)
	private SampleBean bean;
	
	@Setter(onMethod_=@Autowired)
	private DataSource ds;
	
	@Setter(onMethod_=@Autowired)
	private TimeMapper mapper;
	
	@Test
	public void testGetTime() {
		log.info(mapper.getTime());
	}
	
	@Test
	public void testExist() {
		log.info("==============================");
		log.info(bean.doA("ABCDE"));
		log.info("=============================");
		log.info("=============================");
	}
	
	@Test
	public void testTransaction() {
		
		String str = "그러면서 김태균은 \"원래 이수근 씨가 같은 동네(상암동)에 살았었는데 강남으로 이사를 갔다\"고 근황을 전했고, 이를 들은 현장의 관객들은 박수쳤다. 이에 이수근은 \"왜 강남으로 갔다고 하면 '와~'하시느냐. 강남 안에서도 차이가 어마어마하다. ";
		
		bean.doB(str);
				
	}
	
	
	@Test
	public void testCon() {
		try (Connection con = ds.getConnection()){
			
			log.info(con);
		
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	
}
