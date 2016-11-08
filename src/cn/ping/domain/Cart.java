package cn.ping.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	private Map<String,CartItem> map=new LinkedHashMap<String,CartItem>();
	private int price;
	
	public void add(Book book){
		CartItem item = map.get(book.getId());
		if(item==null){
			item=new CartItem();
			item.setBook(book);
			item.setQuantity(1);
			map.put(book.getId(), item);
		}else{
			item.setQuantity(item.getQuantity()+1);
		}
	}
	
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	public int getPrice() {
		int totalmoney=0;
		for(Map.Entry<String,CartItem> m:map.entrySet()){
			totalmoney+=m.getValue().getBook().getPrice();
		}
		this.price=totalmoney;
		return this.price;
		
	}
	
	
}
