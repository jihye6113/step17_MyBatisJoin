package kosta.orm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Reply {

	private int replyNo;
	private int commentNo;
	private String userId;
	private String replyContent;
	private String regDate;
}
