package org.kosta.model.VO;

public class PostVO {
	private String postNo;
	private String title;
	private String content;
	private String id;
	private String regDate;

	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public PostVO(String postNo, String title, String content, String id, String regDate) {
		super();
		this.postNo = postNo;
		this.title = title;
		this.content = content;
		this.id = id;
		this.regDate = regDate;
	}

	public PostVO() {
		super();
	}

	@Override
	public String toString() {
		return "PostVO [postNo=" + postNo + ", title=" + title + ", content=" + content + ", id=" + id + ", regDate="
				+ regDate + "]";
	}

}
