package cn.kgc.tangcco.tcmp073.qizu.recruit.user.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.kgc.tangcco.tcmp073.qizu.entity.RecruitingUsers;

public class UserInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("请求");
		HttpSession session = request.getSession();
		RecruitingUsers attribute = (RecruitingUsers)session.getAttribute("loginUser");
		System.out.println(attribute);
		if(attribute!=null) {
			return true;
		}
		response.sendRedirect("toLogin.controller");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("响应");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("视图");
	}

}
