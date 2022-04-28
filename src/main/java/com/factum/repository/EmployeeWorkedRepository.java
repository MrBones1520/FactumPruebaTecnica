package com.factum.repository;

import com.factum.model.EmployeeWorkedHour;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface EmployeeWorkedRepository extends CrudRepository<EmployeeWorkedHour, Long> {

    @Query(value = "from EmployeeWorkedHour t where workDate BETWEEN :startDate AND :endDate")
    Iterable<EmployeeWorkedHour> getAllBetweenDates(@Param("startDate") Date startDate, @Param("endDate")Date endDate);


}
