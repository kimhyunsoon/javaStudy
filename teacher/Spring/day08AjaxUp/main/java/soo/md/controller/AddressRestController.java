package soo.md.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;
import soo.md.domain.Address;
import soo.md.service.AddressAjaxService;

@Log4j
@RestController
@RequestMapping("rest_addr")
public class AddressRestController { //CRUD
	@Autowired
	private AddressAjaxService service;
	
	//(1) Create (insert)
	@PostMapping("create")
	public void create(@RequestBody Address address) {
		log.info("#AddressRestController create() address: " + address);
		service.insertS(address);
	}//http://127.0.0.1:8080/rest_addr/create 또는 create.xml 또는 create.json
	//{"seq":-1, "name":"준석1", "addr":"광주1", "rdate":"2021-07-30"} (X)
	//{"seq":-1, "name":"준석2", "addr":"광주2"} (O)
	//{"name":"준석3", "addr":"광주3"}  (O)
	
	
	//(2) Read (select)
	@GetMapping("read")
	public List<Address> read(){
		List<Address> list = service.listS();
		return list;
	}//http://127.0.0.1:8080/rest_addr/read.json
	
	@GetMapping("read/{seq}")
	public Address read(@PathVariable long seq){
		Address address = service.selectBySeqS(seq);
		return address;
	}//http://127.0.0.1:8080/rest_addr/read/31.json 또는 http://127.0.0.1:8080/rest_addr/read/31.xml
	
	@GetMapping(value="read", params = {"na"} )
	public List<Address> read(@RequestParam("na") String name){
		List<Address> list = service.selectByNameS(name);
		return list;
	}//http://127.0.0.1:8080/rest_addr/read.json?na=오늘
	
	//(3) Delete (delete)
	@DeleteMapping("delete/{seq}")
	public void delete(@PathVariable long seq) {
		service.deleteS(seq);
	}//http://127.0.0.1:8080/rest_addr/delete/33
}
