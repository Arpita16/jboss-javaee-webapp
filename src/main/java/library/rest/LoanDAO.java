package library.rest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;




@Stateful
public class LoanDAO {
	


	
	@Inject
	EntityManager em;
	
	
	
		public Book findBybookId(Long bookId) {
			return em.find(Book.class, bookId);
		}	
		public Member findBymemberId(Long memberId) {
				return em.find(Member.class, memberId);
		
		}
		
		public void Createloan(Long bookId, Long  memberId) {
		
		//Loan loan= n(findBybookId(bookId),findBymemberId(memberId));
		
			//Checked by Mattias!!
		Book foundBook = em.find(Book.class, bookId);
			Member foundMember = em.find(Member.class, memberId);
			Loan loan = new Loan();
			loan.getBook().add(foundBook);
			loan.setMember(foundMember);
			foundBook.setLoan(loan);
			foundMember.setLoan(loan);
			em.merge(loan);
			em.merge(foundBook);
			em.merge(foundMember);
		    em.persist(loan);
	

			
			
		}
		
	public List<Loan> listLoans() {
		
		TypedQuery<Loan> query = em.createQuery("SELECT l FROM Loan l", Loan.class);
			   List<Loan> results = query.getResultList();
			   return results;
	}
	
	



public Loan searchById(int loanId) {
	
		  TypedQuery<Loan> query = em.createQuery("SELECT l FROM Loan b WHERE l.loanId= :replace", Loan.class);
	  		query.setParameter("replace", loanId);
		   Loan loan= query.getSingleResult();
		   return loan;
	
	}
	
	
public Loan updateById(int loanId, LocalDate newstartdate) {
	Loan loan= findById(loanId);
//	TypedQuery<Books> query = em.createQuery("SELECT b FROM Books b WHERE b.bookId = :update", Books.class);
//	query.setParameter("update",id );
//	Books books  = query.getSingleResult();
	loan.setStartdate(newstartdate);
	
	return loan;



}


public Loan findById(int loanId) {
	return em.find(Loan.class, loanId);
}

	
}

		






	
	



