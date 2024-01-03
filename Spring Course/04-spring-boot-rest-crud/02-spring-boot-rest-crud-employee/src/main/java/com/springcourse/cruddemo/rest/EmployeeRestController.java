package com.springcourse.cruddemo.rest;

import com.springcourse.cruddemo.entity.Employee;
import com.springcourse.cruddemo.exceptions.EmployeeNotFoundException;
import com.springcourse.cruddemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //set up EmployeeDAO
    private EmployeeService employeeService;

    //use constructor injection
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //expose endpoint "/employees" to return the list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //create an endpoint "/employees/{employeeId}" too return the employee by Id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null){
            throw new EmployeeNotFoundException("The Employee with Id: " + employeeId + "is not found!");
        }
            return theEmployee;
    }

    //Add an employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        //set the employeeId to 0 ... just in case they pass an ID
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    //Update Employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null){
            throw new EmployeeNotFoundException("The Employee with Id: " + employeeId + "is not found!");
        }
        employeeService.deleteById(employeeId);
        return "Employee with Id : " + employeeId + " deleted!";
    }
}
