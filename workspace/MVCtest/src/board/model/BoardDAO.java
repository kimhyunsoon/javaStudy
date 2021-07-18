package board.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Board;
import static board.model.BoardSQL.*;



class BoardDAO {
	private DataSource ds;
	
	BoardDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		} catch (NamingException ne) {
		}
		
	}
	
	
	
	ArrayList<Board> list() {
		ArrayList<Board> list = new ArrayList<Board>();
		
		Connection con = null;
		Statement stmt = null;
	    ResultSet rs = null;
	    String sql = LIST;
	    try{
	    	con = ds.getConnection();
	    	stmt = con.createStatement();
	        rs = stmt.executeQuery(sql);
	        while(rs.next()){
	        	int seq = rs.getInt(1);
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
				String content = rs.getString(5);
				Date rdate = rs.getDate(6);
				
				Board dto = new Board(seq, writer, email, subject, content, rdate);
				list.add(dto);
	        }
			return list;
		} catch (SQLException se) {
			System.out.println("예외발생: "+se);
			return null;

		}finally{
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (SQLException se) {}
		}
	}

	void insert(Board dto){
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = INSERT;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			int i = pstmt.executeUpdate();
		} catch (SQLException se) {
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
		
	}
	
	ArrayList<Board> select(int seq){
		ArrayList<Board> select = new ArrayList<Board>();
		
		Connection con = null;
		PreparedStatement pstmt = null;	 
	    ResultSet rs = null;
		String sql = CONTENT;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			while(rs.next()){
	        	seq = rs.getInt(1);
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
				String content = rs.getString(5);
				Date rdate = rs.getDate(6);
				
				Board dto = new Board(seq, writer, email, subject, content, rdate);
				select.add(dto);
			}
			return select;
		} catch (SQLException se) {
			System.out.println("예외발생: "+se);
			return null;
		} finally{
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException se) {}
		}
		
	}
	
	boolean del(int seq) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = DELETE;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			int i = pstmt.executeUpdate();
			
			if(i > 0) {
				System.out.println("삭제 성공");
				return true;

			}else {
				System.out.println("삭제 실패");
				return false;
			}
		}catch(Exception e) {
			return false;
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}
	
	boolean update(Board dto, int seq){

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = UPDATE;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, seq);
			int i = pstmt.executeUpdate();
			if(i > 0) {
				System.out.println("수정 성공");
				return true;

			}else {
				System.out.println("수정 실패");
				return false;
			}
		} catch (SQLException se) {
			System.out.println("수정 실패"+se);
			return false;
		} finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
		
	}



}
