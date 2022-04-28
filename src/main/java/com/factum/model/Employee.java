package com.factum.model;

import com.factum.controller.request.EmployeeRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Employee {

    public Employee(EmployeeRequest request){
        this.name = request.getName();
        this.lastName = request.getLast_name();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String lastName;


    private Date birthdate;

//    @OneToOne
//    @JoinColumn(name = "job_id")
//    private Job job;
//
//    @OneToOne
//    @JoinColumn(name = "gender_id")
//    private Gender gender;


}
