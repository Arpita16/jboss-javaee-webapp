package library.rest;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile SingularAttribute<Book, Integer> BookCopy;
	public static volatile SingularAttribute<Book, Loan> loan;
	public static volatile SingularAttribute<Book, String> author;
	public static volatile SingularAttribute<Book, String> isbn;
	public static volatile SingularAttribute<Book, String> genre;
	public static volatile SingularAttribute<Book, Boolean> BookCopyStatus;
	public static volatile SingularAttribute<Book, String> title;
	public static volatile SingularAttribute<Book, Integer> shelfNo;
	public static volatile SingularAttribute<Book, Long> bookId;

}

