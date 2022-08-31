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
	//로그기록파일
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);   // -Log를 org.slf4j로 인포트 해주기
	private String destPage; // 목적지 위치 기록
	private RequestDispatcher rdp;   //jsp에서 받은 요청을 처리하고, 다른 jsp로 결과를 보내는 방식
	private BoardService bsv; //아직 미구현 : 앞으로 생성할 예정 (service폴더 interface 생성 -> 저장)
	private int isUp; // 해당 구문이 잘 이루어졌는지 체크하기 위한 값

       
    
    public BoardController() {
        bsv = new BoardServiceImpl(); //bsv를 구현할 BoardServiceImpl 생성 -> 저장
    }

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//req, res encoding 설정
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		
	    String uri = req.getRequestURI();    // /brd/insert 주소를 uri로 받음.
	    String path = uri.substring(uri.lastIndexOf("/")+1); // 마지막 기능만 추출 insert 
		
		// 실제 controller 처리부분
	    switch(path) {
	    case "register":
	    	//register -> 글쓰기 페이지를 출력
	    	destPage = "/board/register.jsp"; //웹 board 폴더의 trgister.jsp 파일 경로를 실어서 보냄.
	    	System.out.println(">>>> path " + path); //완료 후 콘솔에 찎을 내용
//	    	Log.Info(">>>path"+path); //log파일 사용시.
	    	break;
	    case "insert":
	    	//insert -> 글쓰기 등록 버튼을 눌렀을 떄 글을 등록 -> list 페이지로 이동
	    	try { //오류가 날떄는 대비해서 항상 try~catch문을 이용
	    		String title = req.getParameter("title");
	    		String writer = req.getParameter("writer");
	    		String content=req.getParameter("content");
	    		System.out.println("check 1");
	    		System.out.println(">>>>path" + path);
	    		isUp = bsv.register(new BoardVO(title, writer, content));
	    		System.out.println("check 4");
	    		destPage="list";
	    	} catch (Exception e) {
	    		// insert 실패시 나오는 메세지
	    		e.printStackTrace();
	    		System.out.println("insert 실패");
	    	}
	    	break;
	    case "list":
	    	//list -> list 페이지 출력
	    	try {
				List<BoardVO> list=bsv.getList(); //service getList()추가
				System.out.println("check 2-1");
				destPage ="/board/list.jsp";
				req.setAttribute("list", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    	break;
	    case "detail":
	    	//detail -> detail 페이지를 보여줌. -> 번호를 이용하여 그 내용을 가져와서 디테일 페이지에 출력
	    	try {
				//번호가 필요. 해당 번호에 디테일 페이지 출력.
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
	    	//modify -> modify페이지로 이동 -> 번호를 이용하여 그 번호에 대한 수정
	    	try {
				//번호가 필요. 해당 번호에 대한 수정페이지로 이동.
	    		int bno = Integer.parseInt(req.getParameter("bno"));
	    		BoardVO bvo = bsv.getDetail(bno);
	    		req.setAttribute("bvo", bvo);
	    		destPage="/board/modify.jsp";
			} catch (Exception e) {
				   e.printStackTrace();
			}
	    	break;
	    case "update":
	    	//update -> 수정한 데이터를 클래스로 생성 update -> detail 페이지로 이동
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
	    	//remove -> 삭제가 이루어지고 번호를 이용하여 -> list로 이동
	    	try {
			    //번호에 해당하는 게시물을 삭제
	    		int bno = Integer.parseInt(req.getParameter("bno"));
	    		isUp = bsv.remove(bno);
	    		System.out.println("remove"+(isUp  >  0 ? "OK " : "FAIL"));
	    		destPage = "list";
	    	} catch (Exception e) {
				System.out.println(">>>> remove >> fail");
			}
	    	break;
	    }
		rdp = req.getRequestDispatcher(destPage); //목적지의 경로로 응답함.
		rdp.forward(req, res);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response); //get방식으로 요청하는 값을 위의 서비스 메서드를 불러와서 요청, 응답함.
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response); //post방식으로 요청하는 값을 위의 서비스 메서드를 불러와서 요청, 응답함.
	}

}
