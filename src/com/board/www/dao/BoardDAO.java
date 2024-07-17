package com.board.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.board.www.dto.BoardDTO;


public class BoardDAO {
	// 데이터베이스 처리용 crud
	
	public void list(Connection connection) {
		
		BoardDTO boardDTO = null ;
		try {
			String sql = "select bno, btitle, bcontent, bwriter, bdate from board order by bno desc";
			PreparedStatement preparedStatement = connection.prepareStatement(sql); //3단계
			ResultSet resultset = preparedStatement.executeQuery(); //4단계
			boardDTO = new BoardDTO();
			while (resultset.next()) { //표 형식으로 리턴된 값 유무 판단
				
				System.out.print(resultset.getInt("bno")+"\t");
				System.out.print(resultset.getString("btitle")+"\t");
		//		System.out.print(resultset.getString("bcontent")+"\t");
				System.out.print(resultset.getString("bwriter")+"\t");
				System.out.print(resultset.getString("bdate")+"\t");
				System.out.println();
				
//				boardDTO.setBno(resultset.getInt("bno"));
//				boardDTO.setBtitle(resultset.getString("btitle"));
//				boardDTO.setBcontent(resultset.getString("bcontent"));
//				boardDTO.setBwriter(resultset.getString("bwriter"));
//				boardDTO.setBdate(resultset.getString("bdate"));
				
			}
			// 5 단계
			resultset.close();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("BoardDAO.list()에 sql문 오류");
			e.printStackTrace();
		}
		
	}
	
}
