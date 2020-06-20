package cn.edu.xaut.dao;

import java.util.List;

import cn.edu.xaut.entity.Book;

public interface BookDao {
	public List<Book> findBookByPage(int page,int pageSize);
	public void delete(int bid);
	public void update(Book cbook);
	public void addbook(Book nbook);
	public int findBookTotalPage(int pageSize);
	public Book seachone(int bid);
}
