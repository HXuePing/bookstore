package cn.ping.dao;

import java.util.List;

import cn.ping.domain.Book;
import cn.ping.domain.QueryResult;

public interface BookDao {

	void add(Book b);

	Book find(String id);

	QueryResult pageResult(int startindex, int pagesize, String where, String param);

	List getAll();
	

}