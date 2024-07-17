package com.board.www.service;

import java.sql.Connection;
import java.util.Scanner;

import com.board.www.dao.MemberDAO;
import com.board.www.dto.MemberDTO;

public class MemberService {
	//회원에 대한 처리 C(회원가입) R(로그인) U(회원정보 수정) D(회원 탈퇴)
	
	public MemberDTO memberMenu(Scanner scanner, MemberDTO loginMember, Connection connection) { //while문으로 부메뉴 반복 처리
		System.out.println("회원관리용 서비스로 진입");
		boolean memberRun = true;
		while (memberRun) {
		System.out.println("1. 회원가입 2. 로그인 3. 회원수정 4. 회원탈퇴 5. 종료");
		System.out.println(">>>");
		int memberSelect = scanner.nextInt();
		
			switch (memberSelect) {
			case 1:
				join(scanner, connection);
				break;
			case 2:
				loginMember=login(scanner, loginMember, connection);
				break;
			case 3:
				modify();
				break;
			case 4:
				delete();
				break;
			case 5:
				System.out.println("종료");
				memberRun = false;
			}// switch close
		}//while close
		return loginMember;
		
	} //memberMenu close
	
	public void join(Scanner scanner, Connection connection) { //회원가입용 동작 메서드
		System.out.println("회원가입 메서드로 진입");
		 System.out.print("아이디를 입력하세요: ");
		    String mid = scanner.next();
		    
		    System.out.print("비밀번호를 입력하세요: ");
		    String mpw = scanner.next();
		    
		    MemberDTO newMember = new MemberDTO(mid, mpw); //입력받은 아이디와 비밀번호로 새 MemberDTO 객체를 생성
		    
		   // MemberDAO를 통해 데이터베이스에 새 회원 추가
		   MemberDAO memberDAO = new MemberDAO();
		   memberDAO.register(connection, newMember);
		        
		 
	} // join method close
	
	public MemberDTO login(Scanner scanner, MemberDTO loginMember, Connection connection) { //로그인용 메서드
		System.out.println("로그인 메서드로 진입");
		System.out.print("id : ");
		String loginId = scanner.next();
		System.out.print("pw : ");
		String loginPw = scanner.next();
		MemberDTO loginMemberDTO = new MemberDTO(loginId, loginPw);
		//키보드로 입력받은 값을 객체로 생성
		MemberDAO memberDAO = new MemberDAO(connection);
		return memberDAO.login(connection, loginMemberDTO);
		//db에서 넘어온 객체를 리턴
	} // login method close
	
	public void modifyPassword(Scanner scanner) {
        System.out.println("회원정보 수정 메서드로 진입");
        System.out.println("바꾸시려는 계정의 id를 입력해주세요. : ");
        String modifyId = scanner.next();
        
            if (memberDAO.checkIdExists(modifyId)) {
                System.out.println("새로운 비밀번호를 입력해주세요.");
                String newPassword = scanner.next();
                
                
	
	public void delete() {
		System.out.println("회원탈퇴 메서드로 진입");
	} // delete method close
	
}
