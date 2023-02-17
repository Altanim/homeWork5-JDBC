package DAO;
import model.Employee;

import java.util.List;
public interface EmployeeDao {

    List<Employee> getAllEmployees();

    void createEmployee(Employee employee);

    Employee getEmployeeById(int id);

    void setEmployeeById(Employee employee);

    void deleteEmployeeById(Employee employee);
    }

