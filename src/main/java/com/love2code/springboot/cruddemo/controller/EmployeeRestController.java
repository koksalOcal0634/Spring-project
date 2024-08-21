package com.love2code.springboot.cruddemo.controller;

import com.love2code.springboot.cruddemo.dao.EmployeeDao;
import com.love2code.springboot.cruddemo.dao.EmployeeDaoImpl;
import com.love2code.springboot.cruddemo.entity.Employee;
import com.love2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
   private EmployeeService employeeService;
   public EmployeeRestController(EmployeeService employeeService){
       this.employeeService = employeeService;
   }
   @GetMapping("/employees")
    public List<Employee> findAll(){
        return  employeeService.findAll();

   }
   @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
       Employee employee = employeeService.findById(employeeId);
       if(employee==null){
           throw  new RuntimeException("Employee id not found : "+ employeeId);
       }
       return employee;
   }
   @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
       theEmployee.setId(0);
       Employee dbEmployee = employeeService.save(theEmployee);
       return dbEmployee;
   }
   @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
       Employee dbEmployee = employeeService.save(theEmployee);
       return dbEmployee;
   }
   @DeleteMapping("/employees")
    public String deleteEmployee(@PathVariable int employeeId){
       Employee theEmployee = employeeService.findById(employeeId);
       if(theEmployee==null){
           throw new RuntimeException("Employee id is not found : " + employeeId);

       }
       employeeService.deleteById(employeeId);
       return "Deleted employee id : " +employeeId;

   }
}
