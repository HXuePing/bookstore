package cn.ping.web.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ping.domain.Cart;
import cn.ping.domain.User;
import cn.ping.service.BusinessService;
import cn.ping.service.impl.BusinessServiceImpl;

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			User user=(User) request.getSession().getAttribute("user");
			if(user==null){
				request.getSession().setAttribute("user", user);
				request.setAttribute("message", "请先登陆");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}
			try{
				Cart cart=(Cart) request.getSession().getAttribute("cart");
				BusinessService bs=new BusinessServiceImpl();
				bs.saveOrder(cart, user);
				request.setAttribute("message", "生成订单成功");
			}catch(Exception e){
				request.setAttribute("message", "生成订单失败");
			}
			request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
