package com.xjtu.iqa.interceptor;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter{
	
	Logger logger = Logger.getLogger(CommonInterceptor.class);  
	 /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * 如果返回true
     *    执行下一个拦截器,直到所有的拦截器都执行完毕
     *    再执行被拦截的Controller
     *    然后进入拦截器链,
     *    从最后一个拦截器往回执行所有的postHandle()
     *    接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
 
        HttpSession session = request.getSession();
        String contextPath=session.getServletContext().getContextPath();
//        String[] noNeedAuthPage = new String[]{
//                "home",
//                "checkLogin",
//                "register",
//                "loginAjax",
//                "login",
//                "reply",                
//                "question",
//                "category",
//                "category2",
//                "search",
//                "answer",
//                };
 
        String uri = request.getRequestURI();
        uri = StringUtils.remove(uri, contextPath);
        System.out.println(uri);
        String username = (String)session.getAttribute("username");
        if(uri.equals("/login")||uri.equals("/adminLogin")){
        	logger.info("拦截器/login");
        	return true;
        }
        else if(username!=null){
        	logger.info("拦截器username!=null");
        	return true;
        }
        else {
        	logger.info("拦截器else");
        	response.sendRedirect("login");
        	return false;
        }
//        if(uri.startsWith("/fore")){
//            String method = StringUtils.substringAfterLast(uri,"/fore" );
//            if(!Arrays.asList(noNeedAuthPage).contains(method)){
//                User user =(User) session.getAttribute("user");
//                if(null==user){
//                    response.sendRedirect("loginPage");
//                    return false;
//                }
//            }
//        }
//        
//        String[] noNeedAuthPage1 = new String[]{
//	        "Login",
//	        "LoginCheck"};
//        if(uri.startsWith("/login")){
//            String method = StringUtils.substringAfterLast(uri,"/admin" );
//            if(!Arrays.asList(noNeedAuthPage1).contains(method)){
//                User user =(User) session.getAttribute("user");
//                if(null==user){
//                    response.sendRedirect("adminLogin");
//                    return false;
//                }
//                String auth = user.getAuthority();
//                if(!auth.equals("1")){
//                	response.sendRedirect("adminLogin");
//                    return false;
//                }
//            }
//        }
 
        
 
    }
  
    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
     * 可在modelAndView中加入数据，比如当前时间
     */
 
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,   
            ModelAndView modelAndView) throws Exception {
 
    }
  
    /** 
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等  
     *  
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() 
     */
      
    public void afterCompletion(HttpServletRequest request,   
            HttpServletResponse response, Object handler, Exception ex) 
    throws Exception { 
            
    } 
}
