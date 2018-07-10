package com.xjtu.iqa.service;

import java.util.List;

import com.xjtu.iqa.po.FaqPicture;
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
}
