package com.factum.controller.request;

import com.factum.model.EmployeeWorkedHour;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.sql.Date;

@Data
public class EmployeeWorkedRequest {

    @Min(1)
    private long employee_id;

    @Min(1)
    @Max(20)
    private int worked_hours;

    private Date worked_date;

    public EmployeeWorkedHour getEntity(){
        return new EmployeeWorkedHour(this);
    }

}
