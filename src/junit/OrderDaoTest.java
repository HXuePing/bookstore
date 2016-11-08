package junit;


import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;

import cn.ping.dao.OrderDao;
import cn.ping.dao.impl.OrderDaoImpl;
import cn.ping.domain.Order;
import cn.ping.domain.User;
import cn.ping.utils.JdbcUtils;

public class OrderDaoTest {
	@Test
	public void add(){
		
		
		OrderDao dao=new OrderDaoImpl();
		Order o=new Order();
		o.setId("1");
		o.setOrdertime(new Timestamp(System.currentTimeMillis()));
		o.setPrice(80);
		o.setState(true);
		o.setUser(new User());
		dao.add(o);
		
		JdbcUtils.commitTransation();
	}
	
	@Test
	public void find(){
		OrderDao dao=new OrderDaoImpl();
		dao.find("1");
		
		JdbcUtils.commitTransation();
	}
	@Test
	public void getAll(){
		OrderDao dao=new OrderDaoImpl();
		dao.getAll(true);
	}
	
	@Test
	public void up(){
		OrderDao dao=new OrderDaoImpl();
		dao.update("1", false);
		
		JdbcUtils.commitTransation();
	}
}
