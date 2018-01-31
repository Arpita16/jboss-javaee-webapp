package library.rest;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Member.class)
public abstract class Member_ {

	public static volatile SingularAttribute<Member, String> firstName;
	public static volatile SingularAttribute<Member, String> lastName;
	public static volatile ListAttribute<Member, Loan> loan;
	public static volatile SingularAttribute<Member, String> address;
	public static volatile SingularAttribute<Member, Long> phoneNo;
	public static volatile SingularAttribute<Member, String> email;
	public static volatile SingularAttribute<Member, Long> memberId;

}

