package com.example.SpringHiber.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class EmployeeDao {
	
	HibernateTemplate template;
	
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public void saveEmployee(Employee e)
	{
		template.save(e);
	}
	
	public void updateEmployee(Employee e) {
		template.update(e);
	}
	
	public void deleteEmployee(Employee e) {
		template.delete(e);	
	}
	
	public Employee getById(int id) {
		Employee e = template.get(Employee.class, id);
		return e;
	}
	
	public List<Employee> getAllData() {
		List<Employee> list = new ArrayList<Employee>();
		list = template.loadAll(Employee.class);
		return list;	
	}
	
	/*
	 * public void updateById(int id, String name) { Employee e =
	 * mysessionFactory.("update Employee set name = name  where id= id");
	 * e.setName(name); template.saveOrUpdate(e); }
	 */
}
