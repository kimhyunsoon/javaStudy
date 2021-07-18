package board.model;

import java.util.ArrayList;

import domain.Board;

public class BoardService {

	private BoardDAO dao;
	//SingleTon Object Model - start!! 
	private static final BoardService instance = new BoardService();
	
	private BoardService() {
		dao = new BoardDAO();
	}
	
	public static BoardService getInstance() {
		return instance;
	}
	//SingleTon Object Model - end!! 
	public ArrayList<Board> listS(){
		return dao.list();
	}
	
	public ArrayList<Board> selectS(int seq){
		return dao.select(seq);
	}
	
	public void insertS(Board dto) {
		dao.insert(dto);
	}
	
	public boolean updateS(Board dto, int seq) {
		return dao.update(dto, seq);
	}
	
	public boolean delS(int seq) {
		return dao.del(seq);
	}
}
