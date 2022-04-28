package com.factum.controller;

import com.factum.controller.request.EmployeeRequest;
import com.factum.controller.response.EmployeeResponse;
import com.factum.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final EmployeeResponse ERROR_EMPLOYEE = new EmployeeResponse(0, false);

    private EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    /**
     * Contrato 1.1
     ***/
    @PostMapping("/create")
    public ResponseEntity<EmployeeResponse> hello(@RequestBody @Valid EmployeeRequest employeeRequest){
        if(!employeeService.checkDataEmployee(employeeRequest))
            return ResponseEntity.status(400).body(ERROR_EMPLOYEE);
        return ResponseEntity.ok(
            this.employeeService.createEmployee(employeeRequest)
        );
    }

}
