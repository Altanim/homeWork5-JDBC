package DAO;
import model.Employee;

import java.util.List;
public interface EmployeeDao {

    List<Employee> getAllEmployees();

    void createEmployee(Employee employee);

    Employee getEmployeeById(int id);

    void setEmployeeById(int id, String firstName, String lastName, String gender, int age, int cityId);

    void deleteEmployeeById(int id);
    }

