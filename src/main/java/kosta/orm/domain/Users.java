package kosta.orm.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Users {

	private String userId;
	private String userName;
	
	private List<CommentB> commentBList;
}
