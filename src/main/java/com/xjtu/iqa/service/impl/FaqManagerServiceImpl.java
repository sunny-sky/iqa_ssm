package com.xjtu.iqa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.iqa.mapper.FaqClassifyMapper;
import com.xjtu.iqa.mapper.FaqQuestionMapper;
import com.xjtu.iqa.mapper.UserMapper;
import com.xjtu.iqa.mapper.FaqAnswerMapper;
import com.xjtu.iqa.po.FaqQuestion;
import com.xjtu.iqa.service.FaqManagerService;
import com.xjtu.iqa.vo.FaqView;


@Service
public class FaqManagerServiceImpl implements FaqManagerService {
	@Autowired
	FaqQuestionMapper faqQuestionMapper;
	@Autowired
	FaqClassifyMapper faqClassifyMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	FaqAnswerMapper faqAnswerMapper;
	
	/**
	 * @param FAQSTATE
	 *            = 2 通过审核；FAQSTATE = 1待审核
	 */
	@Override
	public List<FaqView> faqPendingAudits(int faqState) {
		// 待审核faq视图
		List<FaqView> faqPendingAudits = new ArrayList<FaqView>();
		// 获取所有待审核faq -- 即FAQSTATE字段为1
		List<FaqQuestion> faqLists = faqQuestionMapper.faqPendingAudits(faqState);
		for (FaqQuestion faqList : faqLists) {
			FaqView faqPendingAudit = new FaqView();

			faqPendingAudit.setFAQQUESTIONID(faqList.getFAQQUESTIONID());
			faqPendingAudit.setFAQTITLE(faqList.getFAQTITLE());
			faqPendingAudit.setFAQDESCRIPTION(faqList.getFAQDESCRIPTION());

			String classifyName = faqClassifyMapper.getClassifyNameById(faqList.getFAQCLASSIFYID());
			faqPendingAudit.setFAQCLASSIFYNAME(classifyName);
			faqPendingAudit.setFAQKEYWORDS(faqList.getFAQKEYWORDS());
			faqPendingAudit.setMODIFYTIME(faqList.getMODIFYTIME());

			String username = userMapper.selectByPrimaryKey(faqList.getUSERID()).getUSERNAME();
			faqPendingAudit.setUSERID(faqList.getUSERID());
			faqPendingAudit.setUSERNAME(username);

			String faqContent = faqAnswerMapper.getContentByQuestionId(faqList.getFAQQUESTIONID());
			faqPendingAudit.setFAQCONTENT(faqContent);

			faqPendingAudits.add(faqPendingAudit);
		}
		return faqPendingAudits;
	}
}
