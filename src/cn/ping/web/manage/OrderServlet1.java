package cn.ping.web.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ping.domain.Order;
import cn.ping.service.BusinessService;
import cn.ping.service.impl.BusinessServiceImpl;

public class OrderServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BusinessService bs=new BusinessServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		if("getAll".equals(method)){
			getAll(request,response);
		}
		if("find".equals(method)){
			find(request,response);
		}
		if("update".equals(method)){
			update(request,response);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			bs.update(id, true);

			request.setAttribute("message", "订单已置为发货，请及时发货");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "出错！！");
		}
		request.getRequestDispatcher("/message2.jsp").forward(request, response);
		
	}

	private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		Order order=bs.findOrder(id);
		request.setAttribute("order", order);
		request.getRequestDispatcher("/manager/orderdetail.jsp").forward(request, response);
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) {
		try{
		Boolean state=Boolean.parseBoolean(request.getParameter("state"));
		
		List list=bs.getAll(state);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/manager/listorder.jsp").forward(request, response);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
