package com.board.www.dto;

import java.sql.Date;

public class BoardDTO {
	//board용 객체 처리, 세터, 게터
	
	//필드
	private int bno ;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private Date bdate; 
	
	// 기본 생성자
	public BoardDTO() {
		
	}

	public BoardDTO(int bno, String btitle, String bcontent, String bwriter, Date bdate) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
		this.bdate = bdate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}; // insert, select 시 활용
	//메서드
	
}
