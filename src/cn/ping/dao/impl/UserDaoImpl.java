package cn.ping.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.ping.dao.UserDao;
import cn.ping.domain.Privilege;
import cn.ping.domain.User;
import cn.ping.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {
	public void add(User u){
		try{
			Connection conn=JdbcUtils.getConn();
			QueryRunner runner=new QueryRunner();
			String sql="insert into uuser (id,username,password,phone,cellphone,email,address) values (?,?,?,?,?,?,?)";
			Object params[]={u.getId(),u.getUsername(),u.getPassword(),u.getPhone(),u.getCellphone(),u.getEmail(),u.getAddress()};
			runner.update(conn, sql,params);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	public User find(String id){
		try{
			Connection conn=JdbcUtils.getConn();
			QueryRunner runner=new QueryRunner();
			String sql="select * from uuser where id=?";
			return (User) runner.query(conn, sql, id, new BeanHandler(User.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}

	}
	public User find(String username,String password){
		try{
			Connection conn=JdbcUtils.getConn();
			QueryRunner runner=new QueryRunner();
			String sql="select * from uuser where username=? and password=?";
			return (User) runner.query(conn, sql, new Object[]{username,password},new BeanHandler(User.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	
	public List getAllPrivilege(User user){
		try{
			Connection conn=JdbcUtils.getConn();
			QueryRunner runner=new QueryRunner();
			String sql="select p.* from user_privilege,privilege p where user_id=? and privilege_id=p.id";
			return (List) runner.query(conn, sql,user.getId(), new BeanListHandler(Privilege.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	
}
