package board.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardService;
import domain.Board;

@WebServlet("/board/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m !=null) {
			m = m.trim();
			switch(m) {
			case "list": list(request, response); break;
			case "input": input(request, response); break; //�Է���
			case "insert": insert(request, response); break; //insert
			case "select": select(request, response); break; //select content
			case "del": del(request, response); break;
			case "modify": modify(request, response); break;
			case "update": update(request, response); break;
			}
		}else {
			list(request, response);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		ArrayList<Board> list = service.listS();
		request.setAttribute("list", list);
		String view = "b_list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);//��ġ���ϴ�
		rd.forward(request, response); //list.jsp�� ���������� �Ѱ��ش� 
		
	}
	
	private void input(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("b_write.jsp");
//		jsp���� jsp�� �ٷ� ȣ���ϴ°� �ƴ϶� �ݵ�� controller�� ��ġ���� ��.
//		b_list.jsp ���������� ���� ��ư�� ������ �� �Է����� ���ִ� b_write.jsp �� �������ش�
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		Board dto = new Board(-1, writer, email, subject, content, null);
		
		BoardService service = BoardService.getInstance();
		service.insertS(dto);
		response.sendRedirect("board.do");
		
		
	}
	
	private void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Board> select = null;
		String temp = request.getParameter("seq");
		if(temp !=null) {
			temp = temp.trim();
			try {
				int seq = Integer.parseInt(temp);
				BoardService service = BoardService.getInstance();
				select = service.selectS(seq);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		


		request.setAttribute("select", select);
		String view = "b_content.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);//��ġ���ϴ�
		rd.forward(request, response); //list.jsp�� ���������� �Ѱ��ش� 
		
	}
	
	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag = false;
		String temp = request.getParameter("seq");

		if(temp != null) {
			temp = temp.trim();
			try {
				int seq = Integer.parseInt(temp); 
				BoardService service = BoardService.getInstance();
				flag = service.delS(seq);
				
			} catch (NumberFormatException ne) {
				// TODO: handle exception
			}
			
		}
		request.setAttribute("flag", flag);
		
		String view = "b_del.jsp"; //list.jsp�� ã�ƶ�
		RequestDispatcher rd = request.getRequestDispatcher(view);//��ġ���ϴ�
		rd.forward(request, response); //list.jsp�� ���������� �Ѱ��ش� 
			
	}
	
	private void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Board> select = null;
		String temp = request.getParameter("seq");
		if(temp !=null) {
			temp = temp.trim();
			try {
				int seq = Integer.parseInt(temp);
				BoardService service = BoardService.getInstance();
				select = service.selectS(seq);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		request.setAttribute("select", select);
		String view = "b_modify.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);//��ġ���ϴ�
		rd.forward(request, response); //list.jsp�� ���������� �Ѱ��ش� 
	
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag = false;
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String temp = request.getParameter("seq");
		if(temp !=null) {
			temp = temp.trim();
			try {
				int seq = Integer.parseInt(temp);
				Board dto = new Board(-1, null, email, subject, content, null);
				BoardService service = BoardService.getInstance();
				flag = service.updateS(dto,seq);

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		request.setAttribute("flag", flag);
		String view = "b_update.jsp"; //list.jsp�� ã�ƶ�
		RequestDispatcher rd = request.getRequestDispatcher(view);//��ġ���ϴ�
		rd.forward(request, response); //list.jsp�� ���������� �Ѱ��ش� 

		
		
	}
	
	
	
	
	

	
}
