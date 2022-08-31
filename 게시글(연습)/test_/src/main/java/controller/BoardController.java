package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import service.BoardService;
import service.BoardServiceImpl;


@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class); 
	private String destPage; 
	private RequestDispatcher rdp;  
	private BoardService bsv; 
	private int isUp; 
       
    
    public BoardController() {
        bsv = new BoardServiceImpl(); 
    }

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		
	    String uri = req.getRequestURI();    
	    String path = uri.substring(uri.lastIndexOf("/")+1); 
		
		
	    switch(path) {
	    case "register":
	    	destPage = "/board/register.jsp"; 
	    	System.out.println(">>>> path " + path); 
	    	break;
	    case "insert":
	   	    	try { 
	    		String title = req.getParameter("title");
	    		String writer = req.getParameter("writer");
	    		String content=req.getParameter("content");
	    		System.out.println("check 1");
	    		System.out.println(">>>>path" + path);
	    		isUp = bsv.register(new BoardVO(title, writer, content));
	    		System.out.println("check 4");
	    		destPage="list";
	    	} catch (Exception e) {
	    	  e.printStackTrace();
	    		System.out.println("insert 실패");
	    	}
	    	break;
	    case "list":
	    	try {
				List<BoardVO> list=bsv.getList(); 
				System.out.println("check 2-1");
				destPage ="/board/list.jsp";
				req.setAttribute("list", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    	break;
	    case "detail":
	    	try {
	    		int bno = Integer.parseInt(req.getParameter("bno"));
	    		System.out.println("check 3-1");
	    		BoardVO bvo = bsv.getDetail(bno);
	    	     System.out.println("check 3-4");
	    	     req.setAttribute("bvo", bvo);
	    	     System.out.println(">>>>path" + path);
	    	     destPage="/board/detail.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	break;
	    case "modify":
	    	try {
	    		int bno = Integer.parseInt(req.getParameter("bno"));
	    		BoardVO bvo = bsv.getDetail(bno);
	    		req.setAttribute("bvo", bvo);
	    		destPage="/board/modify.jsp";
			} catch (Exception e) {
				   e.printStackTrace();
			}
	    	break;
	    case "update":
	    	try {
				int bno = Integer.parseInt(req.getParameter("bno"));
				String title = req.getParameter("title");
				String content = req.getParameter("content");
				BoardVO bvo = new BoardVO(bno, title, content);
				System.out.println("check 4-1");
				isUp = bsv.modify(bvo);
				System.out.println("update" + (isUp >0 ? "OK" : "FAIL"));
				destPage= "detail?bno="+bvo.getBno();
			} catch (Exception e) {
				System.out.println(">>>> update >> fail ");
			}
	    	break;
	    case "remove":
	    	try {
	    		int bno = Integer.parseInt(req.getParameter("bno"));
	    		isUp = bsv.remove(bno);
	    		System.out.println("remove"+(isUp  >  0 ? "OK " : "FAIL"));
	    		destPage = "list";
	    	} catch (Exception e) {
				System.out.println(">>>> remove >> fail");
			}
	    	break;
	    }
		rdp = req.getRequestDispatcher(destPage);
		rdp.forward(req, res);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response); 
	}

}
