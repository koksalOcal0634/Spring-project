package com.love2code.springboot.cruddemo.service;

import com.love2code.springboot.cruddemo.dao.EmployeeDao;
import com.love2code.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDao employeeDao;
    // constructor injection

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {

         return  employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
       return employeeDao.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }
}
