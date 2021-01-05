package com.example.demo.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Streams;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Transactional(propagation=Propagation.NOT_SUPPORTED)
public class EmployeeRepositoryTests {
	
	@Autowired
	private EmployeeRepository employeerepository;
	
	  @Autowired
	  private TestEntityManager em;
	
	  @Test
	    public void testSaveEmployee() {

	        Employee employee = new Employee("admin", "raju", "admin@gmail.com");
	        employeerepository.save(employee);
	        Employee employee2 = employeerepository.findByFirstName("admin");
	        assertNotNull(employee);
	        assertEquals(employee2.getFirstName(), employee.getFirstName());
	        assertEquals(employee2.getLastName(), employee.getLastName());
	    }
	  @Test
	    public void testGetEmployee() {

	        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
	        employeerepository.save(employee);
	        Employee employee2 = employeerepository.findByFirstName("admin");
	        assertNotNull(employee);
	        assertEquals(employee2.getFirstName(), employee.getFirstName());
	        assertEquals(employee2.getLastName(), employee.getLastName());
	        System.out.println(employee2.getFirstName());
	    }
	  
	  
	  @Test
	    public void findAllEmployees() {
		     List<Employee> findAll = employeerepository.findAll();
		     findAll.stream().filter(x -> x.getFirstName().matches("admin"));
		     System.out.println();
		     System.out.println(findAll+" \n");
		System.out.println();
	        assertNotNull(employeerepository.findAll());
	    }
	  @Test
	    public void findAllEmployeesEmplty() {
		     List<Employee> findAll = employeerepository.findAll();
		     findAll.stream().filter(x -> x.getFirstName().matches(""));
		     System.out.println();
		     System.out.println(findAll+" \n");
		System.out.println();
	        assertNotNull(employeerepository.findAll());
	    }
	  
	  @Test
	    public void testDeleteEmployee() {
	        Employee employee = new Employee("admin", "raju", "admin@gmail.com");
	        employeerepository.save(employee);
	        employeerepository.delete(employee);
	        System.out.println(employee.toString());
	    }
	  
	  	@Test
	    public void deletByEmployeeIdTest() {
	        Employee employee = new Employee("dgt", "sdjfk", "sdfsdfsdg@gmail.com");
	        Employee emp = employeerepository.save(employee);
	        employeerepository.deleteById(emp.getId());
	    }
	  
	  
	  @Test
	  @Transactional
	    void deleteById() {
	        employeerepository.deleteById(4l);
	        em.flush();
	        Employee after = em.find(Employee.class, 4l);
	        assertThat(after).isNull();
		 
	    }
}
