package com.factum.repository;

import com.factum.model.Employee;
import com.factum.model.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Employee findByNameAndLastName(String name, String lastName);

    Iterable<Employee> findAllByJob(Job job);

}
