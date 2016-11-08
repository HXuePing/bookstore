package cn.ping.web.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ping.domain.Book;
import cn.ping.domain.Category;
import cn.ping.service.BusinessService;
import cn.ping.service.impl.BusinessServiceImpl;
import cn.ping.utils.WebUtils;


public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessService bs=new BusinessServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		if("addUI".equals(method)){
			addUI(request,response);
		}
		if("add".equals(method)){
			add(request,response);
		}
		if("getAll".equals(method)){
			getAll(request,response);
		}
	}

	
	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List list=bs.getAllBook();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/manager/listbook.jsp").forward(request, response);
	}


	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		String upPath=this.getServletContext().getRealPath("/images");
		System.out.println("========upPath===="+upPath);
		System.out.println(upPath);
		Book b=WebUtils.upload(request, upPath);
		bs.addBook(b);
		request.setAttribute("message", "添加成功");
		}catch(Exception e){
			request.setAttribute("message", "添加失败");
		}
		request.getRequestDispatcher("/message2.jsp").forward(request, response);
	}


	private void addUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List list=bs.getAllCategory();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/manager/addbook.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
