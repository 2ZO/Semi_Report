package org.kosta.model.VO;

public class TeacherVO {
	private String teacherId;
	private String teacherName;
	private String teacherNick;
	private String teacherProfile;
	private String img_url;

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherNick() {
		return teacherNick;
	}

	public void setTeacherNick(String teacherNick) {
		this.teacherNick = teacherNick;
	}

	public String getTeacherProfile() {
		return teacherProfile;
	}

	public void setTeacherProfile(String teacherProfile) {
		this.teacherProfile = teacherProfile;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public TeacherVO(String teacherId, String teacherName, String teacherNick, String teacherProfile, String img_url) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherNick = teacherNick;
		this.teacherProfile = teacherProfile;
		this.img_url = img_url;
	}

	@Override
	public String toString() {
		return "TeacherVO [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherNick=" + teacherNick
				+ ", teacherProfile=" + teacherProfile + ", img_url=" + img_url + "]";
	}

	public TeacherVO() {
		super();
	}

	public TeacherVO(String teacherId, String teacherName, String teacherNick) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherNick = teacherNick;
	}

}
