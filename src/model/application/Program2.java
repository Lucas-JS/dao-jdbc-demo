package model.application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	
	public static void main(String[] args) {
		
Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao(); 
		
		System.out.println("===== Test 1: department findById =====");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n===== Test 2: department findAll =====");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===== Test 3: department insert =====");
		Department newDepartment = new Department(null, "Food");
		departmentDao.insert(newDepartment); 
		System.out.println("Inserted! New Id: "+ newDepartment.getId());
		
		System.out.println("\n===== Test 4: department update =====");
		department = departmentDao.findById(6);
		department.setName("BackOffice");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		System.out.println("\n===== Test 5: department delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}
}
/*O segrede é quebrar os grandes problemas em pequenos pedacos administraveis. 
 * Se voce lidar com eles de forma lógica e ponderada, terminará por resolve-los antes que perceba.*/
