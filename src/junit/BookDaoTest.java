package junit;

import org.junit.Test;

import cn.ping.dao.BookDao;
import cn.ping.dao.impl.BookDaoImpl;
import cn.ping.domain.Book;
import cn.ping.domain.Category;
import cn.ping.domain.QueryResult;
import cn.ping.utils.JdbcUtils;

public class BookDaoTest {
	@Test
	public void add(){
		BookDao dao=new BookDaoImpl();
		Book b=new Book();
		b.setId("4");
		b.setName("wehew");
		b.setAuthor("xueping");
		b.setImage("4");
		b.setPrice(80);
		b.setDescription("i know");
		b.setCategory(new Category());
		dao.add(b);
		
		JdbcUtils.commitTransation();
	}
	
	@Test
	public void find(){
		BookDao dao=new BookDaoImpl();
		Book b=dao.find("4");
		System.out.println(b);
		JdbcUtils.commitTransation();
	}
	@Test
	public void page(){
		BookDao dao = new BookDaoImpl();
		QueryResult result=dao.pageResult(0,2, "", "1");
		System.out.println(result);
	}
	
	@Test
	public void getAll(){
		BookDao dao = new BookDaoImpl();
		dao.getAll();
	}
}
