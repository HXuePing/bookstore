package cn.ping.dao.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.ping.dao.OrderDao;
import cn.ping.domain.Book;
import cn.ping.domain.Order;
import cn.ping.domain.OrderItem;
import cn.ping.domain.User;
import cn.ping.utils.JdbcUtils;

public class OrderDaoImpl implements OrderDao {
	public void add(Order o){
		try{
			Connection conn=JdbcUtils.getConn();
			QueryRunner runner=new QueryRunner();
			String sql="insert into orders (id,ordertime,state,price,user_id) values(?,?,?,?,?)";
			Object params[]={o.getId(),o.getOrdertime(),o.isState(),o.getPrice(),o.getUser().getId()};
			runner.update(conn, sql, params);
			
			Set<OrderItem> items=o.getOrderitems();
			for(OrderItem item:items){
				sql="insert into orderitem (id,quantity,price,book_id,order_id) values (?,?,?,?,?)";
				params=new Object[]{item.getId(),item.getQuantity(),item.getPrice(),item.getBook().getId(),o.getId()};
				runner.update(conn, sql, params);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	public Order find(String id){
		try{
			Connection conn=JdbcUtils.getConn();
			QueryRunner runner=new QueryRunner();
			String sql="select * from orders where id=?";
			Order o=(Order) runner.query(conn, sql, id,new BeanHandler(Order.class));
			
			//找出每个订单的多个订单项
			sql="select * from orderitem where order_id=?";
			List<OrderItem> orderitemlist=(List<OrderItem>) runner.query(conn, sql, id, new BeanListHandler(OrderItem.class));
			//找出订单项下的书籍
			for(OrderItem item :orderitemlist){
				sql = "select book.* from book,orderitem oi where book.id=oi.book_id and oi.id=? ";
			Book book=(Book) runner.query(conn, sql, item.getId(), new BeanHandler(Book.class));
			item.setBook(book);
			}
			o.getOrderitems().addAll(orderitemlist);
			
			//找出用户
			sql= "select uuser.* from uuser,orders o where uuser.id=o.user_id and o.id=?";
			User user=(User) runner.query(conn, sql, id,new BeanHandler(User.class));		
			o.setUser(user);
			return o;
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	
	}
	
	public Order findOrderByUserId(String userid){
		try{
			Connection conn=JdbcUtils.getConn();
			QueryRunner runner=new QueryRunner();
			String sql="select * from orders where user_id=?";
			Order o=(Order) runner.query(conn, sql, userid,new BeanHandler(Order.class));
			
			//找出每个订单的多个订单项
			sql="select * from orderitem where order_id=?";
			List<OrderItem> orderitemlist=(List<OrderItem>) runner.query(conn, sql, o.getId(), new BeanListHandler(OrderItem.class));
			//找出订单项下的书籍
			for(OrderItem item :orderitemlist){
				sql = "select book.* from book,orderitem oi where book.id=oi.book_id and oi.id=? ";
			Book book=(Book) runner.query(conn, sql, item.getId(), new BeanHandler(Book.class));
			item.setBook(book);
			}
			o.getOrderitems().addAll(orderitemlist);
			
			//找出用户
			sql= "select uuser.* from uuser,orders o where uuser.id=o.user_id and o.user_id=?";
			User user=(User) runner.query(conn, sql, userid,new BeanHandler(User.class));		
			o.setUser(user);
			return o;
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	
	}
	
	public List<Order> getAll(boolean state){
		try{
			Connection conn=JdbcUtils.getConn();
			QueryRunner runner=new QueryRunner();
			String sql="select * from orders where state=?";
			List<Order> list=(List<Order>) runner.query(conn, sql, state,new BeanListHandler(Order.class));
			
			for(Order o:list){
				sql="select uuser.* from uuser,orders o where uuser.id=o.user_id and o.id=?";
				User u=(User) runner.query(conn, sql, o.getId(),new BeanHandler(User.class));
				o.setUser(u);
			}
			return list;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	
	}
	public void update(String id,boolean state){
		try{
			Connection conn=JdbcUtils.getConn();
			QueryRunner runner=new QueryRunner();
			String sql="update orders set state =? where id=?";
			Object params[]={state,id};
			runner.update(conn, sql, params);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
