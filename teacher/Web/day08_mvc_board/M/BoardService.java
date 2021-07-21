package board.mvc.model;

import java.util.ArrayList;

import mvc.domain.Board;

public class BoardService {
	private BoardDAO dao;
	private static final BoardService instance = new BoardService();
	private BoardService() {
		dao = new BoardDAO();
	}
	public static BoardService getInstance() {
		return instance;
	}
	
	public ArrayList<Board>  listS(){
		return dao.list();
	}
	public void insertS(Board board) {
		dao.insert(board);
	}
	public Board selectS(long seq) {
		return dao.select(seq);
	}
	public void updateS(Board board) {
		dao.update(board);
	}
	public void delS(long seq) {
		dao.del(seq);
	}
}
