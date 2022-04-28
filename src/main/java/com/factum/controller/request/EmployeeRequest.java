package com.factum.controller.request;

import com.factum.model.Employee;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class EmployeeRequest {

    private Long gender_id;

    private Long job_id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull
    private String last_name;

    @NotBlank(message = "Birthdate is mandatory")
    private Date birthdate;


    public Employee getEmployee(){
        return new Employee(this);
    }

}
