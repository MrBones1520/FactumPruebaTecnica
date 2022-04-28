package com.factum.service;

import com.factum.controller.request.EmployeeRequest;
import com.factum.controller.response.EmployeeResponse;
import com.factum.model.Employee;
import com.factum.repository.EmployeeRepository;
import com.factum.repository.GenderRepository;
import com.factum.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    private GenderRepository genderRepository;

    private JobRepository jobRepository;

    @Autowired
    public EmployeeService(
        EmployeeRepository employeeRepository,
        GenderRepository genderRepository,
        JobRepository jobRepository
    ){
        this.employeeRepository = employeeRepository;
        this.genderRepository = genderRepository;
        this.jobRepository = jobRepository;
    }

    public boolean checkDataEmployee(EmployeeRequest employeeRequest){
        return (
            this.genderRepository.existsById(employeeRequest.getGender_id()) &&
            this.jobRepository.existsById(employeeRequest.getJob_id()) &&
            Objects.isNull(
                this.employeeRepository.findByNameAndLastName(employeeRequest.getName(), employeeRequest.getLast_name())
            )
        );
    }

    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest){
        Employee employee = employeeRepository.save(
            employeeRequest.getEmployee()
        );

        return new EmployeeResponse(employee);
    }

}
