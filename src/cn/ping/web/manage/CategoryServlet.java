package cn.ping.web.manage;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ping.domain.Category;
import cn.ping.domain.User;
import cn.ping.service.BusinessService;
import cn.ping.service.impl.BusinessServiceImpl;
import cn.ping.utils.SercurityException;
import cn.ping.utils.ServiceFactory;
import cn.ping.utils.WebUtils;





public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private BusinessService bs=new BusinessServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		if("add".equals(method)){
			add(request,response);
		}
		if("getAll".equals(method)){
			getAll(request,response);
		}
		if("delete".equals(method)){
			delete(request,response);
		}
	}


	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		String id=request.getParameter("id");
		BusinessService service=new BusinessServiceImpl();
		service.deleteCategory(id);
		request.setAttribute("message", "删除成功");
		}catch(Exception e){
			request.setAttribute("message", "删除失败");
			throw new RuntimeException(e);
		}
		request.getRequestDispatcher("/message2.jsp").forward(request, response);
	}


	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BusinessService service=new BusinessServiceImpl();
		try{
		List list=service.getAllCategory();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/manager/listcategory.jsp").forward(request, response);
		}catch(Exception e){
			if(e.getCause() instanceof SercurityException){
				request.setAttribute("message", e.getCause().getMessage());
			}
		}
	}


	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//BusinessService service=ServiceFactory.getInstance().createService((User)request.getSession().getAttribute("user"));
		BusinessService service=new BusinessServiceImpl();
		try{
		Category c=WebUtils.request2Bean(request, Category.class);
		c.setId(UUID.randomUUID().toString());
		service.addCategory(c);
		request.setAttribute("message", "添加成功");
		}
		catch(Exception e){
			if(e.getCause() instanceof SercurityException){
				request.setAttribute("message", e.getCause().getMessage());
			}else{
				e.printStackTrace();
				request.setAttribute("message", "添加失败");
			}
		}
		request.getRequestDispatcher("/message2.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
