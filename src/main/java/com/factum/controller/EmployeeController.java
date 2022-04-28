package com.factum.controller;

import com.factum.controller.request.EmployeeRequest;
import com.factum.controller.request.JobRequest;
import com.factum.controller.response.EmployeeResponse;
import com.factum.controller.response.JobResponse;
import com.factum.model.Employee;
import com.factum.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    @GetMapping("/")
    public Iterable<Employee> listEmployees(){
        return employeeService.getAllEmployees();
    }

    /**
     * Contrato 1.1
     ***/
    @PostMapping("/create")
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest employeeRequest){
        return this.employeeService.createEmployee(employeeRequest);
    }


    /**
     * Contrato 1.3
     ***/
    @PostMapping("/job")
    public JobResponse groupByEmployee(@RequestBody JobRequest request){
        return this.employeeService.getAllEmployeesByJobId(request);
    }


}
