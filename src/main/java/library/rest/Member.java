package library.rest;



import java.util.List;
import java.util.Collection;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import javax.validation.constraints.NotNull;



@Entity
public class Member{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="Member_Id")
	long memberId;
	
	@NotNull
	String firstName;
	@NotNull
	String lastName;
	String address;
	@Column(name="Phone_no")
	long phoneNo;
	@NotNull
	String email;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Member_ID")
	private List<Loan>loan;
	
	
	
	
	

	public Member() {}
	
	public Member(String firstName, String lastName, String address, long phoneNo, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
	}






	public String getEmail() {
		return email;
	}

   public void setEmail(String email) {
		this.email = email;
	}




	public long getMemberId() {
		return memberId;
	}


	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public long getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(long phoneNo) {
		phoneNo = phoneNo;
	}

	

//	public List<Books> getBook() {
//		return books;
//	}
//
//	public void setBook(List<Books> books) {
//		this.books = books;
	

	public List<Loan> getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan.add(loan);
	}





}