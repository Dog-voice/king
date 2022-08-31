package domain;

 

public class BoardVO {

	private int bno;

	private String title;

	private String writer;

	private String content;

	private String reg_date;

	

	// 기본 생성자

	public BoardVO() {}

	

	// 각자 설정에 맞춘 생성자 생성

	// insert

	public BoardVO(String title, String writer, String content) {

		this.title = title;

		this.writer = writer;

		this.content = content;

	}

	// list

	public BoardVO(int bno, String title, String writer, String reg_date) {

		this.bno = bno;

		this.title = title;

		this.writer = writer;

		this.reg_date = reg_date;

	}

	// update

	public BoardVO(int bno, String title, String content) {

		this.bno = bno;

		this.title = title;

		this.content = content;

	}

	// detail 

	public BoardVO(int bno, String title, String writer, String reg_date, String content) {

		this(bno, title, writer, reg_date);

		this.content = content;

	}

 

	public int getBno() {

		return bno;

	}

 

	public void setBno(int bno) {

		this.bno = bno;

	}

 

	public String getTitle() {

		return title;

	}

 

	public void setTitle(String title) {

		this.title = title;

	}

 

	public String getWriter() {

		return writer;

	}

 

	public void setWriter(String writer) {

		this.writer = writer;

	}

 

	public String getContent() {

		return content;

	}

 

	public void setContent(String content) {

		this.content = content;

	}

 

	public String getReg_date() {

		return reg_date;

	}

 

	public void setReg_date(String reg_date) {

		this.reg_date = reg_date;

	}

	

	

}
