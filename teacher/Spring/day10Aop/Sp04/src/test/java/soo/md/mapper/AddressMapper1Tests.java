package soo.md.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.extern.log4j.Log4j;
import soo.md.domain.Address;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AddressMapper1Tests {
	@Autowired
	private AddressMapper1 addressMapper;
	
	/*
	@Test
	public void testList() {
		log.info("#AddressMapperTests addressMapper: " + addressMapper);
		log.info("#AddressMapperTests testList(): " + addressMapper.list());
	}*/
	
	/*
	@Test
	public void testInsert() {
		Address address = new Address(-1L, "양궁", "파이팅", null);
		addressMapper.insert(address);
		log.info("#AddressMapperTests testInsert() 수행 성공");
	}*/
	
	@Test
	public void testDelete() {
		long seq = 5L;
		addressMapper.delete(seq);
		log.info("#AddressMapperTests testDelete() 수행 성공");
	}
}
