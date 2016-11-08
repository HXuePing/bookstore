package junit;

import org.junit.Test;

import cn.ping.domain.Book;
import cn.ping.domain.Cart;
import cn.ping.domain.Category;
import cn.ping.domain.PageBean;
import cn.ping.domain.QueryInfo;
import cn.ping.domain.User;
import cn.ping.service.BusinessService;
import cn.ping.service.impl.BusinessServiceImpl;
import cn.ping.utils.JdbcUtils;

public class BusinessServiceTest {
	private BusinessService bs=new BusinessServiceImpl();
	
	@Test
	public void testAddCategory(){
		
		Category c=new Category();
		c.setId("3");
		c.setName("java");
		c.setDescription("hahaha");
		
		bs.addCategory(c);
		
		JdbcUtils.commitTransation();
	}
	@Test
	public void testFindCategory(){
		bs.findCategory("1");
	}
	

	@Test
	public void testGetAllCategory(){
		bs.getAllCategory();
	}
	
	@Test
	public void testAddBook(){
		Category c=new Category();
		c.setId("3");
		c.setName("java");
		c.setDescription("hahaha");
		
		Book book=new Book();
		book.setId("11");
		book.setName("java开发入门");
		book.setPrice(300);
		book.setAuthor("和");
		book.setDescription("i know");
		book.setImage("5");
		book.setCategory(c);
		
		bs.addBook(book);
		JdbcUtils.commitTransation();
	}
	
	@Test
	public void testFindBook(){
		bs.findBook("1");
	}
	
	
	@Test
	public void testPageQuery(){
		QueryInfo info=new QueryInfo();
		info.setCurrentpage(1);
		info.setPagesize(2);
		
		PageBean bean=bs.bookPageQuery(info);
		
		System.out.println(bean);
	}
	
	@Test
	public void testAddUser(){
		User user = new User();
		user.setAddress("aaaa");
		user.setCellphone("2323");
		user.setEmail("aa@sina.com");
		user.setId("1");
		user.setPassword("123");
		user.setPhone("2323");
		user.setUsername("aaa");
		
		bs.addUser(user);
		JdbcUtils.commitTransation();
		
	}
	

	@Test
	public void testSaveOrder(){
		
		User user = new User();
		user.setAddress("aaaa");
		user.setCellphone("2323");
		user.setEmail("aa@sina.com");
		user.setId("1");
		user.setPassword("123");
		user.setPhone("2323");
		user.setUsername("aaa");
		
		Category c=new Category();
		c.setId("3");
		c.setName("java");
		c.setDescription("hahaha");
		
		Cart cart = new Cart();
		Book book=new Book();
		book.setId("11");
		book.setName("java开发入门");
		book.setPrice(300);
		book.setAuthor("和");
		book.setDescription("i know");
		book.setImage("5");
		book.setCategory(c);
		cart.add(book);
		
		bs.saveOrder(cart, user);
		JdbcUtils.commitTransation();
	}
	
	
}
