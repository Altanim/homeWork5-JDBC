package DAO;
import model.Employee;

import java.util.List;
public interface EmployeeDao {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    void createEmployee(Employee employee);

    void setEmployee(Employee employee);

    void deleteEmployeeById(long id);
    }

