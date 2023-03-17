package utilities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMUtil {
	static public EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("EmployeeUnit");
	}

	public static EntityManager provideConnection() {
		return emf.createEntityManager();
	}
}
