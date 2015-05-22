package oneToMany;
import java.util.Set;   
 



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Loader;
 
@Entity
@Table(name="DEPARTMENT1")
@Loader(namedQuery="que")
//@NamedNativeQuery(name="que", query="Select firstname from EMPLOYEE2 where employee_id=?", resultClass = Employee.class)
public class Department {
 
    @Id
    @GeneratedValue
    @Column(name="DEPARTMENT_ID")
    private int departmentId;
     
    @Column(name="DEPT_NAME")
    private String departmentName;
     
    @OneToMany(mappedBy="department", fetch=FetchType.LAZY)
    
    private Set<Employee> employees;

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
 
    
}
