package library.rest;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Book {

		
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookId;
	
	@NotNull
	private String isbn;

	private String title;
	private String genre;
	private String author;
	private int BookCopy;
	private boolean BookCopyStatus;
    private int shelfNo;
	
	public Book() {
	}

	
	/**Book class is mapped with bidirectional relation with Loan class Which means one book can have only one loan**/

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Loan_ID")
	 private Loan loan;
	
	
	public Book(String title, String genre, String author, int shelfNo,String isbn,int BookCopy,boolean BookCopyStatus) {

		this.title = title;
		this.genre = genre;
		this.author = author;
		this.shelfNo = shelfNo;
		this.isbn=isbn;
		this.BookCopy=BookCopy;
		this.BookCopyStatus=BookCopyStatus;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String gener) {
		this.genre = gener;
	}

	public int getShelfNo() {
		return shelfNo;
	}

	public void setShelfNo(int shelfNo) {
		this.shelfNo = shelfNo;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	
	public long getbookId() {
		return bookId ;
	}
        public int getBookCopy() {
		return BookCopy;
	}

	public void setBookCopy(int bookCopy) {
		this.BookCopy = bookCopy;
	}

	public boolean isBookCopyStatus() {
		return BookCopyStatus;
	}

	public void setBookCopyStatus(boolean bookCopyStatus) {
		this.BookCopyStatus = bookCopyStatus;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public Book add(Book foundBook) {
		return foundBook;
		
	}

	
	
	
	}





