package com.xjtu.iqa.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.iqa.mapper.FaqAnswerMapper;
import com.xjtu.iqa.mapper.FaqClassifyMapper;
import com.xjtu.iqa.mapper.FaqPictureMapper;
import com.xjtu.iqa.mapper.FaqQuestionMapper;
import com.xjtu.iqa.mapper.UserMapper;
import com.xjtu.iqa.po.FaqAnswer;
import com.xjtu.iqa.po.FaqPicture;
import com.xjtu.iqa.po.FaqQuestion;
import com.xjtu.iqa.service.FaqManagerService;
import com.xjtu.iqa.vo.FaqView;
import com.xjtu.iqa.vo.PageBean;

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
	@Autowired
	FaqPictureMapper faqPictureMapper;
	

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

	// 获取已审核FAQ
	@Override
	public PageBean<FaqView> faqAudited(String classifyId, int faqState, int CurPageIndex, int PageEntryCount) {
		// 目的：就是想办法封装一个PageBean 并返回
		System.out.println("fenleihai :" + classifyId);
		PageBean<FaqView> pageBean = new PageBean<FaqView>();
		pageBean.setCurPageIndex(CurPageIndex); // 当前页
		pageBean.setPageEntryCount(PageEntryCount); // 每页显示的条数
		int totalCount = faqQuestionMapper.faqAuditedCount(classifyId, faqState); // 获取该分类下且faqState=2的总条数
		pageBean.setTotalEntryCount(totalCount); // 总条数
		int totalPage = (int) Math.ceil(1.0 * totalCount / PageEntryCount);
		pageBean.setTotalPage(totalPage); // 总页数

		System.out.println("当前页CurPageIndex：" + CurPageIndex + ";每页显示的条数PageEntryCount：" + PageEntryCount
				+ ";总条数totalCount:" + totalCount + ";总页数 totalPage" + totalPage);

		// 计算beginPageIndex 和 endPageIndex
		// >> 总页数不多于10页，则全部显示
		if (totalPage <= 10) {
			int beginPageIndex = totalPage;
			int endPageIndex = 1;
			pageBean.setBeginPageIndex(beginPageIndex);
			pageBean.setEndPageIndex(endPageIndex);
		}
		// >> 总页数多于10页，则显示当前页附近的10个页码
		else {
			// 当前页附近的10个页码(前4个 + 当前页 + 后5个)
			int beginPageIndex = CurPageIndex - 4;
			int endPageIndex = CurPageIndex + 5;
			// 当前面的页码不足4个时，则显示前10个页码
			if (beginPageIndex < 1) {
				beginPageIndex = 1;
				endPageIndex = 10;
			}
			// 当后面的页码不足5个时，则显示后10个页码
			if (endPageIndex > totalPage) {
				endPageIndex = totalPage;
				beginPageIndex = totalPage - 10 + 1;
			}
			pageBean.setBeginPageIndex(endPageIndex);
			pageBean.setEndPageIndex(beginPageIndex);

		}

		int index = (CurPageIndex - 1) * PageEntryCount;

		// 待审核faq视图
		List<FaqView> faqAudited = new ArrayList<FaqView>();

		// 获取所有已审核faq -- 即FAQSTATE字段为2
		List<FaqQuestion> faqLists = faqQuestionMapper.faqAudited(classifyId, faqState, index, PageEntryCount);

		for (FaqQuestion faqList : faqLists) {
			FaqView faqPendingAudit = new FaqView();

			faqPendingAudit.setFAQQUESTIONID(faqList.getFAQQUESTIONID());
			faqPendingAudit.setFAQTITLE(faqList.getFAQTITLE());
			faqPendingAudit.setFAQDESCRIPTION(faqList.getFAQDESCRIPTION());

			String classifyName = faqClassifyMapper.getClassifyNameById(faqList.getFAQCLASSIFYID());
			faqPendingAudit.setFAQCLASSIFYNAME(classifyName);
			faqPendingAudit.setFAQKEYWORDS(faqList.getFAQKEYWORDS());
			faqPendingAudit.setMODIFYTIME(faqList.getMODIFYTIME());

			String username = userMapper.getUserNameById(faqList.getUSERID());
			faqPendingAudit.setUSERID(faqList.getUSERID());
			faqPendingAudit.setUSERNAME(username);

			String content = faqAnswerMapper.getContentByQuestionId(faqList.getFAQQUESTIONID());
			faqPendingAudit.setFAQCONTENT(content);

			faqAudited.add(faqPendingAudit);
		}
		pageBean.setEntryList(faqAudited);
		return pageBean;
	}
	
	/**
	 * faq首页面推荐栏信息
	 */
	@Override
	public List<FaqPicture> faqPicList(int state, int num) {
		List<FaqPicture> faqPicList = faqPictureMapper.faqPicture(state, num);
		return faqPicList;
	}
	
	/**
	 * 获取faq问题及答案信息
	 * @param q
	 * @return
	 */
	public FaqView getAllFaqInfo(String faqQuestionId) {
		//待编辑faq视图
		FaqView faqEdit = new FaqView();		
		if (faqQuestionId!=null) {
			//获取faqQuestionId对应的问题列表
			List<FaqQuestion> faqQuserionList = faqQuestionMapper.getFaqQuestionInfo(faqQuestionId);
			
			//获取faqQuestionId对应的答案列表
			List<FaqAnswer> faqAnswerList = faqAnswerMapper.getAnswerByQuestionId(faqQuestionId);
			
			faqEdit.setFAQQUESTIONID(faqQuestionId);
			faqEdit.setFAQTITLE(faqQuserionList.get(0).getFAQTITLE());
			
			String classifyName = faqClassifyMapper.getClassifyNameById(faqQuserionList.get(0).getFAQCLASSIFYID());
			faqEdit.setFAQCLASSIFYID(faqQuserionList.get(0).getFAQCLASSIFYID());
			faqEdit.setFAQCLASSIFYNAME(classifyName);
		
			faqEdit.setFAQKEYWORDS(faqQuserionList.get(0).getFAQKEYWORDS());
			faqEdit.setFAQDESCRIPTION(faqQuserionList.get(0).getFAQDESCRIPTION());
			faqEdit.setFAQCONTENT(faqAnswerList.get(0).getFAQCONTENT());
			
			String username = userMapper.getUserNameById(faqQuserionList.get(0).getUSERID());
			faqEdit.setUSERNAME(username);
		}
		return faqEdit;
	}
	
	/**
	 * 查看username发表的title faq的信息
	 */
	public List<FaqQuestion> faqAdd(String title, String username) {
		//获取用户ID
		String userId = userMapper.getUserIdByName(username);
		
		//判断是否重复添加
		List<FaqQuestion> isExist = faqQuestionMapper.titleIsExist(title,userId);
		
		return isExist;
	}
	
	/**
	 * faq首页面推荐栏图片更新
	 */
	public void addFaqPic(String username, String imgPath) {
		FaqPicture faqPicturePersistence = new FaqPicture();
		faqPicturePersistence.setFAQPICTUREID(UUID.randomUUID().toString());
		faqPicturePersistence.setIMGPATH(imgPath);
		String UserId = userMapper.getUserIdByName(username);
		faqPicturePersistence.setUSERID(UserId);
		Date date=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = format.format(date);
		faqPicturePersistence.setTIME(createTime);
		faqPicturePersistence.setSTATE(1);
		faqPictureMapper.insert(faqPicturePersistence);		
	}
}
