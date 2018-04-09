package org.kosta.model.VO;

import org.kosta.model.etc.PagingBean;

public class PostSearchVO extends PagingBean{
	 private String searchType;
	 private String keyword;
	 
	public PostSearchVO() {
		super();
	}

	public PostSearchVO(String searchType, String keyword) {
		super();
		this.searchType = searchType;
		this.keyword = keyword;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "PostSearchVO [searchType=" + searchType + ", keyword=" + keyword + "]";
	}
	 
}
