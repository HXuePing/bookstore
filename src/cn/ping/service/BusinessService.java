package cn.ping.service;

import java.util.List;

import cn.ping.domain.Book;
import cn.ping.domain.Cart;
import cn.ping.domain.Category;
import cn.ping.domain.Order;
import cn.ping.domain.PageBean;
import cn.ping.domain.Privilege;
import cn.ping.domain.QueryInfo;
import cn.ping.domain.User;

public interface BusinessService {

	//category类
	void addCategory(Category c);

	Category findCategory(String id);

	List getAllCategory();
	void deleteCategory(String id);

	//user类
	void addUser(User u);

	User findUser(String id);

	User findUser(String username, String password);

	//book类
	void addBook(Book b);

	Book findBook(String id);

	PageBean bookPageQuery(QueryInfo info);

	List getAllBook();

	void saveOrder(Cart cart, User user);

	Order findOrder(String id);

	List getAll(boolean state);

	void update(String id, boolean state);

	List<Privilege> gtAllPrivilege(User user);
	
	public Order findOrderByuserid(String userid);

}