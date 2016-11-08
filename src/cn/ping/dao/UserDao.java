package cn.ping.dao;

import java.util.List;

import cn.ping.domain.User;

public interface UserDao {

	void add(User u);

	User find(String id);

	User find(String username, String password);

	public List getAllPrivilege(User user);
}