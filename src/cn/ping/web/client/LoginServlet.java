package cn.ping.web.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ping.domain.User;
import cn.ping.service.BusinessService;
import cn.ping.service.impl.BusinessServiceImpl;

public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		BusinessService bs=new BusinessServiceImpl();
		User user=bs.findUser(username, password);
		if(user==null){
			request.setAttribute("message", "密码错误");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}		
		request.getSession().setAttribute("user", user);
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
