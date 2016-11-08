package junit;

import java.util.UUID;

import org.junit.Test;

import cn.ping.dao.UserDao;
import cn.ping.dao.impl.UserDaoImpl;
import cn.ping.domain.User;
import cn.ping.utils.JdbcUtils;

public class UserTest {
	@Test
	public void add(){
		UserDao dao =new UserDaoImpl();
		User u=new User();
		u.setId("2");
		u.setUsername("xueping");
		u.setPassword("123456");
		u.setEmail("sina@qq.com");
		u.setCellphone("110");
		u.setAddress("haha");
		u.setPhone("hehe");
		dao.add(u);
		
		JdbcUtils.commitTransation();
	}
	@Test
	public void find(){
		UserDao dao =new UserDaoImpl();
		User u=dao.find("2");
		System.out.println(u);
	}
	
	@Test
	public void find1(){
		UserDao dao =new UserDaoImpl();
		User u=dao.find("xueping", "123456");
		System.out.println(u);
	}
}
