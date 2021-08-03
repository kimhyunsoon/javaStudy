package soo.md.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TxSampleServiceTests {
	@Autowired
	private TxSampleService service;
	
	@Test
	public void testAddDatas() {
		//String data = "점심";
		//String data = "사랑은 달콤하고 엄마처럼 다정하고 잠처럼 편하고 꿈처럼 행복한거야";
		String data = "어쩌다 마주친 그대 모습이 내마음을 사로잡아 버렸네";
		
		long len = data.getBytes().length;
		log.info("#입력하려는 바이트수: " + len);
		
		service.addDatas(data);
	}
}
