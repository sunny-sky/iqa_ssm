package com.xjtu.iqa.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.iqa.mapper.CommunityQuestionMapper;
import com.xjtu.iqa.mapper.EquipmentsMapper;
import com.xjtu.iqa.mapper.FaqClassifyMapper;
import com.xjtu.iqa.mapper.FaqQuestionMapper;
import com.xjtu.iqa.mapper.UserMapper;
import com.xjtu.iqa.mapper.UserQuestionMapper;
import com.xjtu.iqa.po.CommunityQuestion;
import com.xjtu.iqa.po.Equipments;
import com.xjtu.iqa.po.FaqClassify;
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
	@Autowired
	EquipmentsMapper equipmentsMapper;
	@Autowired
	FaqClassifyMapper faqClassifyMapper;

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

	// 获取地区名及各地区设备数量
	@Override
	public List<HomePageView> regionCount() {
		// TODO Auto-generated method stub
		List<HomePageView> homePageViews = new ArrayList<HomePageView>();
		List<Equipments> equipments = equipmentsMapper.getRegions();

		for (Equipments eList : equipments) {
			HomePageView homePageView = new HomePageView();
			homePageView.setRegions(eList.getREGION());
			// 各地区配置数
			int equipmentCounts = equipmentsMapper.getEquipmentCountsByRegion(eList.getREGION());
			homePageView.setEquipmentCounts(equipmentCounts);
			homePageViews.add(homePageView);
		}
		return homePageViews;
	}

	// 获取待处理事件/问题数
	@Override
	public List<HomePageView> eventAndProblem() {
		List<HomePageView> homePageViews = new ArrayList<HomePageView>();
		Date date = new Date();

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, 1);

		for (int i = 0; i < 7; i++) {
			HomePageView homePageView = new HomePageView();
			String str = getdate(-i);
			String time = str.substring(0, 10);
			homePageView.setTime(time);
			System.out.println("时间：" + i + time);
			// 获取当日待处理事件数
			int eventCount = userQuestionMapper.eventCount(0, 0, time);
			homePageView.setEventCount(eventCount);
			// 获取当日待处理问题数
			int problemCount = communityQuestionMapper.problemCount_time(0, 0, time);
			homePageView.setProblemCount(problemCount);
			homePageViews.add(homePageView);
		}
		return homePageViews;
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

	// 获取日期
	public static String getdate(int i) { // //获取前后日期 i为正数 向后推迟i天，负数时向前提前i天
		Date dat = null;
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.DATE, i);
		dat = cd.getTime();
		SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dformat.format(dat);
		return time;
	}
	

	 //获取一级分类名及各分类数量
	public List<HomePageView> classifyCount() {
		List<HomePageView> homePageViews = new ArrayList<HomePageView>();
		List<FaqClassify> firstClassify = faqClassifyMapper.FirstClassify_robot();
		
		for(FaqClassify cList:firstClassify){
			HomePageView homePageView = new HomePageView(); 
			homePageView.setClassifyName(cList.getFAQCLASSIFYNAME());
			int secondClassifyCount = faqClassifyMapper.secondClassifyCount(cList.getFAQCLASSIFYID());
			homePageView.setClassifyCount(secondClassifyCount);
			homePageViews.add(homePageView);			
		}
		return homePageViews;
	}

}
