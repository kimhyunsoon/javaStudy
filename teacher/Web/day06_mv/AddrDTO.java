package soo.mv.model;

import java.sql.Date;

public class AddrDTO {
	private int seq;
	private String name;
	private String addr;
	private Date rdate;
	//(1) 持失切 
	public AddrDTO() {}
	public AddrDTO(int seq, String name, String addr, Date rdate) {
		this.seq = seq;
		this.name = name;
		this.addr = addr;
		this.rdate = rdate;
	}
	//(2) setter 五社球 
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	//(3) getter 五社球 
	public int getSeq() {return seq;}
	public String getName() {return name;}
	public String getAddr() {return addr;}
	public Date getRdate() {return rdate;}
}
