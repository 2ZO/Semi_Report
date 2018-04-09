package org.kosta.model.VO;

import org.kosta.model.etc.classDay;

public class RSVO {
	private String programName;
	private String teacherNick;
	private int classNo;
	private int classTime;
	private int classDay;
	private int capacity;
	private int count_reg;
	private String regDate;
	private classDay classDay_enum;
	
	public RSVO() {
		super();
	}
	
	public RSVO(String programName, String teacherNick, int classTime, String classDay, String regDate, int classNo) {
		super();
		this.programName = programName;
		this.teacherNick = teacherNick;
		this.classTime = classTime;
		 //enum class인 classDay에서 매개변수 classDay와 일치하는 데이터(ex_"mon")의 숫자형 데이터("0")를 int형으로 형변화한다.
		this.classDay = Integer.parseInt(classDay_enum.valueOf(classDay).getName());
		this.regDate = regDate;
		this.classNo = classNo;
	}

	public RSVO(String programName, String teacherNick, int classNo, int classTime, String classDay, int capacity,
			int count_reg) {
		super();
		this.programName = programName;
		this.teacherNick = teacherNick;
		this.classNo = classNo;
		this.classTime = classTime;
		this.classDay = Integer.parseInt(classDay_enum.valueOf(classDay).getName());
		this.capacity = capacity;
		this.count_reg = count_reg;
		this.regDate = null;
	}
	public RSVO(String programName, String teacherNick, int classNo, int classTime, String classDay, int capacity) {
		super();
		this.programName = programName;
		this.teacherNick = teacherNick;
		this.classNo = classNo;
		this.classTime = classTime;
		this.classDay = Integer.parseInt(classDay_enum.valueOf(classDay).getName());
		this.capacity = capacity;
		this.count_reg = 0;
		this.regDate = null;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getTeacherNick() {
		return teacherNick;
	}
	public void setTeacherNick(String teacherNick) {
		this.teacherNick = teacherNick;
	}
	public int getClassNo() {
		return classNo;
	}
	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}
	public int getClassTime() {
		return classTime;
	}
	public void setClassTime(int classTime) {
		this.classTime = classTime;
	}
	public int getClassDay() {
		return classDay;
	}

	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getCount_reg() {
		return count_reg;
	}
	public void setCount_reg(int count_reg) {
		this.count_reg = count_reg;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "RSVO [programName=" + programName + ", teacherNick=" + teacherNick + ", classNo=" + classNo
				+ ", classTime=" + classTime + ", classDay=" + classDay + ", capacity=" + capacity + ", count_reg="
				+ count_reg + ", regDate=" + regDate + "]";
	}
}
