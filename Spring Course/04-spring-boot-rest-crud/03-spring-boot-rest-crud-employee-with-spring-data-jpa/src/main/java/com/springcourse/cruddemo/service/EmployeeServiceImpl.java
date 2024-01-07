package com.springcourse.cruddemo.service;

import com.springcourse.cruddemo.DAO.EmployeeRepository;
import com.springcourse.cruddemo.entity.Employee;
import com.springcourse.cruddemo.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    //inject EmployeeDAO using Constructor injection
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    
    @Override
    public Employee findById(int theId) {

        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();
        }
        else{
            throw new EmployeeNotFoundException("Could not find Employee with ID : " + theId);
        }
        return theEmployee;
    }

    //@Transactional -- we can remove this annotation since JPA Repository takes care of it
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }
    
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
