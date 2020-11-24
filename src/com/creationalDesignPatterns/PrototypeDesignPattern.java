package com.creationalDesignPatterns;

import java.util.ArrayList;
import java.util.List;

public class PrototypeDesignPattern {
	public static void main(String[] args) throws CloneNotSupportedException {
		List<String> list = new ArrayList<>();
		list.add("9959");
		list.add("7093");
		Employee emp1 = new Employee(111, "Sandeep", list);
		Employee emp2 = (Employee) emp1.clone();
		emp2.setId(222);
		emp2.setName("Kiran");
		Employee emp3 = (Employee) emp1.clone();
		emp3.setId(333);
		emp3.setName("Manu");
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println(emp3);
	}
}

class Employee implements Cloneable {
	private int id;
	private String name;
	private List<String> phones;
	
	
	public Employee() {
		super();
	}

	public Employee(int id, String name, List<String> phones) {
		super();
		this.id = id;
		this.name = name;
		this.phones = phones;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhones() {
		return phones;
	}
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Employee emp = new Employee();
		emp.setId(this.id);
		emp.setName(this.name);
		List<String> list = new ArrayList<>();
		for(String phone: phones) {
			list.add(phone);
		}
		return emp;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phones=" + phones + "]";
	}
	
}