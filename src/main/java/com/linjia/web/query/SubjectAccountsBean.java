package com.linjia.web.query;

/** 
 * 操作请求CRM积分时专用Bean
 * @author  lixinling: 
 * @date 2016年8月4日 下午5:12:38 
 * @version 1.0 
*/
public class SubjectAccountsBean {
	private String remark;
	private int score;
	private ScoreTypeBean scoreType;
	private ScoreSubjectBean scoreSubject;
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public ScoreTypeBean getScoreType() {
		return scoreType;
	}
	public void setScoreType(ScoreTypeBean scoreType) {
		this.scoreType = scoreType;
	}
	public ScoreSubjectBean getScoreSubject() {
		return scoreSubject;
	}
	public void setScoreSubject(ScoreSubjectBean scoreSubject) {
		this.scoreSubject = scoreSubject;
	}
	
	
}
