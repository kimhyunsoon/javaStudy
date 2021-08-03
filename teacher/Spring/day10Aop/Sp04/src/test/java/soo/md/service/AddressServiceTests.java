package soo.md.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import soo.md.domain.Address;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AddressServiceTests {
	//@Setter(onMethod_ = {@Autowired})
	@Resource(name="addressService1")
	private AddressService addressService;
	
	/*
	@Test
	public void testListS() {
		log.info("#addressServiceTests addressService: " + addressService);
		log.info("#addressServiceTests testList(): " + addressService.listS());
	}
	*/
	/*
	@Test
	public void testInsertS() {
		Address address = new Address(-1L, "양궁S", "파이팅S", null);
		addressService.insertS(address);
		log.info("#addressServiceTests testInsert() 수행 성공");
	}
	*/

	@Test
	public void testDeleteS() {
		long seq =31L;
		addressService.deleteS(seq);
		log.info("#addressServiceTests testDelete() 수행 성공");
	}
}
