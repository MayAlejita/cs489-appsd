package edu.miu.cs.cs489.dentalsurgeryapp.service;

import edu.miu.cs.cs489.dentalsurgeryapp.dto.response.AppointmentResponse;
import edu.miu.cs.cs489.dentalsurgeryapp.exception.AppointmentNotFoundException;
import edu.miu.cs.cs489.dentalsurgeryapp.model.Appointment;

import java.util.List;

public interface AppointmentService {
    AppointmentResponse addNewAppointment(Appointment newAppointment);
    AppointmentResponse getAppointmentById(Integer appointmentId) throws AppointmentNotFoundException;
    Appointment updateAppointment(Appointment appointment);
    List<AppointmentResponse> getAllAppointment();
    void deleteAppointmentById(Integer appointmentId);
}
