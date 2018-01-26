package library.rest;

import java.util.List;



public interface BooksEjbInt {

	void createbook(Book book);

	List<Book> listBooks();

	List<Book> searchByTitle(String title);

	Book updateById(long id, String isbn);

	Book findById(Long id);

}