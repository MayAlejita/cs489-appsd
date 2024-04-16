package edu.miu.cs.cs489.dentalsurgeryapp.controller;

import edu.miu.cs.cs489.dentalsurgeryapp.dto.response.AppointmentResponse;
import edu.miu.cs.cs489.dentalsurgeryapp.exception.AppointmentNotFoundException;
import edu.miu.cs.cs489.dentalsurgeryapp.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/appointment")
public class AppointmentController {
    private AppointmentService appointmentService;
    public AppointmentController(AppointmentService appointmentService) {this.appointmentService = appointmentService;}

    @GetMapping("/list")
    public ResponseEntity<List<AppointmentResponse>> listPatients() {
        return ResponseEntity.ok(appointmentService.getAllAppointment());
    }

    @GetMapping("/get/{appointmentId}")
    public ResponseEntity<AppointmentResponse> getAppointmentById(@PathVariable Integer appointmentId) throws AppointmentNotFoundException {
        return ResponseEntity.ok(appointmentService.getAppointmentById(appointmentId));
    }
}
