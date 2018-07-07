package com.xjtu.iqa.vo;

public class HomePageView {
	private String time;
	private String how;
	
	//待处理事件
	private String userQuestionId;
	private int eventCount;
	
	//待处理问题
	private String communityQuestionId;
	private int ProblemCount;
	
	//FAQ分类信息
	private String classifyName;
	private int classifyCount;
	
	//设备分配地区及数量
	private String regions;
	private int equipmentCounts;
	
	//待审核FAQ
	private String faqId;
	
	//待审核用户
	private String userId;
	
	
	
	public String getRegions() {
		return regions;
	}
	public void setRegions(String regions) {
		this.regions = regions;
	}
	public int getEquipmentCounts() {
		return equipmentCounts;
	}
	public void setEquipmentCounts(int equipmentCounts) {
		this.equipmentCounts = equipmentCounts;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getEventCount() {
		return eventCount;
	}
	public void setEventCount(int eventCount) {
		this.eventCount = eventCount;
	}
	public int getProblemCount() {
		return ProblemCount;
	}
	public void setProblemCount(int problemCount) {
		ProblemCount = problemCount;
	}
	public String getClassifyName() {
		return classifyName;
	}
	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}
	public int getClassifyCount() {
		return classifyCount;
	}
	public void setClassifyCount(int classifyCount) {
		this.classifyCount = classifyCount;
	}
	public String getHow() {
		return how;
	}
	public void setHow(String how) {
		this.how = how;
	}
	public String getUserQuestionId() {
		return userQuestionId;
	}
	public void setUserQuestionId(String userQuestionId) {
		this.userQuestionId = userQuestionId;
	}
	public String getCommunityQuestionId() {
		return communityQuestionId;
	}
	public void setCommunityQuestionId(String communityQuestionId) {
		this.communityQuestionId = communityQuestionId;
	}
	public String getFaqId() {
		return faqId;
	}
	public void setFaqId(String faqId) {
		this.faqId = faqId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
