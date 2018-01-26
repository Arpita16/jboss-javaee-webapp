package library.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



@Stateless
public class BookDAO  {

	@Inject
	EntityManager em;

	/**Simple function to create book**/
	
	public void createbook(Book book) {
		em.persist(book);
	}


        /**Function to get list of books*/

	public List<Book> listBooks() {

		TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
		List<Book> results = query.getResultList();
		return results;
	}



	/**Function to get list of books of same title*/
	
	public List<Book> searchByTitle(String title) {

		TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.title LIKE :replace", Book.class);
		query.setParameter("replace", title+"%");
		List<Book> books= query.getResultList();
		return books;

	}

       /**Function to update ISBN number through BookID**/

	public Book updateById(long id, String newisbn) {
		Book book = findById(id);		
		book.setIsbn(newisbn);
		em.merge(book);
		return book;



	}


	public Book findById(Long bookId) {
		return em.find(Book.class, bookId);
	}


}
