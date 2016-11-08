package cn.ping.utils;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.ping.domain.Book;
import cn.ping.domain.Category;
import cn.ping.service.BusinessService;
import cn.ping.service.impl.BusinessServiceImpl;

public class WebUtils {
	public static <T> T request2Bean(HttpServletRequest request,Class<T> beanClass){
		try{
			T bean=beanClass.newInstance();
			Map map=request.getParameterMap();
			System.out.println(map+"===========");
			BeanUtils.populate(bean, map);
			return bean;	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	
	public static Book upload(HttpServletRequest request,String upPath){
		Book bookbean =new Book();
		try{
				DiskFileItemFactory factory=new DiskFileItemFactory();
				ServletFileUpload upload=new ServletFileUpload(factory);
				upload.setHeaderEncoding("UTF-8");			
				List<FileItem> items=upload.parseRequest(request);
			
				for(FileItem item:items){
					if(item.isFormField()){
						String name=item.getFieldName();
						String value=item.getString("UTF-8");
						if("category_id".equals(name)){
							BusinessService bs=new BusinessServiceImpl();
							Category c=bs.findCategory(value);
							bookbean.setCategory(c);
						}else{
							BeanUtils.setProperty(bookbean, name, value);
						}
						
					}else{
						String filename=item.getName();
						filename=filename.substring(filename.lastIndexOf("\\")+1);
						String savepath=upPath;
						String savefilename=UUID.randomUUID().toString()+filename;
						
						System.out.println("========savefilename===="+savefilename);
						
						
						InputStream in=item.getInputStream();
						FileOutputStream out=new FileOutputStream(savepath+"\\"+savefilename);
						
						int len;
						byte buffer[]=new byte[1024];
						while((len=in.read(buffer))>0){
							out.write(buffer, 0, len);
						}
						in.close();
						out.close();
						item.delete();
						bookbean.setImage(savefilename);
					}
					
					
				}
				bookbean.setId(UUID.randomUUID().toString());
				return bookbean;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	
		
	}
}
