package com.factum.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class EmployeWorkedHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

//    @OneToOne
//    @Column(name = "employee_id")
//    private Employee employee;

    @Column(name = "worked_hours")
    private int hours;

    @Column(name = "worked_date")
    private Date workDate;

}
