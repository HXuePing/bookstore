package cn.ping.web.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ping.domain.PageBean;
import cn.ping.domain.QueryInfo;
import cn.ping.service.BusinessService;
import cn.ping.service.impl.BusinessServiceImpl;
import cn.ping.utils.WebUtils;


public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BusinessService bs=new BusinessServiceImpl();
		List categories=bs.getAllCategory();
		
		QueryInfo info=WebUtils.request2Bean(request, QueryInfo.class);
		
		String category_id=request.getParameter("category_id");
		if(category_id!=null&&!(category_id.trim().equals(""))){
			info.setQueryname("category_id");
			info.setQueryvalue(category_id);
		}
		PageBean bean=bs.bookPageQuery(info);
		
		request.setAttribute("categories", categories);
		request.setAttribute("bookbean", bean);
		
		request.getRequestDispatcher("/client/NewIndex.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
