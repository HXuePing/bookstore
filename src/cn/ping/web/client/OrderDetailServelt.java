package cn.ping.web.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ping.domain.Order;
import cn.ping.domain.User;
import cn.ping.service.BusinessService;
import cn.ping.service.impl.BusinessServiceImpl;


public class OrderDetailServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BusinessService bs=new BusinessServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			User user=(User) request.getSession().getAttribute("user");
			if(user!=null){
				Order order=bs.findOrderByuserid(user.getId());
				request.setAttribute("order", order);
				request.getRequestDispatcher("/client/oneorderdetail.jsp").forward(request, response);
				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
