package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;


@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rdp;   
	private MemberService msv; 
	private String destPage;  
	private int isUp;

  
    public MemberController() {
        msv = new MemberServiceImpl(); 
    }

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=UTF-8");
		
		String uri = req.getRequestURI(); 
		String path = uri.substring(uri.lastIndexOf("/")+1); 
		
		switch(path) {
		case "login": 
			destPage = "/member/login.jsp";
			break;
			
		case "login_auth": 
			MemberVO mvo = msv.login(new MemberVO(  
					req.getParameter("email"),
					req.getParameter("pwd")
					));
			if(mvo != null) {
				HttpSession ses = req.getSession(); 
				ses.setAttribute("ses", mvo);
				ses.setMaxInactiveInterval(600);  
			}else {
				req.setAttribute("msg_login",  0) ;  
			}
			destPage="/";
			break;
			
		case "logout":
			HttpSession ses = req.getSession();
			ses.invalidate(); //접속 끊기
			isUp = msv.lastLogin(req.getParameter("email"));
			destPage="/";
			break;
			
		case "join": 
			destPage = "/member/join.jsp";
			break;
			
		case "register": 
			isUp = msv.register(new MemberVO( 
					req.getParameter("email"),
					req.getParameter("pwd"),
				    req.getParameter("nick_name")));
		    destPage="login";
			break;
			
		case "list":  
			req.setAttribute("list", msv.getList());
			destPage="/member/list.jsp";
			break;
			
		case "modify":  
			req.setAttribute("mvo", msv.getDetail(req.getParameter("email")));
			destPage = "/member/modify.jsp";
			break;
			
		case "update": 
			isUp = msv.modify(new MemberVO(
					req.getParameter("email"),
					req.getParameter("pwd"),
					req.getParameter("nick_name")
					));
			destPage="list";
			break;
			
		case "remove": 
			isUp = msv.remove(req.getParameter("email"));
			destPage = "list";
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
