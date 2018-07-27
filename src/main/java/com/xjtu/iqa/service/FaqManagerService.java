package com.xjtu.iqa.service;

import java.util.List;

import com.xjtu.iqa.po.FaqPicture;
import com.xjtu.iqa.po.FaqQuestion;
import com.xjtu.iqa.vo.FaqView;
import com.xjtu.iqa.vo.PageBean;

/**
 * 
 * @abstract faq管理_faqPage
 *
 */
public interface FaqManagerService {
	/**
	 * @param FAQSTATE = 2 通过审核；FAQSTATE = 1待审核
	 */
	List<FaqView> faqPendingAudits(int faqState);
	
	//获取已审核FAQ
	PageBean<FaqView> faqAudited(String classifyId, int faqState,int CurPageIndex, int PageEntryCount);
	
	/**
	 * faq首页面推荐栏信息
	 */
	List<FaqPicture> faqPicList(int state, int num);
	
	/**
	 * 获取faq问题及答案信息
	 * @param faqQuestionId
	 * @return
	 */
	FaqView getAllFaqInfo(String faqQuestionId);
	
	/**
	 * 查看username发表的title faq的信息
	 */
	List<FaqQuestion> faqAdd(String title, String username);
	
	/**
	 * faq首页面推荐栏图片更新
	 */
	void addFaqPic(String username, String imgPath);
	

}
