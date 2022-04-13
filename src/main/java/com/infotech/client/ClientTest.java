package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Date;

public class ClientTest {
    public static void main(String[] args) {

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Employee employee = getEmployee();
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeName("Doraji Kim");
        employee.setEmail("kyw235353@gmail.com");
        employee.setSalary(80000.0);
        employee.setDoj(new Date());
        return employee;
    }


}
