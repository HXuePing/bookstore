package junit;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import cn.ping.dao.CategoryDao;
import cn.ping.dao.impl.CategoryDaoImpl;
import cn.ping.domain.Category;
import cn.ping.utils.JdbcUtils;

public class CategoryTest {
	@Test
	public void testaddCategory(){
		CategoryDao dao=new CategoryDaoImpl();
		Category c=new Category();
		c.setId(UUID.randomUUID().toString());
		c.setName("PING1");
		c.setDescription("吃太多");
		dao.add(c);
		
		JdbcUtils.commitTransation();
	}
	
	@Test
	public void testfindCategory(){
		CategoryDao dao=new CategoryDaoImpl();
		Category c=dao.find("1");
		System.out.println(c);
		
		JdbcUtils.commitTransation();
	}
	
	@Test
	public void testGetAll(){
		CategoryDao dao=new CategoryDaoImpl();
		List<Category> list=dao.getAll();
		System.out.println(list);
		
		JdbcUtils.commitTransation();
	}
}
