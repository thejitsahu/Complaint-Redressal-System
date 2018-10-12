package com.complaint.Login;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//"/add-user-form.jsp",

@WebFilter(urlPatterns={"/add-replacement-form.jsp","/add-engineer-form.jsp",
		"/update-engineer-form.jsp","/list-engineers.jsp","/update-replacement-form.jsp","/list-replacements.jsp","/list-users.jsp"
		,"/EngineerControllerServlet","/ReplacementControllerServlet","/UserControllerServlet","/StudentControllerServlet","/HomeControllerServlet"})
public class AuthenticationFilter implements Filter 
{
	public void init(FilterConfig fConfig) throws ServletException 
	{
	
	}
	public void doFilter(ServletRequest req, ServletResponse res
			,FilterChain chain) throws IOException, ServletException 
	{		
			HttpServletRequest request = (HttpServletRequest)req;
			HttpServletResponse response = (HttpServletResponse)res;
			HttpSession session = request.getSession(false);
			String loginURI = request.getContextPath()+"/login.jsp";
			
			String name = (String)session.getAttribute("name");
			System.out.println("Avengers");
			System.out.println(name);
			if((name.equals("")))
			{
				response.sendRedirect(loginURI);
			
			}
			
			else
			{
				chain.doFilter(request, response);
			}
	}
	public void destroy() 
	{
	
	}

}
