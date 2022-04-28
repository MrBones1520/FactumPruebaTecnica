package com.factum.controller.request;

import lombok.Data;

import java.sql.Date;


@Data
public class EmployeeHourRequest {

    private long employee_id;

    private Date start_date;

    private Date end_date;

}
