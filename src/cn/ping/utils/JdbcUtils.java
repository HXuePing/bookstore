package cn.ping.utils;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	
	private static DataSource ds;
	static{
		ds=new ComboPooledDataSource();
	}
	public static DataSource getDatatSource(){
		return ds;
		
	}
	public static Connection getConn(){
		Connection conn=tl.get();
		try{
			
			if(conn==null){
				conn=ds.getConnection();
				conn.setAutoCommit(false);
			}
			tl.set(conn);
			return conn;			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	
	}
	public static void startTransation(){
		try{
			Connection conn=getConn();
			conn.setAutoCommit(false);					
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	
	}
	
	public static void commitTransation(){
		Connection conn=tl.get();
		try{
			
			if(conn!=null){
				conn.commit();
			}								
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	
	}
	
	public static void closeTransation(){
		Connection conn=tl.get();
		try{
			
			if(conn!=null){
				conn.close();
			}								
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			tl.remove();
		}
	}
}
