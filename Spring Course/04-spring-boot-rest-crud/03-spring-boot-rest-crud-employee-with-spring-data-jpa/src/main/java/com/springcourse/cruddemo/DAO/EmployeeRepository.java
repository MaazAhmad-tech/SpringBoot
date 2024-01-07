package com.springcourse.cruddemo.DAO;

import com.springcourse.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //thats it ... we don't need to write any code.
}
