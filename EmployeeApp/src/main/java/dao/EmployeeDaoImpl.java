package dao;

import entities.Employee;
import exceptions.EmployeeAddressException;
import exceptions.EmployeeException;
import jakarta.persistence.EntityManager;
import utilities.EMUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public Employee addEmployee(Employee emp) throws EmployeeException {
		EntityManager em = EMUtil.provideConnection();
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		em.close();
		return emp;
	}

	@Override
	public Employee findEmployeeById(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideConnection();
		Employee emp = em.find(Employee.class,empId);
		if(emp != null) {
			return emp;
		}
		else {
			throw new EmployeeException("Employee Not found!"); 
		}
		
	}

	@Override
	public Employee deleteEmployee(int empId) throws EmployeeException {
		EntityManager em = EMUtil.provideConnection();
		Employee emp = em.find(Employee.class,empId);
		if(emp != null) {
			em.remove(emp);
			return emp;
		}
		else {
			throw new EmployeeException("Employee Not found! to delete!! "); 
		}
	}

	@Override
	public String getEmployeeAddress(int empId) throws EmployeeException, EmployeeAddressException {
		EntityManager em = EMUtil.provideConnection();
		Employee emp = em.find(Employee.class,empId);
		String msg = "Employee found!";
		if(emp != null) {
			throw new EmployeeException("Employee Not found!"); 
		}
		else {
			throw new EmployeeException("Employee Not found!"); 
		}
	}

	@Override
	public double giveBonusToEmployee(int empId, double bonus) throws EmployeeException {
		EntityManager em = EMUtil.provideConnection();
		Employee emp = em.find(Employee.class,empId);
		String msg = "Employee found!";
		if(emp != null) {
			double kg = emp.getEmpSalary()+bonus;
			emp.setEmpSalary(emp.getEmpSalary()+bonus);
			return kg;
		}
		else {
			throw new EmployeeException("Employee Not found!"); 
		}
	}

}
