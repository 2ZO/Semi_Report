package org.kosta.model.VO;

public class ProgramImgVO {
	private String programImg;
	private String hitCount;
	private String imgUrl1;
	private String imgUrl2;
	private String imgUrl3;
	private String imgUrl4;
	
	public ProgramImgVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProgramImgVO(String hitCount, String imgUrl1, String imgUrl2, String imgUrl3, String imgUrl4) {
		super();
		this.hitCount = hitCount;
		this.imgUrl1 = imgUrl1;
		this.imgUrl2 = imgUrl2;
		this.imgUrl3 = imgUrl3;
		this.imgUrl4 = imgUrl4;
	}

	public ProgramImgVO(String programImg, String hitCount, String imgUrl1, String imgUrl2, String imgUrl3,
			String imgUrl4) {
		super();
		this.programImg = programImg;
		this.hitCount = hitCount;
		this.imgUrl1 = imgUrl1;
		this.imgUrl2 = imgUrl2;
		this.imgUrl3 = imgUrl3;
		this.imgUrl4 = imgUrl4;
	}

	public String getProgramImg() {
		return programImg;
	}

	public void setProgramImg(String programImg) {
		this.programImg = programImg;
	}

	public String getHitCount() {
		return hitCount;
	}

	public void setHitCount(String hitCount) {
		this.hitCount = hitCount;
	}

	public String getImgUrl1() {
		return imgUrl1;
	}

	public void setImgUrl1(String imgUrl1) {
		this.imgUrl1 = imgUrl1;
	}

	public String getImgUrl2() {
		return imgUrl2;
	}

	public void setImgUrl2(String imgUrl2) {
		this.imgUrl2 = imgUrl2;
	}

	public String getImgUrl3() {
		return imgUrl3;
	}

	public void setImgUrl3(String imgUrl3) {
		this.imgUrl3 = imgUrl3;
	}

	public String getImgUrl4() {
		return imgUrl4;
	}

	public void setImgUrl4(String imgUrl4) {
		this.imgUrl4 = imgUrl4;
	}

	@Override
	public String toString() {
		return "ProgramImgVO [programImg=" + programImg + ", hitCount=" + hitCount + ", imgUrl1=" + imgUrl1
				+ ", imgUrl2=" + imgUrl2 + ", imgUrl3=" + imgUrl3 + ", imgUrl4=" + imgUrl4 + "]";
	}
}
