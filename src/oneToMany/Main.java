package oneToMany;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	 @SuppressWarnings("unchecked")
	    public static void main(String[] args) {
	 
	    //    System.out.println("Hibernate One-To-One example (Annotation)");
	        Configuration cfg=new Configuration();
	    	cfg.configure("hibernate.cfg.xml");
	    	SessionFactory sf=cfg.buildSessionFactory();
	    	Session session=sf.openSession();
	    	Transaction tx=session.beginTransaction();
	        
        Department department = new Department();
        department.setDepartmentName("Sales");
      // session.save(department);
         
        Employee emp1 = new Employee("Nina", "Mayers", "111");
        Employee emp2 = new Employee("Tony", "Almeida", "222");
 
        emp1.setDepartment(department);
        emp2.setDepartment(department);
         
//       session.save(emp1);
//        session.save(emp2);
// 
        session.getTransaction().commit();
        session.close();
        
        department=null;
        
        session = sf.openSession();
        session.beginTransaction();
        department = (Department) session.get(Department.class, 1);
        System.out.println(department.getDepartmentName());
      //  session.close();
        System.out.println(department.getEmployees().toString());
        
    }
}

