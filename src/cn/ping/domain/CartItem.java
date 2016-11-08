package cn.ping.domain;

public class CartItem {
	private Book book;
	private int quantity;
	private int price;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.price=this.book.getPrice()*quantity;
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	
	
}
