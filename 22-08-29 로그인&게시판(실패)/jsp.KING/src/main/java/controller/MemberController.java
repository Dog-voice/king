package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;



@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
    private  RequestDispatcher rdp;
    private MemberService msv; 
    private String destPage; 
    private int isUp; 
    
    public MemberController() {
        msv =  new MemberServiceImpl(); 
    }

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    req.setCharacterEncoding("utf-8");
	    res.setCharacterEncoding("utf-8");
	    res.setContentType("text/html; charset=utf-8");
	    
	    String uri = req.getRequestURI();    
	    String path = uri.substring(uri.lastIndexOf("/")+1);
	    
	    switch(path) {
	    case "join" :
	    	System.out.println("check 1");
	    	destPage = "/member/join.jsp";	
	        break;
	        
	    case "register":
	    	System.out.println("check 2");
	    	isUp = msv.register(new MemberVO(req.getParameter("id"),
	    		        req.getParameter("password"), req.getParameter("email"),
	    		        Integer.parseInt(req.getParameter("age"))));
	    	log.info(">> join > ", isUp  > 0? "ok" : "fail");
	    	destPage="/";
	    	break;
	    
	    case "login":
	    	MemberVO mvo = msv.login(new MemberVO(req.getParameter("id"),
	    			req.getParameter("password")));
	    	if(mvo != null) { 
	    		HttpSession ses = req.getSession(); 
	    		ses.setAttribute("ses", mvo);
	    		ses.setMaxInactiveInterval(10*60); 
	 	
	    		
	    	}else {    
	    		req.setAttribute("msg_login", 0);
	    	}
	    	destPage="/";
	    	break;
	    	
	    case "logout":
	    	HttpSession ses = req.getSession(); 
	    	ses.invalidate(); 
	    	destPage = "/";
	    	break;
	    	
	    case "list":
	    	req.setAttribute("list", msv.getList());  
	    	destPage="/member/list.jsp";
    	        break;
    	        
	    case "modify":
	    	    req.setAttribute("mvo", msv. getDetail(req.getParameter("id")) );
	    		destPage="/member/modify.jsp";
	    	break;
	    	
	    case "update": 
	    	isUp = msv.modify(new MemberVO(req.getParameter("id"),
    		        req.getParameter("password"), req.getParameter("email"),
    		        Integer.parseInt(req.getParameter("age"))));
	     req.setAttribute("msg_mod", msv);
    	log.info(">> update > ", isUp  > 0? "ok" : "fail");
	    	destPage= "list";
	    	break;
	    	
	    case "remove":
	    	isUp = msv.remove(req.getParameter("id"));
    		System.out.println("remove"+(isUp  >  0 ? "OK " : "FAIL"));
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
