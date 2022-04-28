package com.factum.controller.response;

import com.factum.model.EmployeeWorkedHour;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeHourResponse {

    private long total_worked_hours;

    private boolean success;

    public EmployeeHourResponse(Iterable<EmployeeWorkedHour> iterable){
        int count = 0;
        int worked_sum = 0;
        for(EmployeeWorkedHour it: iterable){
            count += 1;
            worked_sum += it.getHours();
        }
        this.success = count > 0;
        this.total_worked_hours = worked_sum;
    }

}
