package org.kosta.model.etc;

/**
 * ?��?���? 처리�? ?��?�� 비즈?��?�� 계층?�� ?��?��?�� PagingBean method 구현?��?��
 * getStartRowNumber() getEndRowNumber()<br>
 * getTotalPage()<br>
 * getTotalPageGroup()<br>
 * getNowPageGroup()<br>
 * getStartPageOfPageGroup()<br>
 * getEndPageOfPageGroup()<br>
 * isPreviousPageGroup()<br>
 * isNextPageGroup()
 * 
 * @author kosta
 *
 */
public class PagingBean {
	/**
	 * ?��?�� ?��?���?
	 */
	private int nowPage = 1;
	/**
	 * ?��?���??�� 게시물수
	 */
	private int postCountPerPage = 5;
	/**
	 * ?��?���? 그룹?�� ?��?���??��
	 */
	private int pageCountPerPageGroup = 4;
	/**
	 * database?�� ???��?�� 총게?��물수
	 */
	private int totalPostCount;

	public PagingBean() {
	}

	public PagingBean(int totalPostCount) {
		this.totalPostCount = totalPostCount;
	}

	public PagingBean(int totalPostCount, int nowPage) {
		this.totalPostCount = totalPostCount;
		this.nowPage = nowPage;
	}

	public int getNowPage() {
		return nowPage;
	}

	/**
	 * ?��?�� ?��?���?번호?�� ?��?��?��?�� ?��?�� 게시물의 row number�? 반환 hint :
	 * ?��?��?��?���??�� 마�?�? 번호 + 1 ((?��?��?��?���?-1) * ?��?���??�� 게시물수) +1
	 * 
	 * @return
	 */
	public int getStartRowNumber() {
		return ((nowPage - 1) * postCountPerPage) + 1;
	}

	/**
	 * ?��?�� ?��?���??��?�� 보여�? 게시�? ?��(row)?�� 마�?�? 번호
	 * ?��?��?��?���?*contentNumberPerPage 만약 총게?��물수보다<br>
	 * ?��?��결과?�� 번호�? ?�� 경우 총게?��물수�? 마�?�? 번호�? ?��?��?�� ?��?�� ex) 총게?��물수 7
	 * �? 총페?���??�� 2?��?���? : 1 2 3 4 5<br>
	 * | 6 7 | 1page 2page ?��?��?��?���??�� 2?��?���??���? 2*5(?��?���??�� 게시물수)
	 * ?�� 10 ?���? ?��?�� 마�?�? 번호 7?��?�� -><br>
	 * ?��?��결과�? 총게?��물수보다 ?�� 경우 총게?��물수�? 마�?막번?���? ?��?��?�� ?��
	 * 
	 * @return
	 */
	public int getEndRowNumber() {
		int endRowNumber = nowPage * postCountPerPage;
		if (totalPostCount < endRowNumber)
			endRowNumber = totalPostCount;
		return endRowNumber;
	}

	/**
	 * �? ?��?���? ?���? return?��?��.<br>
	 * 1. ?���? ?��?��?��(게시�?) % ?�� ?��?���??�� 보여�? ?��?��?�� 개수 <br>
	 * => 0 ?���? ?��?�� / 값이 �? ?��?���? ?��<br>
	 * 2. ?���? ?��?��?��(게시�?) % ?�� ?��?���??�� 보여�? ?��?��?�� 개수 <br>
	 * => 0보다 ?���? ?��?�� / 값에 +1?�� ?�� 값이 �? ?��?���? ?��<br>
	 * 게시물수 1 2 3 4 5 6 7 8 9 10 11 12<br>
	 * 1?��?���? 1~5<br>
	 * 2?��?���? 6~10<br>
	 * 3?��?���? 11,12 <br>
	 * ex) 게시�? 32 �? , ?��?���??�� 게시물수 5�?-> 7 ?��?���?
	 * 
	 * @return
	 */
	private int getTotalPage() {
		int num = this.totalPostCount % this.postCountPerPage;
		int totalPage = 0;
		if (num == 0) {
			totalPage = this.totalPostCount / this.postCountPerPage;
		} else {
			totalPage = this.totalPostCount / this.postCountPerPage + 1;
		}
		return totalPage;
	}

	/**
	 * �? ?��?���? 그룹?�� ?���? return?��?��.<br>
	 * 1. �? ?��?���??�� % Page Group ?�� Page ?��. <br>
	 * => 0 ?���? ?��?�� / 값이 �? ?��?���? ?��<br>
	 * 2. �? ?��?���??�� % Page Group ?�� Page ?��. <br>
	 * => 0보다 ?���? ?��?�� / 값에 +1?�� ?�� 값이 �? ?��?���? ?��<br>
	 * ex) �? 게시�? ?�� 23 �? <br>
	 * �? ?��?���? ? �? ?��?���? 그룹?�� ? <br>
	 * ?��?���? 1 2 3 4 5<br>
	 * ?��?���?그룹 1234(1그룹) 5(2그룹)<br>
	 * 
	 */
	private int getTotalPageGroup() {
		int num = this.getTotalPage() % this.pageCountPerPageGroup;
		int totalPageGroup = 0;
		if (num == 0) {
			totalPageGroup = this.getTotalPage() / this.pageCountPerPageGroup;
		} else {
			totalPageGroup = this.getTotalPage() / this.pageCountPerPageGroup + 1;
		}
		return totalPageGroup;
	}

	/**
	 * ?��?�� ?��?���?�? ?��?�� ?��?���? 그룹 번호(�? 번째 ?��?���? 그룹?���?) ?�� return
	 * ?��?�� 메소?�� <br>
	 * 1. ?��?�� ?��?���? % Page Group ?�� Page ?�� => 0 ?���? <br>
	 * ?��?�� / 값이 ?��?�� ?��?���? 그룹. <br>
	 * 2. ?��?�� ?��?���? % Page Group ?�� Page ?�� => 0 ?���? <br>
	 * ?��?�� / 값에 +1?�� ?�� 값이 ?��?�� ?��?���? 그룹<br>
	 * ?��?���? 1 2 3 4 /5 6 7 8/ 9 10 1그룹 2그룹 3그룹
	 * 
	 * @return
	 */
	private int getNowPageGroup() {
		int num = this.nowPage % this.pageCountPerPageGroup;
		int nowPageGroup = 0;
		if (num == 0) {
			nowPageGroup = this.nowPage / this.pageCountPerPageGroup;
		} else {
			nowPageGroup = this.nowPage / this.pageCountPerPageGroup + 1;
		}
		return nowPageGroup;
	}

	/**
	 * ?��?�� ?��?���?�? ?��?�� ?��?���? 그룹?�� ?��?�� ?��?���? 번호�? return
	 * ?��?��.<br>
	 * Page Group ?�� Page ?��*(?��?�� ?��?���? 그룹 -1) + 1?�� ?�� 값이 �?
	 * ?��?���??��?��.<br>
	 * (?��?���? 그룹*?��?���? 그룹 개수, 그룹?�� 마�?�? 번호?���?�?) <br>
	 * ?��?���? 그룹 <br>
	 * 1 2 3 4 -> 5 6 7 8 -> 9 10 <br>
	 * 
	 * @return
	 */
	public int getStartPageOfPageGroup() {
		int num = this.pageCountPerPageGroup * (this.getNowPageGroup() - 1) + 1;
		return num;
	}

	/**
	 * ?��?�� ?��?���?�? ?��?�� ?��?���? 그룹?�� 마�?�? ?��?���? 번호�? return
	 * ?��?��.<br>
	 * 1. ?��?�� ?��?���? 그룹 * ?��?���? 그룹 개수 �? 마�?�? 번호?��?��. <br>
	 * 2. �? 그룹?�� 마�?�? ?��?���? 번호�? ?���? ?��?���??�� 마�?�? ?��?���? 번호보다 <br>
	 * ?�� 경우?�� ?���? ?��?���??�� 마�?�? 번호�? return ?��?��.<br>
	 * 1 2 3 4 -> 5 6 7 8 -> 9 10
	 * 
	 * @return
	 */
	public int getEndPageOfPageGroup() {
		int num = this.getNowPageGroup() * this.pageCountPerPageGroup;
		if (this.getTotalPage() < num) {
			num = this.getTotalPage();
		}
		return num;
	}

	/**
	 * ?��?�� ?��?���? 그룹?�� ?��?���? 체크?��?�� 메서?�� <br>
	 * ?��?�� ?��?���?�? ?��?�� ?��?���? 그룹?�� 1보다 ?���? true<br>
	 * ex ) ?��?���? 1 2 3 4 / 5 6 7 8 / 9 10 <br>
	 * 1 2 3 group
	 * 
	 * @return
	 */
	public boolean isPreviousPageGroup() {
		boolean flag = false;
		if (this.getNowPageGroup() > 1) {
			flag = true;
		}
		return flag;
	}

	/**
	 * ?��?�� ?��?���? 그룹?�� ?��?���? 체크?��?�� 메서?�� <br>
	 * ?��?�� ?��?���? 그룹?�� 마�?�? ?��?���? 그룹(<br>
	 * 마�?�? ?��?���? 그룹 == �? ?��?���? 그룹 ?��) 보다 ?��?���? true<br>
	 * * ex ) ?��?���? <br>
	 * 1 2 3 4 / 5 6 7 8 / 9 10 <br>
	 * 1 2 3 group
	 * 
	 * @return
	 */
	public boolean isNextPageGroup() {
		boolean flag = false;
		if (this.getNowPageGroup() < this.getTotalPageGroup()) {
			flag = true;
		}
		return flag;
	}

	public static void main(String args[]) {
		PagingBean p = new PagingBean(47, 10);
		// ?��?��?���??�� ?��?�� row number �? 조회 46
		System.out.println("getBeginRowNumber:" + p.getStartRowNumber());
		// ?��?��?���??�� 마�?�? row number �? 조회 47
		System.out.println("getEndRowNumber:" + p.getEndRowNumber());
		// ?���? ?��?���? ?�� : 10
		System.out.println("getTotalPage:" + p.getTotalPage());
		// ?���? ?��?���? 그룹 ?�� : 3
		System.out.println("getTotalPageGroup:" + p.getTotalPageGroup());
		System.out.println("////////////////////////////");
		p = new PagingBean(31, 6);// 게시물수 31 ?��?�� ?��?���? 6
		// ?��?��?���??�� ?��?�� row number �? 조회 26
		System.out.println("getStartRowNumber:" + p.getStartRowNumber());
		// ?��?��?���??�� 마�?�? row number �? 조회 30
		System.out.println("getEndRowNumber:" + p.getEndRowNumber());
		// 게시물수 31 -> 총페?���??�� 7 -> 총페?���?그룹->2
		// ?��?�� ?��?���? 그룹 : 2
		System.out.println("getNowPageGroup:" + p.getNowPageGroup());
		// ?��?���? 그룹?�� ?��?�� ?��?���? : 5
		System.out.println("getStartPageOfPageGroup:" + p.getStartPageOfPageGroup());
		// ?��?���? 그룹?�� 마�?�? ?��?���? : 7
		System.out.println("getEndPageOfPageGroup:" + p.getEndPageOfPageGroup());
		// ?��?�� ?��?���? 그룹?�� ?��?�� �? : true
		System.out.println("isPreviousPageGroup:" + p.isPreviousPageGroup());
		// ?��?�� ?��?���? 그룹?�� ?��?�� �? : false
		System.out.println("isNextPageGroup:" + p.isNextPageGroup());

	}

}
