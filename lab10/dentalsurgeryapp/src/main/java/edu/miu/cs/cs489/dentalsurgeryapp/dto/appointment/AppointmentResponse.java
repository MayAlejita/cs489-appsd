package edu.miu.cs.cs489.dentalsurgeryapp.dto.appointment;

import edu.miu.cs.cs489.dentalsurgeryapp.dto.patient.PatientResponse2;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record AppointmentResponse(
        Integer appointmentId,
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime dateAppointment,
        PatientResponse2 patient,
        DentistResponse dentist,
        SurgeryResponse surgery) {
}
