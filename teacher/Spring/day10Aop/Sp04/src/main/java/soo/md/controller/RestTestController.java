package soo.md.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import soo.md.domain.Address;
import soo.md.service.AddressAjaxService;

@RestController
@RequestMapping("rest")
public class RestTestController {
	@Autowired
	private AddressAjaxService service;
	
	//@GetMapping("getText")
	@GetMapping(value="getText", produces="text/plain;charset=utf-8")
	public String getText() {
		return "한글";
	}
	
	//@GetMapping(value="getAddress", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	@GetMapping("getAddress")
	public Address getAddress() {
		//return service.selectBySeqS(2);
		return new Address(1, "홍길동", "서울시", new Date(2021-1900, 7-1, 30));
	}
	
	//@GetMapping(value="getList", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	@GetMapping("getList")
	public List<Address> getList(){
		//return service.listS();
		
		List<Address> list = new ArrayList<Address>();
		list.add(new Address(1, "홍길동", "서울시", new Date(2021-1900, 7-1, 30)));
		list.add(new Address(2, "이순신", "부산시", new Date(2021-1900, 7-1, 30)));
		return list;
	}
	
	@GetMapping("getMap")
	public Map<String, Address> getMap(){
		Map<String, Address> map = new HashMap<String, Address>();
		map.put("first", new Address(1, "홍길동", "서울시", new Date(2021-1900, 7-1, 30)));
		map.put("second", new Address(2, "이순신", "부산시", new Date(2021-1900, 7-1, 30)));
		return map;
	}
	
	@GetMapping("check")
	public ResponseEntity<Address> check(@RequestParam("height") double h, @RequestParam("weight") double w) {
		Address a = new Address(3, ""+h, ""+w, new Date(2021-1900, 7-1, 30));
		
		ResponseEntity<Address> result = null;
		if(h<150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(a);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(a);
		}
		
		return result;
	}
	
	@GetMapping("product/{cat}/{pid}")
	public String[] getPath(@PathVariable String cat, @PathVariable int pid) {
		String strs[] = {"카테고리: "+cat , " 상품아이디: " + pid};
		return strs;
	}	
}