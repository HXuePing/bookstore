package cn.ping.dao;

import java.util.List;

import cn.ping.domain.Category;

public interface CategoryDao {

	void add(Category c);

	Category find(String id);

	List<Category> getAll();
	void delete(String id);
}