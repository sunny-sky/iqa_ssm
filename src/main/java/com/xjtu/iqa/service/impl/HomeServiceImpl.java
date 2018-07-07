package com.xjtu.iqa.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.iqa.mapper.CommunityQuestionMapper;
import com.xjtu.iqa.mapper.FaqQuestionMapper;
import com.xjtu.iqa.mapper.UserMapper;
import com.xjtu.iqa.mapper.UserQuestionMapper;
import com.xjtu.iqa.po.CommunityQuestion;
import com.xjtu.iqa.po.FaqQuestion;
import com.xjtu.iqa.po.User;
import com.xjtu.iqa.po.UserQuestion;
import com.xjtu.iqa.service.HomeService;
import com.xjtu.iqa.vo.HomePageView;

@Service
public class HomeServiceImpl implements HomeService {
	@Autowired
	UserQuestionMapper userQuestionMapper;
	@Autowired
	CommunityQuestionMapper communityQuestionMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	FaqQuestionMapper faqQuestionMapper;

	/**
	 * 任务列表
	 */
	@Override
	public List<HomePageView> todoList() {
		List<HomePageView> homePageViews = new ArrayList<HomePageView>();

		// 查看待处理事件
		List<UserQuestion> UserQuestions = userQuestionMapper.resolvedEvent_limit(0, 0, 20);
		for (UserQuestion UserQuestion : UserQuestions) {
			HomePageView homePageView = new HomePageView();
			homePageView.setUserQuestionId(UserQuestion.getUSERQUESTIONID());
			homePageView.setHow("待处理事件");
			homePageView.setTime(UserQuestion.getQUESTIONTIME());
			homePageViews.add(homePageView);
		}

		// 查看待处理问题
		List<CommunityQuestion> problemUnresolvedLists = communityQuestionMapper.problemInfo_limit(0, 0, 20);

		for (CommunityQuestion problemUnresolvedList : problemUnresolvedLists) {
			HomePageView homePageView = new HomePageView();
			homePageView.setCommunityQuestionId(problemUnresolvedList.getCOMMUNITYQUESTIONID());
			homePageView.setHow("待处理问题");
			homePageView.setTime(problemUnresolvedList.getTIME());

			homePageViews.add(homePageView);
		}

		// 待审核用户
		List<User> userLists = userMapper.getAllUsers_limit(1, 20);

		for (User userList : userLists) {
			HomePageView homePageView = new HomePageView();
			homePageView.setUserId(userList.getUSERID());
			homePageView.setHow("待审核用户");
			homePageView.setTime(userList.getCREATETIME());

			homePageViews.add(homePageView);
		}

		// 待审核FAQ
		List<FaqQuestion> faqLists = faqQuestionMapper.faqPendingAudits(1);
		for (FaqQuestion faqList : faqLists) {
			HomePageView homePageView = new HomePageView();
			homePageView.setFaqId(faqList.getFAQQUESTIONID());
			homePageView.setHow("待审核FAQ");
			homePageView.setTime(faqList.getMODIFYTIME());

			homePageViews.add(homePageView);

		}

		List<HomePageView> list = ListSort(homePageViews);
		return list;
	}

	// 对list里面的元素进行time的排序
	private static List<HomePageView> ListSort(List<HomePageView> list) {
		Collections.sort(list, new Comparator<HomePageView>() {
			@Override
			public int compare(HomePageView o1, HomePageView o2) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date dt1 = format.parse(o1.getTime());
					Date dt2 = format.parse(o2.getTime());
					if (dt1.getTime() < dt2.getTime()) {
						return 1;
					} else if (dt1.getTime() > dt2.getTime()) {
						return -1;
					} else {
						return 0;
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 0;
			}
		});
		return list;
	}
}
