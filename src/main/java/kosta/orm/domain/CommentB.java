package kosta.orm.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CommentB {

	private int commentNo;
	private String userId;
	private String commentContent;
	private String regDate;
	
	//  1:1의 관계
	private Users user;
	
	// 1:다의 관계
	private List<Reply> replyList;
}
