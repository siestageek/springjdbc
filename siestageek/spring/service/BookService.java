package siestageek.spring.service;

import java.util.List;

import siestageek.spring.vo.Book;

public interface BookService {

	void newBook();
	List<Book> readBook();
	Book readOneBook();
	void modifyBook(Book b);
	void removeBook(String bookid);

}
