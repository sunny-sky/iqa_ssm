package com.xjtu.iqa.service;

import java.util.List;

import com.xjtu.iqa.vo.FaqView;

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
}
