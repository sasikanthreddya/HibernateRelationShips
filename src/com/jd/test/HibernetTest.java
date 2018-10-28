package com.jd.test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.jd.model.BookAuthor;
import com.jd.model.BookCategory;
import com.jd.model.BookHO;
import com.jd.model.BookLoan;
import com.jd.model.Student;
import com.jd.util.HibernateUtil;

public class HibernetTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			
			Set<BookHO> bookSets=new HashSet<>();
			
			Set<BookLoan>bookloansset2=new HashSet<>();
			Set<BookLoan>bookloansset1=new HashSet<>();
			
			BookAuthor author=new BookAuthor();
			author.setEmail("author@gmail.com");
			author.setFirstName("author1");
			author.setPenName("blue Reynald");
			author.setLastName("ss");
			
			/*BookLoan BookLoan1=(BookLoan) session.get(BookLoan.class, 1);
			BookLoan BookLoan2=(BookLoan) session.get(BookLoan.class, 2);
			BookLoan BookLoan3=(BookLoan) session.get(BookLoan.class, 3);
*/			BookLoan bookLoan1=new BookLoan();
           bookLoan1.setDateOfIssue(new Date());
          // bookLoan1.setBook(book);
           
           BookHO bookHO2=new BookHO();
			bookHO2.setEdision("55 eddition");
			bookHO2.setName("a film by ll");
			bookHO2.setNumberOfBookAvailable(2);
			bookHO2.setBookLoans(bookloansset2);
			bookHO2.setBookAuthor(author);
			
			BookHO bookHO3=new BookHO();
			bookHO3.setEdision("start edition");
			bookHO3.setName("myAutoBioGraphy");
			bookHO3.setNumberOfBookAvailable(255);
			bookHO3.setBookLoans(bookloansset2);
			bookHO3.setBookAuthor(author);
		
           
           BookLoan bookLoan2=new BookLoan();
           bookLoan2.setDateOfIssue(new Date());
           bookLoan2.setBook(bookHO2);
           //bookLoan1.set
           BookLoan bookLoan3=new BookLoan();
           bookLoan3.setDateOfIssue(new Date());
           bookLoan3.setBook(bookHO3);
           //bookLoan3.setBook(book);
			
			
		//	System.out.println(BookLoan1.getDateOfIssue());
			
			
			//bookloansset1.add(bookLoan3);
			
			bookloansset2.add(bookLoan2);
			bookloansset2.add(bookLoan3);
		/*	Set<BookLoan>bookloansset2=new HashSet<>();
			bookloansset2.add(bookLoan3);
		*/	
			/*BookHO bookHO=new BookHO();
			bookHO.setEdision("4th eddition");
			bookHO.setName("a film by vinay");
			bookHO.setNumberOfBookAvailable(2);
			//bookHO.setBookLoans(bookloansset1);
			//session.merge(bookHO);
			
			BookHO bookHO2=new BookHO();
			bookHO2.setEdision("3rd eddition");
			bookHO2.setName("a film by venu");
			bookHO2.setNumberOfBookAvailable(2);*/
			//bookHO2.setBookLoans(bookloansset1);
		//	bookHO2.setBookLoans(bookloansset1);
			//session.merge(bookHO2);
			
			
			
			
			
			
			
			
			//bookHO2
			
		
			//bookSets.
			
			//author.setBooks(bookSets);
			
			
			
			//author.getBooks().ad
			
			
			bookSets.add(bookHO2);
			bookSets.add(bookHO3);
			
			author.setBooks(bookSets);
			
			session.save(author);
			
		/*	
			Student student1 = new Student();
			// student1.set(69);
			student1.setEmail("virtusa@in");
			student1.setLastName("last");
			student1.setFirstName("first");
			student1.setPassword("555555");
			student1.setPhoneNumber("99999999");
			student1.setBookLoans(bookloansset2);
			//session.merge(bookHO3);
			
			//bookloansset1.s
			//b
			//bookHO3.getBookLoans().add(bookLoan3);
			bookLoan3.setBook(bookHO3);
			bookLoan3.setStudent(student1);
			session.save(bookHO3);
			session.save(student1);
		*/
			
	 //  BookLoan BookLoan=(BookLoan) session.load(BookLoan.class, 1);
		//	BookLoan bookLoan=session.createCriteria(BookLoan);
	  /* Criteria criteria= session.createCriteria(BookLoan.class);
	  List<BookLoan>bookLoans =criteria.list();
		    for(BookLoan bookLoan:bookLoans)
		    {
		    	if(bookLoan.get)
		    }*/
		 	//Set<BookLoan> bookLoans= student.getBookLoans();
		/*	   Student student= BookLoan.getStudent();
			   if(student.getFirstName().equalsIgnoreCase("sasikanth"))
				    student.setPhoneNumber("94563215");
			//bookLoans.stream().filter(BookLoan->BookLoan.get)
			    session.save(student);
			   System.out.println(student.getPhoneNumber());
		*/	
			// bookLoan2.setIsReturned(new Byte((byte) 8));

			// bookLoan3.setIsReturned(new Byte((byte) 15));
			// bookLoan1.set

			/*Student student1 = new Student();
			// student1.set(69);
			student1.setEmail("sasi@in");
			student1.setLastName("reddy");
			student1.setFirstName("sasi");
			student1.setPassword("5adsd");
			student1.setPhoneNumber("88888888");

			Student student2 = new Student();
			// student2.setStudentId(55);
			student2.setEmail("sasi@insss");
			student2.setLastName("reddy");
			student2.setFirstName("sasikanth");
			student2.setPassword("5adsd");
			student2.setPhoneNumber("5468888");

			BookLoan bookLoan3 = new BookLoan();
			bookLoan3.setDateOfIssue(new Date());
			bookLoan3.setStudent(student2);
			session.save(bookLoan3);

			BookLoan bookLoan2 = new BookLoan();
			// bookLoan1.setStudentId(1);
			bookLoan2.setDateOfIssue(new Date());
			bookLoan2.setStudent(student2);
			session.save(bookLoan2);
			
			
			BookLoan bookLoan1 = new BookLoan();
			bookLoan1.setDateOfIssue(new Date());
			bookLoan1.setStudent(student1);
			session.save(bookLoan1);


			Set<BookLoan> bookLoansSet1 = new HashSet<>();
			bookLoansSet1.add(bookLoan1);
			bookLoansSet1.add(bookLoan2);

			// session.saveOrUpdate(bookLoansSet1);

			Set<BookLoan> bookLoansSet2 = new HashSet<>();
			bookLoansSet2.add(bookLoan3);
			// bookLoansSet2.
			// bookLoansSet1.
			// session.save(bookLoan3);
			// session.saveOrUpdate(bookLoansSet2);

			
			 * Set<Student> studentsSet1=new HashSet<>(); studentsSet1.add(student2);
			 * 
			 * Set<Student> studentsSet2=new HashSet<>(); studentsSet2.add(student1);
			 
			
			 * bookLoan1.setStudent(student1); bookLoan2.setStudent(student2);
			 
			student1.setBookLoans(bookLoansSet1);
			student2.setBookLoans(bookLoansSet2);
			session.save(student1);
			session.save(student2);
*/
			/*
			 * Set<BookHO>bookss=new HashSet<>(); BookHO bookHO1=new BookHO();
			 * bookHO1.setName("aaa"); bookHO1.setIsbn(111155);
			 * bookHO1.setNumberOfBookAvailable(28); bookss.add(bookHO1);
			 * 
			 * BookHO bookHO2=new BookHO(); bookHO2.setName("aaa"); bookHO2.setIsbn(111155);
			 * bookHO2.setNumberOfBookAvailable(28); bookss.add(bookHO2);
			 * session.save(bookHO2);
			 * 
			 * //session.save(bookss);
			 * 
			 * BookAuthor author1=new BookAuthor();
			 * author1.setEmail("sasi.tecg14@gmail.com"); author1.setFirstName("sasi");
			 * author1.setLastName("kanth"); author1.setPenName("max");
			 * //author1.setBooks(bookss); session.save(author1);
			 * 
			 * 
			 * BookCategory bookCategory=new BookCategory();
			 * bookCategory.setName("fantocy"); // bookCategory.setBooks(bookss);
			 * session.save(bookCategory);
			 */
			// author1.se

			/*
			 * BookAuthor author=(BookAuthor) session.get(BookAuthor.class, 1); BookCategory
			 * bookCategory=new BookCategory(); for(BookHO bookHO: bookss) {
			 * bookHO.setBookAuthor(author); bookHO.setBookCategory(bookCategory);
			 * session.save(bookHO);
			 * 
			 * } bookCategory.setName("fantocy"); bookCategory.setBooks(bookss);
			 * //bookCategory.set session.merge(bookCategory);
			 */

			// bookss.add(e)
			// bookss.add(bookHO1);

			/*
			 * BookAuthor bookAuthor=new BookAuthor(); bookAuthor.setBooks(bookss);
			 * bookAuthor.setEmail("sss"); bookAuthor.setFirstName("aaa");
			 * bookAuthor.setPenName("ssss"); session.save(bookAuthor);
			 *//*
				 * BookHO bookHO1=new BookHO(); bookHO1.setName("ss"); bookHO1.setIsbn(1111);
				 * bookHO1.setNumberOfBookAvailable(25); bookss.add(bookHO1);
				 * //bookHO1.setBookAuthor(bookAuthor); session.merge(bookHO1); BookCategory
				 * bookCategory=new BookCategory(); bookCategory.setName("fantocy");
				 * bookCategory.setBooks(bookss);
				 */
			/*
			 * public BookHo getBook() {
			 * 
			 * }
			 */
			/*
			 * public static BookHO getBook(){ BookHO bookHO=(com.jd.model.BookHO)
			 * session.get(BookHO.class, 1); return bookHO; }
			 */

			/*
			 * Criteria criteria=session.createCriteria(BookAuthor.class); List<BookAuthor>
			 * BookHOs=criteria.list(); //criteria. for(BookAuthor BookAuthor:BookHOs) {
			 * //System.out.println(BookAuthor.getEmail());
			 * System.out.println(BookAuthor.getFirstName()); System.out.println("heloo"); }
			 */
			// System.out.println(journey.getPassengers().size());

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			HibernateUtil.closeSessionFactory();
		}
	}
}
