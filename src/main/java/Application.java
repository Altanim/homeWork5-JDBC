import DAO.EmployeeDao;
import DAO.EmployeeDaoImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {
    EmployeeDao employeeDao = new EmployeeDaoImpl();
        Employee employee = new Employee("Igor", "Nikolaev", "male", 50, 1);

        List<Employee> employeeList = employeeDao.getAllEmployees();
        employeeList.forEach(System.out::println);
        System.out.println(employeeDao.getEmployeeById(2));
    }
    }

