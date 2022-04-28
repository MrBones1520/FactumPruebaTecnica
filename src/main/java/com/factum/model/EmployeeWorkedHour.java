package com.factum.model;

import com.factum.controller.request.EmployeeWorkedRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Data
@Table(indexes = {@Index(name = "mulitIndex2", columnList = "employee_id, worked_date")})
@NoArgsConstructor
public class EmployeeWorkedHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
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
