package cn.ping.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ping.utils.JdbcUtils;

public class TransactionFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request =(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		
		chain.doFilter(request,response);
		try{
			JdbcUtils.commitTransation();
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.closeTransation();
		}
	}
	@Override
	public void destroy() {
	

	}



	@Override
	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
