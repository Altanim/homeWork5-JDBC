import DAO.EmployeeDao;
import DAO.impl.EmployeeDaoImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    Employee ruslan = new Employee( "Paris",
            "Hilton",
            "female",
            33,
            new City("Moscow"));
//    employeeDao.createEmployee(ruslan);
//        employeeDao.deleteEmployeeById(14);
        employeeDao.setEmployee(ruslan);

    List<Employee> employeeList = employeeDao.getAllEmployees();
    employeeList.forEach(System.out::println);

    }
    }

