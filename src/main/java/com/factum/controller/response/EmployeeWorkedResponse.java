package com.factum.controller.response;

import com.factum.model.Employee;
import com.factum.model.EmployeeWorkedHour;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeWorkedResponse {

    private long id;

    private boolean success;

    public EmployeeWorkedResponse(EmployeeWorkedHour employee){
        this.id = employee.getId();
        this.success = employee.getId() > 0;
    }


}
