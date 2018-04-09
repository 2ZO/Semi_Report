package org.kosta.model.VO;

public class ClassVO {
	// ����+���α׷�
	private TeacherVO teacher;
	private ProgramVO program;
	private String classTime;
	private String classDay;

	public TeacherVO getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherVO teacher) {
		this.teacher = teacher;
	}

	public ProgramVO getProgram() {
		return program;
	}

	public void setProgram(ProgramVO program) {
		this.program = program;
	}

	public String getClassTime() {
		return classTime;
	}

	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}

	public String getClassDay() {
		return classDay;
	}

	public void setClassDay(String classDay) {
		this.classDay = classDay;
	}

	@Override
	public String toString() {
		return "ClassVO [teacher=" + teacher + ", program=" + program + ", classTime=" + classTime + ", classDay="
				+ classDay + "]";
	}

	public ClassVO(TeacherVO teacher, ProgramVO program, String classTime, String classDay) {
		super();
		this.teacher = teacher;
		this.program = program;
		this.classTime = classTime;
		this.classDay = classDay;
	}

	public ClassVO() {
		super();
	}

}
