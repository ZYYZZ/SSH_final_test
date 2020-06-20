package cn.edu.xaut.entity;

import java.io.Serializable;

public class Book implements Serializable{
	
	private Integer id;
	private String name;
	private float price;
	private int count;
	private String author;
	
	public Book() {

	}
	public Book(int id,String name,float price, int count,String author) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", count=" + count + ", author=" + author
				+ "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
