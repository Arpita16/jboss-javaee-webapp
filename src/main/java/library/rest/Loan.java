package library.rest;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


@Entity
public class Loan {
	
	
	@Column(name="Loan_Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int loanId;
	
	
	LocalDate startdate;
	LocalDate endDate;
	
	public Loan() {}
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Member_Id")
	private Member member;
	


	


	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Loan_ID")
	 private Book book;
	
	 public Loan(LocalDate startdate, LocalDate endDate) {
			super();
			this.startdate = startdate;
			this.endDate = endDate;
		}
	
	
	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}

public int getLoanId() {
		return loanId;
	}


	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}


	public LocalDate getStartdate() {
		return startdate;
	}


	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}


	public LocalDate getEndDate() {
		return startdate.plusMonths(2);
		
	}




//	public void setBooks(List<Books> books) {
//		this.books = books;
//	}


	


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	
		
	


	public Loan add(Loan loan) {
		return loan;
		
	}


	
	
	
	
	
}
