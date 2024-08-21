package com.love2code.springboot.cruddemo.dao;

import com.love2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
@Service
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    private EntityManager entityManager;

    public EmployeeDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee ", Employee.class);
        List<Employee> employees =  query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
         Employee theEmployee = entityManager.find(Employee.class,id);
         return  theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee employee1 = entityManager.merge(employee);
        return  employee1;
    }

    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class,id);
        entityManager.remove(employee);

    }


}
