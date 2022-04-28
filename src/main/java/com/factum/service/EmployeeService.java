package com.factum.service;

import com.factum.controller.request.EmployeeRequest;
import com.factum.controller.request.JobRequest;
import com.factum.controller.response.EmployeeResponse;
import com.factum.controller.response.JobResponse;
import com.factum.model.Employee;
import com.factum.repository.EmployeeRepository;
import com.factum.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EmployeeService {

    private static final EmployeeResponse ERROR_EMPLOYEE = new EmployeeResponse(0, false);

    private EmployeeRepository employeeRepository;

    private GenderRepository genderRepository;

    private JobService jobService;

    @Autowired
    public EmployeeService(
        EmployeeRepository employeeRepository,
        GenderRepository genderRepository,
        JobService jobService
    ){
        this.employeeRepository = employeeRepository;
        this.genderRepository = genderRepository;
        this.jobService = jobService;
    }

    public boolean existById(Long id){
        return this.employeeRepository.existsById(id);
    }

    public Employee get(Long id){
        return this.employeeRepository.findById(id).orElse(new Employee());
    }

    public boolean checkDataEmployee(EmployeeRequest employeeRequest){
        return (
            this.genderRepository.existsById(employeeRequest.getGender_id()) &&
            this.jobService.existsById(employeeRequest.getJob_id()) &&
            Objects.isNull(
                this.employeeRepository.findByNameAndLastName(employeeRequest.getName(), employeeRequest.getLast_name())
            )
        );
    }

    public ResponseEntity<EmployeeResponse> createEmployee(EmployeeRequest employeeRequest){
        if(!this.checkDataEmployee(employeeRequest))
            return ResponseEntity.status(401).body(ERROR_EMPLOYEE);

        Employee employee = employeeRequest.getEmployee();
        employee.setJob(jobService.get(employeeRequest.getJob_id()));
        employee.setGender(genderRepository.findById(employeeRequest.getGender_id()).get());
        employee = employeeRepository.save(employee);

        return ResponseEntity.ok(employee.getResponse());
    }

    public Iterable<Employee> getAllEmployees(){
        return this.employeeRepository.findAll();
    }

    public JobResponse getAllEmployeesByJobId(JobRequest jobRequest){
        Iterable it = null;
        if(this.jobService.existsById(jobRequest.getJob_id())){
            it = this.employeeRepository.findAllByJob(
                this.jobService.get(jobRequest.getJob_id())
            );
        }
        return new JobResponse(it);
    }

}
