package org.kosta.model.VO;

import java.util.ArrayList;

import org.kosta.model.etc.PagingBean;

/*	게시물 리스트 화면에 보여질 게시물 정보(회원정보포함) 와 
 *  페이지 처리 로직 정보 객체를 저장하는 클래스  
 */
public class ListVO {
	private ArrayList<ProgramVO> list; 
	private PagingBean pagingBean;
	
	public ListVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListVO(ArrayList<ProgramVO> list, PagingBean pagingBean) {
		super();
		this.list = list;
		this.pagingBean = pagingBean;
	}
	public ArrayList<ProgramVO> getList() {
		return list;
	}
	public void setList(ArrayList<ProgramVO> list) {
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
		return "ListVO [list=" + list + ", pagingBean=" + pagingBean + "]";
	}
	
}











