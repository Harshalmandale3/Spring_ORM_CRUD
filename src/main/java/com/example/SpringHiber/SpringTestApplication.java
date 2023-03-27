package com.example.SpringHiber;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.support.DaoSupport;

import com.example.SpringHiber.model.Employee;
import com.example.SpringHiber.model.EmployeeDao;

@SpringBootApplication
public class SpringTestApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringTestApplication.class, args);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
	//	System.out.println("hello world");
		
		Employee e = new Employee();
		EmployeeDao db=(EmployeeDao)context.getBean("d");
		Scanner sc = new Scanner(System.in);
		
		
		boolean j=true;
		int choice=0,i,id;
		
		
		while (j){
			System.out.println("\n");
			System.out.println("1.Insert Data");
			System.out.println("2.Show Details");
			System.out.println("3.Update Data");
			System.out.println("4.Delete Record");
			System.out.println("0.Exit");
			
			System.out.println("Enter Your Choice:");
			choice = Integer.parseInt(sc.nextLine());
		
		
		switch (choice) {
		case 1:
			/* Employee e = new Employee(); */
			
			System.out.println("Name : ");
			String name = sc.nextLine();
			
			System.out.println("Address : ");
			String add = sc.nextLine();
			
			e.setName(name);
			e.setAddress(add);
			
			
			db.saveEmployee(e);
			System.out.println("Data inserted Successfully");
			break;
			
		case 2:
			System.out.println("Employee Show List");
			List<Employee> list = db.getAllData();
			for (Employee em:list) {
				System.out.println(em);
			}
			break;
			
		case 3:
			
			System.out.println("Enter id to Update:");
			id = Integer.parseInt(sc.nextLine());
			
			System.out.println("What do you want to update:");
			System.out.println("1.Name");
			System.out.println("2.Address");
			System.out.println("0.exit");
			System.out.println("Enter Your Choice:");
			i = Integer.parseInt(sc.nextLine());
			
			Employee em = db.getById(id);
			switch (i) {
			case 1:
				System.out.println("Enter Your Name :");
				String nname = sc.nextLine();
				
				
				int oid = em.getId();
				String oname = em.getName();
				String oadd = em.getAddress();
				
				e.setId(id);
				e.setName(nname);
				e.setAddress(oadd);
				
				db.updateEmployee(e);
				
	
				break;
			case 2:
				System.out.println("Enter Your Address :");
				String Add = sc.nextLine();
				
				
				oid = em.getId();
				oname = em.getName();
				oadd = em.getAddress();
				
				e.setId(id);
				e.setName(oname);
				e.setAddress(Add);
				
				db.updateEmployee(e);
				
				break;
			case 0:
				System.out.println("Exit");
				break;

			default:
				System.out.println("Invalid user Input");
				break;
			}
			System.out.println("Data Update Successfully");
			break;
			
		case 4:
			System.out.println("Enter id to Delete:");
			id = Integer.parseInt(sc.nextLine());
			
			e.setId(id);
			db.deleteEmployee(e);
			
			System.out.println("Data Delete Successfully");
			break;
			
		case 0:
			System.out.println("Exit");
			j=false;
			break;

		default:
			System.out.println("Invalid user Input");
			break;
		}
		}

	}

}
