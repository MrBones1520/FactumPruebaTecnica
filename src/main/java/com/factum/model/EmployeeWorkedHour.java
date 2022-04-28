package com.factum.model;

import com.factum.controller.request.EmployeeWorkedRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Data
@NoArgsConstructor
public class EmployeeWorkedHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "worked_hours")
    private int hours;

    @Column(name = "worked_date")
    private Date workDate;

    public EmployeeWorkedHour(EmployeeWorkedRequest request){
        this.hours = request.getWorked_hours();
        this.workDate = request.getWorked_date();
    }

}
