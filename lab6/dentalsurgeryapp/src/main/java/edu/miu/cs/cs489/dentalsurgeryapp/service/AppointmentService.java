package edu.miu.cs.cs489.dentalsurgeryapp.service;

import edu.miu.cs.cs489.dentalsurgeryapp.model.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment addNewAppointment(Appointment newAppointment);
    Appointment getAppointmentById(Integer appointmentId);
    Appointment updateAppointment(Appointment appointment);
    List<Appointment> getAllAppointment();
    void deleteAppointmentById(Integer appointmentId);
}
