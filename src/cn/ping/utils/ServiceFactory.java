package cn.ping.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import java.util.List;

import cn.ping.domain.Privilege;
import cn.ping.domain.User;

import cn.ping.service.BusinessService;
import cn.ping.service.impl.BusinessServiceImpl;

public class ServiceFactory {
	private ServiceFactory(){}
	private static ServiceFactory instance =new ServiceFactory();
	public static ServiceFactory getInstance(){
		return instance;
	}
	
	public BusinessService createService(final User user){
		BusinessService service=new BusinessServiceImpl();
		
		return (BusinessService) Proxy.newProxyInstance(ServiceFactory.class.getClassLoader(),service.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//得到web层的方法
				String methodName=method.getName();
				//反射出真实对象上相应的方法，检查是否有权限
				Method me=service.getClass().getMethod(methodName, method.getParameterTypes());
				Permission permission=me.getAnnotation(Permission.class);
				if(permission==null){
					return method.invoke(service, args);
				}
				//真实对象上有注解，得到注解上的权限
				Privilege p=new Privilege(permission.value());
				
				if(user==null){
					throw new SercurityException("你还没有登录");
				}
				//得到所有的权限
				List<Privilege> list=service.gtAllPrivilege(user);
				if(list.contains(p)){
					return method.invoke(service, args);
				}
				
				throw new SercurityException("你没有访问权限");
			
			}
		});
		
	}
	
}
