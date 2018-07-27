package com.xjtu.iqa.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.xjtu.iqa.mapper.FaqClassifyMapper;
import com.xjtu.iqa.mapper.FaqPictureMapper;
import com.xjtu.iqa.mapper.FaqQuestionMapper;
import com.xjtu.iqa.mapper.RobotAnswerMapper;
import com.xjtu.iqa.mapper.UserQuestionMapper;
import com.xjtu.iqa.po.FaqClassify;
import com.xjtu.iqa.po.FaqPicture;
import com.xjtu.iqa.po.FaqQuestion;
import com.xjtu.iqa.service.FaqManagerService;
import com.xjtu.iqa.service.FaqQuestionService;
import com.xjtu.iqa.util.CopyFile;
import com.xjtu.iqa.util.JsonUtil;
import com.xjtu.iqa.vo.FaqView;
import com.xjtu.iqa.vo.PageBean;

@Controller
public class FaqManagerController {
	@Autowired
	FaqManagerService faqManagerService;
	@Autowired
	FaqQuestionMapper faqQuestionMapper;
	@Autowired
	FaqClassifyMapper faqClassifyMapper;
	@Autowired
	FaqPictureMapper faqPictureMapper;
	@Autowired
	FaqQuestionService faqQuestionService;
	@Autowired
	UserQuestionMapper userQuestionMapper;
	@Autowired
	RobotAnswerMapper robotAnswerMapper;
	

	Logger logger = Logger.getLogger(FaqManagerController.class);

	@RequestMapping(value = "faqPage", method = RequestMethod.GET)
	public ModelAndView faqPage(HttpSession session, HttpServletRequest request, HttpServletResponse respon) {
		ModelAndView mv = new ModelAndView("admin/faqPage");

		// !!! 分页
		// FAQSTATE = 2 通过审核；FAQSTATE = 1待审核
		// 获取待审核FAQ
		List<FaqView> faqPendingAudit = faqManagerService.faqPendingAudits(1);
		// 获取待审核FAQ总数
		int pendCount = faqQuestionMapper.getCount(1);

		// 获取所有faq分类
		List<FaqClassify> classifyList = faqClassifyMapper.FirstClassify_robot();

		// 获取第一个分类已审核FAQ
		// List<FaqView> faqAudited =
		// FaqManagerService.faqAudited(classifyList.get(0).getFAQCLASSIFYID());

		String strCurPage = request.getParameter("Cur_Page");
		String classifyId = request.getParameter("classifyId");

		if (classifyId == null)
			classifyId = classifyList.get(0).getFAQCLASSIFYID();
		System.out.println("controller:" + classifyId);
		if (strCurPage == null)
			strCurPage = "1";
		int intCurPage = Integer.parseInt(strCurPage);
		// 认为每页显示12条
		int PageCount = 10;

		PageBean<FaqView> pageBean = new PageBean<FaqView>();
		// （满意度，每页显示条数）
		pageBean = faqManagerService.faqAudited(classifyId, 2, intCurPage, PageCount);

		// 把分页的列表提取出来
		List<FaqView> EntryList = pageBean.getEntryList();

		mv.addObject("faqPendingAudit", faqPendingAudit);
		mv.addObject("pageBean", pageBean);
		mv.addObject("EntryList", EntryList);
		mv.addObject("pendCount", pendCount);
		mv.addObject("faqAudited", EntryList);
		mv.addObject("classifyList", classifyList);
		mv.addObject("classifyId", classifyId);

		logger.info(pageBean);

		return mv;
	}

	// faq推荐栏
	@RequestMapping(value = "faqCommendPage", method = RequestMethod.GET)
	public ModelAndView faqCommendPage(HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("admin/faqCommendPage");

		List<FaqPicture> faqPicList = faqManagerService.faqPicList(1, 10);

		mv.addObject("faqPicList", faqPicList);

		return mv;
	}
	
	// faq删除图片
	@ResponseBody
	@RequestMapping(value={"deletePic"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="text/plain;charset=UTF-8")
	public String deletePic(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		//获取登录的管理员信息
		String username = (String) session.getAttribute("username");		
		
		if (username==null) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("value", "0");
			return JsonUtil.toJsonString(jsonObject);			
		}else {			
			String faqPicId = request.getParameter("faqPicId");
			
			faqPictureMapper.deletePic(faqPicId,0);
			
			JSONObject jsonObject = new JSONObject();

			//删除成功返回1
			jsonObject.put("value", "1");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;				

		}
	}
	
	@ResponseBody
	@RequestMapping(value={"updateTitle"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="text/plain;charset=UTF-8")
	public String updateTitle(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		//获取登录的管理员信息
		String username = (String) session.getAttribute("username");		
		
		if (username==null) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("value", "0");
			return JsonUtil.toJsonString(jsonObject);			
		}else {			
			String faqPicId = request.getParameter("faqPicId");
			String picTitle = request.getParameter("picTitle");
			
			faqPictureMapper.updateTitle(faqPicId,picTitle);
			
			JSONObject jsonObject = new JSONObject();

			//保存知识成功返回1
			jsonObject.put("value", "1");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;				

		}
	}
	
	/**
	 * 编辑待审核问题
	 */
	@RequestMapping(value="faqEdit",method=RequestMethod.GET)
    public ModelAndView  faqEdit(HttpSession session,String q){
 	   ModelAndView mv=new ModelAndView("faqEdit");
 	   String username = (String) session.getAttribute("username");
 	   if (username == null) {
 		   return new ModelAndView("login");
 	   }else {
 		   //q是传过来的faq的问题ID，获取faq问题及答案信息
 		   FaqView faqList = faqManagerService.getAllFaqInfo(q);
 		   mv.addObject("faqList", faqList);
 		  return mv;
 	   }	  
    }
	
	/**
	 * 更新信息及状态
	 */
	@ResponseBody
	@RequestMapping(value="/updateFaq",method=RequestMethod.POST)
	public String updateFaq(HttpServletRequest request,HttpSession session){
		String username = (String) session.getAttribute("username");
		JSONObject jsonObject = new JSONObject();
		if (username==null) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject); 			
			return result;
		}else{
			String questionId = request.getParameter("questionId");
			String keywords = request.getParameter("keywords");
			String description = request.getParameter("description");
			String faqcontent = request.getParameter("faqcontent");
			
			//更新faq问题表信息及状态 -- "2"为管理员审核通过状态
			faqQuestionService.updateFaqInfo(questionId,keywords,description,2,faqcontent);		
			jsonObject.put("value", "1");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;
		}
	}
	
	/**
	 * 删除待审核信息
	 */
	@ResponseBody
	@RequestMapping(value="deleteFAQ",method=RequestMethod.POST)
	public String deleteFAQ(HttpServletRequest request,HttpSession session){
		String username = (String) session.getAttribute("username");
		JSONObject jsonObject = new JSONObject();
		if (username==null) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject); 			
			return result;
		}else{
			String questionid = request.getParameter("faqQuestionId");
			String[] str = questionid.split("_");
			String questionId = str[1];		
			//删除待审核信息 -- faqstate状态为0时，表明删除
			faqQuestionMapper.deleteFAQ(questionId,0);			
			jsonObject.put("value", "1");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;
		}
	}
	
	/**
	 * @abstract:保存faq
	 */
	@ResponseBody
	@RequestMapping(value={"/saveFAQ"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="text/plain;charset=UTF-8")
	public String saveFAQ(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		//获取登录的管理员信息
		String username = (String) session.getAttribute("username");		

		JSONObject jsonObject = new JSONObject();
		if (username==null) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject); 			
			return result;
		}else{
			String questionId = request.getParameter("questionId");
			String title = request.getParameter("title");
			String keywords = request.getParameter("keywords");
			String subspecialCategoryId = request.getParameter("subspecialCategoryId");
			String description = request.getParameter("description");
			String faqcontent = request.getParameter("faqcontent");
			String from = request.getParameter("from");
			
			//zzl_faqAdd_校验知识是否重复增添
			List<FaqQuestion> isExist = faqManagerService.faqAdd(title,username);

			if (isExist.size()==0) {
				//zzl_保存知识
				faqQuestionService.saveFAQ(username,title,keywords,subspecialCategoryId,description,faqcontent,questionId);
				if (from.equals("event")) {
					
					robotAnswerMapper.updateRobotAnswerState(questionId,1);
					System.out.println("from event");
				}
				//保存知识成功返回1
				jsonObject.put("value", "1");
				String result = JsonUtil.toJsonString(jsonObject);
				return result;				
			}else {			
				//重复添加返回2
				if (from.equals("event")) {
					
					robotAnswerMapper.updateRobotAnswerState(questionId,1);
					System.out.println("from event");
				}
				jsonObject.put("value", "2");
				String result = JsonUtil.toJsonString(jsonObject);
				return result;
			}			
		}

	}
		
	//选择问题分类
	@ResponseBody
	@RequestMapping(value="selectClassify",method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="application/json;charset=UTF-8")
	public String selectClassify(HttpServletRequest request,HttpSession session){	
		//获取登录的管理员信息
		String username = (String) session.getAttribute("username");		
		JSONObject jsonObject = new JSONObject();
		if (username==null) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject); 			
			return result;
		}else{
			String classifyId = request.getParameter("classifyId");
			
			String strCurPage = request.getParameter("Cur_Page");

		 	  System.out.println("controller:"+classifyId);
		 	  if(strCurPage == null) 
					strCurPage ="1";
				int intCurPage = Integer.parseInt(strCurPage);
				//认为每页显示12条
				int PageCount = 10;
				
				PageBean<FaqView> pageBean = new PageBean<FaqView>();
				//（满意度，每页显示条数）	
				pageBean = faqManagerService.faqAudited(classifyId,2,intCurPage,PageCount);
				
				// 把分页的列表提取出来
				List<FaqView> EntryList = pageBean.getEntryList();
			

			//List<FaqView> faqAudited = FaqManagerService.faqAudited(classifyId,2,0,1);
			//jsonObject.put("faqAudited", faqAudited);
				 jsonObject.put("pageBean", pageBean);
			 	  jsonObject.put("EntryList", EntryList);
			 	  jsonObject.put("faqAudited", EntryList);	   
			jsonObject.put("value", "1");
			String result = JsonUtil.toJsonString(jsonObject); 			
			return result;
		}
	
	}
	
	//查看faq更多信息
	@ResponseBody
	@RequestMapping(value="lookMoreFaqInfo",method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="application/json;charset=UTF-8")
	public String lookMoreFaqInfo(HttpServletRequest request,HttpSession session){
		//获取ajax传来数据
		String faqQuestionId = request.getParameter("faqQuestionId"); 		
    	//获取ID对应faq信息		
		FaqView list = faqManagerService.getAllFaqInfo(faqQuestionId);		
		JSONObject jsonObject = new JSONObject();		
		jsonObject.put("moreFaqInfo", list);	
		System.out.println(list.getFAQCONTENT());
		String result = JsonUtil.toJsonString(jsonObject);		
		return result;
	}
	
	/**
	 * @abstract:将已解决问题加入faq
	 */
	@ResponseBody
	@RequestMapping(value={"/saveCommunityQuestionToFAQ"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="text/plain;charset=UTF-8")
	public String saveCommunityQuestionToFAQ(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		//获取登录的管理员信息
		String username = (String) session.getAttribute("username");		
		
		//获取路径
		String url = (String) session.getAttribute("urlPath");
		
		if (username==null) {
			return "0";
		}else {			
			String communityQuestionId = request.getParameter("communityQuestionId");
			String faqTitle = request.getParameter("title");			
			String faqDescription = request.getParameter("content");
			String keywords = request.getParameter("keywords");
			String faqclassifyId = request.getParameter("classifyId");			
			String problemUser = request.getParameter("problemUser");
			String modifyTime = request.getParameter("problemTime");			
			String userId = request.getParameter("userId");			
			String answerContent = request.getParameter("answerContent");
			String answerUser = request.getParameter("answerUser");
			
			//zzl_faqAdd_校验知识是否重复增添
			List<FaqQuestion> isExist = faqManagerService.faqAdd(faqTitle,problemUser);

			JSONObject jsonObject = new JSONObject();
			if (isExist.size()==0) {
				//zzl_保存知识
				faqQuestionService.saveCommunityQuestionToFAQ(faqTitle,keywords,faqclassifyId,modifyTime,faqDescription,userId,answerContent,communityQuestionId,answerUser);
				//保存知识成功返回1
				jsonObject.put("value", "1");
				jsonObject.put("url", url);
				String result = JsonUtil.toJsonString(jsonObject);
				return result;				
			}else {			
				//重复添加返回2
				jsonObject.put("value", "2");
				jsonObject.put("url", url);
				String result = JsonUtil.toJsonString(jsonObject);
				return result;
			}
		}
	}	
	
	/**
	 * faq图片上传
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@ResponseBody
	@RequestMapping(value={"/webUploader"},method={org.springframework.web.bind.annotation.RequestMethod.POST},produces="text/plain;charset=UTF-8")
	public String webUploader(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IllegalStateException, IOException{
//		String path1 = request.getContextPath();
		String username = (String) session.getAttribute("username");		
		if (username==null) {
			return "redirect:login.html";
		}else {
			MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;//request强制转换注意
			Iterator<String> iterator = mRequest.getFileNames();
	        String path  ="";
	        String fileName = "";
	        String suffix = "";
			String filename = "";
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	        String dir = "static/cfile/"+username +"/"+ sdf.format(new Date()) + "/";
	        String realPath = request.getSession().getServletContext().getRealPath("/");
	       	        
	        while(iterator.hasNext()){
	            MultipartFile multipartFile = mRequest.getFile(iterator.next());
	            if(multipartFile != null){
	                String fn = multipartFile.getOriginalFilename();
	                 suffix = fn.substring(fn.lastIndexOf("."));
	                 filename = RandomStringUtils.randomAlphanumeric(6);
	                fileName = dir + filename + suffix;
	                path = realPath + fileName;
	                path = path.replace("\\", "/");
	                File f = new File(path);
	                if(!f.mkdirs()){
	                    f.mkdir();
	                }
	                multipartFile.transferTo(f);
	                
	            }
	            
	            
	           
	        }
	        CopyFile copyFile = new CopyFile();
	        String newPath = copyFile.copyFile(path, username, sdf.format(new Date()));

	        newPath = newPath.replace("\\", "/");
	        newPath = newPath.replace("E:/eclipse/workspace/robot-master/org.xjtusicd3.partner/src/main/webapp", "/01");
	        faqManagerService.addFaqPic(username, newPath);
			
	        
	        try {
				Thread.sleep(3500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        String aString = "{\"result\":\""+path+"\"}";
	       
			return aString;
		}
    }
}
