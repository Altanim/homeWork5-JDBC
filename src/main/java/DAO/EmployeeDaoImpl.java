package DAO;

import configuration.HibernateSessionFactoryUtil;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {


    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = (List<Employee>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession()
                .createQuery("From Employee").list();
        return employees;
    }

    @Override
    public void createEmployee(Employee employee){
      try (
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
    }
}
    @Override
    public Employee getEmployeeById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
    }



    @Override
    public void setEmployeeById(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteEmployeeById(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }

}
