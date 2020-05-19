package kosta.orm.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.orm.domain.CommentB;
import kosta.orm.domain.Reply;
import kosta.orm.domain.Users;

public class JoinDAO {

	/**
	 * 1:1인 경우 
	 * */
	public void association() {
		try(SqlSession session = Dbutil.getSession()){
			List<CommentB> list = 
			session.selectList("joinMapper.associationJoin");
			
			for(CommentB cb: list) {
				System.out.println(cb);
			}
		}
	}
	
	/**
	 * 1:다의 경우
	 * */
	public void collection() {
		try(SqlSession session = Dbutil.getSession()){
			List<CommentB> list = 
			session.selectList("joinMapper.collectionJoin");
			
			System.err.println("개수: " + list.size()); // 2개
		
			for(CommentB cb: list) {
				System.out.print(cb.getCommentNo() + " | ");
				System.out.print(cb.getUserId() + " | ");
				System.out.print(cb.getCommentContent() + "\n");
				
				for(Reply re : cb.getReplyList()) {
					System.out.println(re);					
				}
				System.out.println("-----------------");
			}
		}
	}
	
	/**
	 * User를 기준으로 Comment 정보 가져오기 (1:다)
	 * */
	/**
	 * 1:다 의 경우
	 * */
	public void userCollection() {
		try(SqlSession session = Dbutil.getSession()){
			List<Users> list = 
					session.selectList("joinMapper.userCollection");
			
			System.err.println("개수: " + list.size()); // 2명
			for(Users user : list) {
				System.out.print(user.getUserId() + " | " + user.getUserName() + "의 작성글 \n");
				
				for(CommentB comment : user.getCommentBList()) {
					System.out.println(comment);
				}
				System.out.println("----------------------------");
			}
			
		}
	}
}
