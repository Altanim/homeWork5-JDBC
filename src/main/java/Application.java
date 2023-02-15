import DAO.EmployeeDao;
import DAO.EmployeeDaoImpl;
import model.City;
import model.Employee;

import java.sql.*;

public class Application {

    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "qwerty";
        final String url = "jdbc:postgresql://localhost:5438/postgres";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT id," +
                            "first_name," +
                            "last_name," +
                            "gender," +
                            "age," +
                            "city_name" +
                            " FROM employee " +
                            "INNER JOIN city ON employee.city_id = city.city_id WHERE id =(?)");
            preparedStatement.setInt(1,2);
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                String cityName = resultSet.getString("city_name");
                System.out.printf(
                        "id: %d, name: %s, surname: %s, gender: %s, age: %d, city: %s",
                        id, firstName, lastName, gender, age, cityName
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(DriverManager.getConnection(url, user, password));
        employeeDao.getEmployeeById(2);
        System.out.println();
        employeeDao.getAllEmployees().forEach(System.out::println);
        Employee oleg = new Employee("Oleg", "Nemirov", "male", 55, 1);
        Employee ben = new Employee("Ben", "Roberts", "male", 30, 3);
        employeeDao.setEmployeeById(8, "Olga", "Nemirova", "female", 55, 1);


    }

}
