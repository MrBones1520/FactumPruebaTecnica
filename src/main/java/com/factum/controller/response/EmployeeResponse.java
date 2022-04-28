package com.factum.controller.response;

import com.factum.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeResponse {

    private long id;

    private boolean success;

    public EmployeeResponse(Employee employee){
        this.id = employee.getId();
        this.success = employee.getId() > 0;
    }


}
