package board.mvc.model;

class BoardSQL {
	static final String LIST = "select * from BOARD order by SEQ desc";
	static final String INSERT = "insert into BOARD values(BOARD_SEQ.nextval, ?,?,?,?, SYSDATE)";
	static final String SELECT = "select * from BOARD where SEQ=?";
	static final String UPDATE = "update BOARD set EMAIL=?, SUBJECT=?, CONTENT=? where SEQ=?";
	static final String DEL = "delete from BOARD where SEQ=?";
}
