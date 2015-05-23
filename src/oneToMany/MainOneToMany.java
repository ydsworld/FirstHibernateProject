package oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainOneToMany {

	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		user.setUserName("apatel");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("BMW");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("MERC");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle1);
		vehicle.setUser(user);
		vehicle1.setUser(user);
		
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(user);
		session.save(vehicle);
		session.save(vehicle1);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
