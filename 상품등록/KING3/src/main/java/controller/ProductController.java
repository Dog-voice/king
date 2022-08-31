package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ProductVO;
import service.ProductService;
import service.ProductServiceImpl;


@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService svc;
       
  
    public ProductController() {
      svc = new ProductServiceImpl();  //class 파일을 service 폴더에 생성
    }

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//request/response encoding 설정
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=UTF-8");
		
		String uri = req.getRequestURI(); //요청 경로
		System.out.println(">>>> uri : " + uri);
		String context = req.getContextPath(); //프로젝트 명
		System.out.println(">>> context : " + context);
		String path = uri.substring(uri.lastIndexOf("/")+1);
		System.out.println(">>> path : " + path);
		
		//서비스 처리
		String destPage="";
		if(path.equals("register.pd")) {//equals
			destPage = "/product/register.jsp";
		}
		else if(path.equals("insert.pd")) {
			ProductVO pvo = new ProductVO(
					req.getParameter("pname"),
					Integer.parseInt(req.getParameter("price")),
					req.getParameter("made_by"));
			int isUp = svc.register(pvo);
			destPage="/index.jsp";				
			
		}
		else if(path.equals("list.pd")) {
			req.setAttribute("list", svc.getList());
			destPage = "/product/list.jsp";
		}
		else if(path.equals("detail.pd")) {
			//pno에 해당하는 디테일 값을 표현
			req.setAttribute("pvo", svc.getDetail(
					Integer.parseInt(req.getParameter("pno"))));
			destPage="/product/detail.jsp";
		}
		else if(path.equals("modify.pd")) {
			req.setAttribute("pvo", svc.getDetail(
					Integer.parseInt(req.getParameter("pno"))));
			destPage="/product/modify.jsp";
			
		}
		else if(path.equals("update.pd")) {
			ProductVO pvo = new ProductVO(
					Integer.parseInt(req.getParameter("pno")),
					req.getParameter("pname"),
					Integer.parseInt(req.getParameter("price")),
					req.getParameter("made_by"));
			int isUp = svc.modify(pvo);
			destPage = "detail.pd";
			
		}
		else if(path.equals("remove.pd")) {
			int isUp = svc.remove(
					Integer.parseInt(req.getParameter("pno")));
			destPage = "/";
		}
		RequestDispatcher rdp = req.getRequestDispatcher(destPage);
		rdp.forward(req, res);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get pno=?${pno}
		service(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post method="post" // 보안상 더 우수
		service(request, response);
	}

}
