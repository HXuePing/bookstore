package cn.ping.dao.impl;

import java.sql.Connection;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.ping.dao.BookDao;
import cn.ping.domain.Book;
import cn.ping.domain.QueryResult;
import cn.ping.utils.JdbcUtils;

public class BookDaoImpl implements BookDao {
	
	public void add(Book b){
		try{
			Connection conn=JdbcUtils.getConn();
			QueryRunner runner=new QueryRunner();
			String sql="insert into book (id,name,price,author,image,description,category_id) values(?,?,?,?,?,?,?)";
			Object params[]={b.getId(),b.getName(),b.getPrice(),b.getAuthor(),b.getImage(),b.getDescription(),b.getCategory().getId()};
			runner.update(conn, sql, params);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	public Book find(String id){
		try{
			Connection conn=JdbcUtils.getConn();
			QueryRunner runner=new QueryRunner();
			String sql="select * from book where id=?";
			Book book=(Book) runner.query(conn, sql, id, new BeanHandler(Book.class));
			return book;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	
		
	}
	private List getPageDate(int startindex,int pagesize,String where,Object param){
		try{
			Connection conn=JdbcUtils.getConn();
			QueryRunner runner=new QueryRunner();
			if(where==null||where.trim().equals("")){
			String sql = "select top  "  + pagesize + "  * from book  where id not in (select top  "+ startindex+"  id from book order by id) order by id";	
			return (List) runner.query(conn, sql,new BeanListHandler(Book.class));
			}
			String sql = "select top  "  + pagesize +  "  * from book "+ where +" and id not in ( select top  "+ startindex+"  id from book order by id) order by id";	
			return (List) runner.query(conn, sql,param,new BeanListHandler(Book.class));
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	private int pageTotalRecord(String where,Object param){
		try{			
			Connection conn=JdbcUtils.getConn();
			QueryRunner runner=new QueryRunner();
			if(where==null&& where.trim().equals("")){
				String sql = "select count(*) from book";
				return (int) runner.query(conn, sql, new ScalarHandler());
			}
			String sql = "select count(*) from book ";
			return (int) runner.query(conn, sql,new ScalarHandler());
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	
	}
	public QueryResult pageResult(int startindex,int pagesize,String where,String param){
		List list=getPageDate(startindex, pagesize, where, param);
		int totalRecord=pageTotalRecord(where, param);
		
		QueryResult qr=new QueryResult();
		qr.setList(list);
		qr.setTotalrecord(totalRecord);
		return qr;
		
	}
	
	public List getAll(){
		try{
			Connection conn=JdbcUtils.getConn();
			QueryRunner runner=new QueryRunner();
			String sql="select * from book";
			return (List) runner.query(conn, sql, new BeanListHandler(Book.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
}
