package com.factum.controller;


import com.factum.controller.request.EmployeeHourRequest;
import com.factum.controller.request.EmployeeWorkedRequest;
import com.factum.service.EmployeeWorkedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee-worked")
public class EmployeeWorkedController {

    private EmployeeWorkedService employeeWorkedService;

    @Autowired
    public EmployeeWorkedController(EmployeeWorkedService employeeWorkedService){
        this.employeeWorkedService = employeeWorkedService;
    }

    @PostMapping("/")
    public ResponseEntity addWorkedHours(@RequestBody EmployeeWorkedRequest request){
        return employeeWorkedService.createWorkedData(request);
    }

    @PostMapping("/total-worked")
    public ResponseEntity sumAllWorkedHours(@RequestBody EmployeeHourRequest request){
        return employeeWorkedService.getAllWorkedHours(request);
    }


}
