package cn.ping.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import cn.ping.dao.BookDao;
import cn.ping.dao.CategoryDao;
import cn.ping.dao.OrderDao;
import cn.ping.dao.UserDao;
import cn.ping.domain.Book;
import cn.ping.domain.Cart;
import cn.ping.domain.CartItem;
import cn.ping.domain.Category;
import cn.ping.domain.Order;
import cn.ping.domain.OrderItem;
import cn.ping.domain.PageBean;
import cn.ping.domain.Privilege;
import cn.ping.domain.QueryInfo;
import cn.ping.domain.QueryResult;
import cn.ping.domain.User;
import cn.ping.factory.FactoryDao;
import cn.ping.service.BusinessService;
import cn.ping.utils.Permission;


public class BusinessServiceImpl implements BusinessService{
	private BookDao bdao=FactoryDao.getInstance().createDao(BookDao.class);
	private CategoryDao cdao=FactoryDao.getInstance().createDao(CategoryDao.class);
	private OrderDao odao=FactoryDao.getInstance().createDao(OrderDao.class);
	private UserDao udao=FactoryDao.getInstance().createDao(UserDao.class);
	
	//category类
	@Permission("添加分类")
	public void addCategory(Category c){
		cdao.add(c);
	}
	
	public Category findCategory(String id){
		return cdao.find(id);	
	}
	public List getAllCategory(){
		return cdao.getAll();
		
	}
	public void deleteCategory(String id){
		cdao.delete(id);
	}
	
	//user类
	public void addUser(User u){
		udao.add(u);
	}
	public User findUser(String id){
		return udao.find(id);	
	}
	public User findUser(String username,String password){
		return udao.find(username, password);
	}
	//book类
	public void addBook(Book b){
		bdao.add(b);
	}
	public	Book findBook(String id){
		return bdao.find(id);
		
	}
	public PageBean bookPageQuery(QueryInfo info){
		QueryResult qr=bdao.pageResult(info.getStartindex(),info.getPagesize(), info.getWhere(), info.getQueryvalue());
		PageBean bean = new PageBean();
		bean.setCurrentpage(info.getCurrentpage());
		bean.setList(qr.getList());
		bean.setPagesize(info.getPagesize());
		bean.setTotalrecord(qr.getTotalrecord());
	
		return bean;
		
	}
	public List getAllBook(){	
		return bdao.getAll();
		
	}
	
	//order类
	public Order findOrderByuserid(String userid){
		return odao.findOrderByUserId(userid);
	}

	public void saveOrder(Cart cart,User user){	
		Order o=new Order();
		o.setId(UUID.randomUUID().toString());
		o.setOrdertime(new Timestamp(System.currentTimeMillis()));
		o.setPrice(cart.getPrice());
		o.setState(false);
		o.setUser(user);
		

		//定义一个集合，用于保存所有订单项
		Set oitems = new HashSet();
		
		//用购物车中的购物项生成订单项
		Set<Map.Entry<String, CartItem>> set=cart.getMap().entrySet();
		for(Map.Entry<String, CartItem>  entry: set){
			CartItem citem=entry.getValue();
			OrderItem item=new OrderItem();
			//用购物车中的购物项生成订单项
			item.setBook(citem.getBook());
			item.setId(UUID.randomUUID().toString());
			item.setPrice(citem.getPrice());
			item.setQuantity(citem.getQuantity());
			
			oitems.add(item);
		}
		o.setOrderitems(oitems);
		odao.add(o);
		
	}
	public Order findOrder(String id){
		return odao.find(id);
	}
	
	
	public List getAll(boolean state){
		return odao.getAll(state);
	}
	
	public void update(String id,boolean state){
		odao.update(id, state);
	}
	@Override
	public List<Privilege> gtAllPrivilege(User user) {
		return udao.getAllPrivilege(user);
	}
}
