package org.kosta.model.VO;

public class ProgramVO {
   private String programNo;
   private String programName;
   private String programDetail;
   private ProgramImgVO programImgVO;
   public ProgramVO() {
      super();
      // TODO Auto-generated constructor stub
   }
   public ProgramVO(String programNo, String programName) {
      super();
      this.programNo = programNo;
      this.programName = programName;
   }
   public ProgramVO(String programNo, String programName, String programDetail) {
      super();
      this.programNo = programNo;
      this.programName = programName;
      this.programDetail = programDetail;
   }
   
   public ProgramVO(String programNo, String programName, String programDetail, ProgramImgVO programImgVO) {
      super();
      this.programNo = programNo;
      this.programName = programName;
      this.programDetail = programDetail;
      this.programImgVO = programImgVO;
   }
   public String getProgramNo() {
      return programNo;
   }
   public void setProgramNo(String programNo) {
      this.programNo = programNo;
   }
   public String getProgramName() {
      return programName;
   }
   public void setProgramName(String programName) {
      this.programName = programName;
   }
   public String getProgramDetail() {
      return programDetail;
   }
   public void setProgramDetail(String programDetail) {
      this.programDetail = programDetail;
   }
   public ProgramImgVO getProgramImgVO() {
      return programImgVO;
   }
   public void setProgramImgVO(ProgramImgVO programImgVO) {
      this.programImgVO = programImgVO;
   }
   @Override
   public String toString() {
      return "ProgramVO [programNo=" + programNo + ", programName=" + programName + ", programDetail=" + programDetail
            + ", programImgVO=" + programImgVO + "]";
   }
}