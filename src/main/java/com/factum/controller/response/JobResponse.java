package com.factum.controller.response;

import com.factum.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class JobResponse {

    private Iterable<Employee> employees;

}
