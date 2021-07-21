package board.mvc.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import addr.mvc.model.AddrService;
import board.mvc.model.BoardService;
import mvc.domain.Address;
import mvc.domain.Board;

@WebServlet("/board/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch(m) {
				case "list": list(request, response); break;
				case "write": write(request, response); break;
				case "insert": insert(request, response); break;
				case "content": select(request, response, m); break;
				case "update_form": select(request, response, m); break;
				case "update": update(request, response); break;
				case "del": del(request, response); break;
				
			}
		}else {
			list(request, response);
		}
	}
	public void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		ArrayList<Board> list = service.listS();
		request.setAttribute("list", list);
		
		String view = "list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	public void write(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "write.jsp";
		response.sendRedirect(view);
	}
	public void insert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		Board board = new Board(-1, writer, email, subject, content, null);
		service.insertS(board);
		
		String view = "board.do";
		response.sendRedirect(view);
	}
	public void select(HttpServletRequest request, HttpServletResponse response, String m) 
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		long seq = getSeq(request);
		if(seq != -1L) {
			Board board = service.selectS(seq);
			
			String view = "content.jsp";
		    if(m.equals("update_form")) view = "update.jsp"; 
		    
			request.setAttribute("board", board);
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}else {
			String view = "board.do";
			response.sendRedirect(view);
		}
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		
		long seq = getSeq(request);
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		Board board = new Board(seq, null, email, subject, content, null);
		service.updateS(board);
		
		String view = "board.do";
		response.sendRedirect(view);
	}
	public void del(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		long seq = getSeq(request);
		if(seq != -1L) service.delS(seq);
			
		String view = "board.do";
		response.sendRedirect(view);
	}
	
	private Long getSeq(HttpServletRequest request) {
		String seqStr = request.getParameter("seq");
		if(seqStr != null) {
			try {
				long seq = Long.parseLong(seqStr);
				return seq;
			}catch(NumberFormatException ne) {
				return -1L;
			}
		}else {
			return -1L;
		}
	}
}