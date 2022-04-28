package com.factum.model;

import com.factum.controller.request.EmployeeRequest;
import com.factum.controller.response.EmployeeResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
public class Employee {


    public Employee(EmployeeRequest request) {
        this.name = request.getName();
        this.lastName = request.getLast_name();
        this.birthdate = request.getBirthdate();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    //@PrimaryKeyJoinColumn
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String lastName;

    private Date birthdate;

    @OneToOne
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    private Job job;

    @OneToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    private Gender gender;


    public EmployeeResponse getResponse(){
        return new EmployeeResponse(this);
    }

}
