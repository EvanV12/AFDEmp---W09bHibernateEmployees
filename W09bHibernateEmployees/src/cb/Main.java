package cb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create an employee object
			System.out.println("Creating new student object...");
			Employee emp = new Employee("George", "Koukos", 2300);

			// start a transaction
			session.beginTransaction();

			// save the employee object
			System.out.println("Saving the employee...");
			session.save(emp);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}
}

