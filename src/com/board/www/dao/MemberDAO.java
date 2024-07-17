package com.board.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.board.www.dto.MemberDTO;

public class MemberDAO {
	//회원 db에 대한 C회원가입    R로그인    U회원정보수정    D회원탈퇴
	
	public MemberDAO() {
		
	}//기본 생성자
	
	public MemberDAO(Connection connection) {
		// TODO Auto-generated constructor stub
	}//커스텀 생성자
	
//	public void register(Connection connection, MemberDTO ) { //회원가입
//		MemberDTO registerDTO = new MemberDTO();
//		//String sql = "insert mno, mpw, mdate from member?"
//	}
	public MemberDTO login(Connection connection, MemberDTO loginMemberDTO ) { //로그인
		// connection -> main 에서 넘어온 jdbc 1,2단계
		// loginMemberDTO -> 로그인시 키보드로 입력받은 id, pw값이 들어 있다.
		// db에 있는 로그인 값을 찾아 옴
		MemberDTO loginDTO = new MemberDTO(); 
		try {
			String sql = "select mno, mid, mpw, mdate from member where mid=? and mpw =? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1 , loginMemberDTO.getMid());
			// service 에서 받은 id가 첫번째 ? 에 적용
			preparedStatement.setString(2 , loginMemberDTO.getMpw());
			// service 받은 pw가 두번째 ?에 적용
			
			ResultSet resultSet = preparedStatement.executeQuery();
			//위에서 만든 쿼리문을 실행하고 결과를 resultSet표로 받는다.
			
			while (resultSet.next()) {
				
				loginDTO.setMno(resultSet.getInt("mno"));
				loginDTO.setMid(resultSet.getString("mid"));
				loginDTO.setMpw(resultSet.getString("mpw"));
				loginDTO.setMdate(resultSet.getDate("mdate"));
				//resultset 표에 있는 정보를 MemberDTO에 가져옴
			}
			resultSet.close();
			preparedStatement.close();
			//return loginDTO;
		} catch (SQLException e) {
			System.out.print("찾는 id와 pw가 없습니다.");
			System.out.println("관리자 : sql문을 확인하세요.");
			System.out.print("회원 : id와 pw를 확인하세요.");
			e.printStackTrace();
		}
		return loginDTO; //로그인 완성용 객체
	}
	
	public void delete() { //회원탈퇴
		
	}

	public void register(Connection connection, MemberDTO newMember) {
		
		PreparedStatement preparedStatement;
		try {String sql = "INSERT INTO member (mno, mid, mpw, mdate) VALUES (board_seq.NEXTVAL, ?,?, sysdate)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newMember.getMid());
			preparedStatement.setString(2, newMember.getMpw());
			preparedStatement.executeUpdate();
			System.out.println("회원가입이 완료되었습니다.");
			preparedStatement.close();
			
		} catch (SQLException e) {
			System.out.println("회원 등록 중 오류가 발생했쒀요.");
			e.printStackTrace();
		}//catch close
		
		public void updatePassword(Connection connection) {
	        String sql = "UPDATE board SET mpw = ? WHERE mid = ?";
	        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	            pstmt.setString(1, MemberDAO.getmid());
	            pstmt.setString(2, MemberDAO.getmpw());

	            int result = pstmt.executeUpdate();

	            if (result > 0) {
	                connection.commit();
	               
	            } else {
	                connection.rollback();
	            
	            }
	        } catch (SQLException e) {
	            System.out.println("비밀번호 수정 중 오류 발생: " + e.getMessage());
	            e.printStackTrace();
	            try {
	                connection.rollback();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	            return false;
	        }
		
	}//insertmember close
}
