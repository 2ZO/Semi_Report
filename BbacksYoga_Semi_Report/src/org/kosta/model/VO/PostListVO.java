package org.kosta.model.VO;

import java.util.ArrayList;

import org.kosta.model.etc.PagingBean;

public class PostListVO {
	private ArrayList<PostVO> list;
	private PagingBean pagingBean;
	public PostListVO() {
		super();
	}
	public PostListVO(ArrayList<PostVO> list, PagingBean pagingBean) {
		super();
		this.list = list;
		this.pagingBean = pagingBean;
	}
	public ArrayList<PostVO> getList() {
		return list;
	}
	public void setList(ArrayList<PostVO> list) {
		this.list = list;
	}
	public PagingBean getPagingBean() {
		return pagingBean;
	}
	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}
	@Override
	public String toString() {
		return "PostListVO [list=" + list + ", pagingBean=" + pagingBean + "]";
	}
}
