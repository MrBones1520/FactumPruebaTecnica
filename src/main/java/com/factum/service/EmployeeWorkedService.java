package com.factum.service;


import com.factum.controller.request.EmployeeHourRequest;
import com.factum.controller.request.EmployeePaymentsResponse;
import com.factum.controller.request.EmployeeWorkedRequest;
import com.factum.controller.response.EmployeeHourResponse;
import com.factum.controller.response.EmployeeWorkedResponse;
import com.factum.model.EmployeeWorkedHour;
import com.factum.repository.EmployeeWorkedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeWorkedService {

    private EmployeeService employeeService;

    private EmployeeWorkedRepository employeeWorkedRepository;

    private final static EmployeeWorkedResponse ERROR_RESPONSE = new EmployeeWorkedResponse(0, false);

    private final static EmployeeHourResponse ERROR_WORKED_RESPONSE = new EmployeeHourResponse(0, false);

    private final static EmployeePaymentsResponse ERROR_PAYMENTS_RESPONSE = new EmployeePaymentsResponse();

    @Autowired
    public EmployeeWorkedService(
        EmployeeService employeeService,
        EmployeeWorkedRepository employeeWorkedRepository
    ){
        this.employeeService = employeeService;
        this.employeeWorkedRepository = employeeWorkedRepository;
    }

    public boolean checkDataWorked(EmployeeWorkedRequest request){
        return (
            employeeService.existById(request.getEmployee_id()) &&
            request.getWorked_hours() < 20 &&
            this.employeeService.existById(request.getEmployee_id())
        );
    }

    public ResponseEntity createWorkedData(EmployeeWorkedRequest request){
        if(!this.checkDataWorked(request))
            return ResponseEntity.status(400).body(ERROR_RESPONSE);

        EmployeeWorkedHour ewh = request.getEntity();
        ewh.setEmployee(this.employeeService.get(request.getEmployee_id()));
        ewh = this.employeeWorkedRepository.save(ewh);

        return ResponseEntity.ok(new EmployeeWorkedResponse(ewh));
    }

    public ResponseEntity getAllWorkedHours(EmployeeHourRequest request) {
        if(!this.employeeService.existById(request.getEmployee_id()))
            return ResponseEntity.status(405).body(ERROR_WORKED_RESPONSE);

        Iterable<EmployeeWorkedHour> iterable = this.employeeWorkedRepository.getAllBetweenDates(
                request.getStart_date(), request.getEnd_date()
        );

        return ResponseEntity.ok(new EmployeeHourResponse(iterable));
    }

}
