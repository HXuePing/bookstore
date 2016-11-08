package cn.ping.web.client;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ping.domain.User;
import cn.ping.service.BusinessService;
import cn.ping.service.impl.BusinessServiceImpl;
import cn.ping.utils.WebUtils;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		User user=WebUtils.request2Bean(request, User.class);
		user.setId(UUID.randomUUID().toString());
		BusinessService bs=new BusinessServiceImpl();
		bs.addUser(user);
		request.setAttribute("message", "添加成功");
		}catch(Exception e){
			request.setAttribute("message", "添加失败");
			throw new RuntimeException(e);
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
