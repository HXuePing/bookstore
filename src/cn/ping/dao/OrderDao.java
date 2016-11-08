package cn.ping.dao;

import java.util.List;

import cn.ping.domain.Order;

public interface OrderDao {

	void add(Order o);

	Order find(String id);

	List getAll(boolean state);

	void update(String id, boolean state);
	public Order findOrderByUserId(String userid);
}