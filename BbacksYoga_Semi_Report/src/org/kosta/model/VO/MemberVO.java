package org.kosta.model.VO;

public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String phone_number;
	private String address;
	private String email;
	private String password_question;
	private String password_answer;
	private String regDate;
	private String member_status;
	private String class_package;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword_question() {
		return password_question;
	}

	public void setPassword_question(String password_question) {
		this.password_question = password_question;
	}

	public String getPassword_answer() {
		return password_answer;
	}

	public void setPassword_answer(String password_answer) {
		this.password_answer = password_answer;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getMember_status() {
		return member_status;
	}

	public void setMember_status(String member_status) {
		this.member_status = member_status;
	}

	public String getClass_package() {
		return class_package;
	}

	public void setClass_package(String class_package) {
		this.class_package = class_package;
	}

	/*로그인 시 전부다 받으면 정보가 너무 많아서 id와 이름을 넣기위해 만듬*/
		public MemberVO(String id,String name) {
			super();
			this.id=id;
			this.name= name;
		}
	public MemberVO(String id, String password, String name, String phone_number, String address, String email,
			String password_question, String password_answer, String regDate, String member_status,
			String class_package) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone_number = phone_number;
		this.address = address;
		this.email = email;
		this.password_question = password_question;
		this.password_answer = password_answer;
		this.regDate = regDate;
		this.member_status = member_status;
		this.class_package = class_package;
	}

	public MemberVO() {
		super();
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", phone_number=" + phone_number
				+ ", address=" + address + ", email=" + email + ", password_question=" + password_question
				+ ", password_answer=" + password_answer + ", regDate=" + regDate + ", member_status=" + member_status
				+ ", class_package=" + class_package + "]";
	}

}
