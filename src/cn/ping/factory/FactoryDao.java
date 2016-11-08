package cn.ping.factory;

import java.io.IOException;
import java.util.Properties;

public class FactoryDao {
	
	private Properties config=new Properties();
	
	public FactoryDao(){
		try {
			config.load(FactoryDao.class.getClassLoader().getResourceAsStream("cn/ping/factory/dao.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	};
	public static FactoryDao instance=new FactoryDao();
	public static FactoryDao getInstance(){
		return instance;	
	}
	
	public <T> T createDao(Class<T> interfaceClass){
		
		String name=interfaceClass.getSimpleName();
		String value=config.getProperty(name);
		try {
			return (T) Class.forName(value).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		
	}
}
