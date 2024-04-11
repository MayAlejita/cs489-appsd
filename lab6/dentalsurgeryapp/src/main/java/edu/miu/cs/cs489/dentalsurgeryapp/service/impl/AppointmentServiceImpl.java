package edu.miu.cs.cs489.dentalsurgeryapp.service.impl;

import edu.miu.cs.cs489.dentalsurgeryapp.model.Appointment;
import edu.miu.cs.cs489.dentalsurgeryapp.repository.AppointmentRepository;
import edu.miu.cs.cs489.dentalsurgeryapp.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment addNewAppointment(Appointment newAppointment) {
        return appointmentRepository.save(newAppointment);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointment() {
        return appointmentRepository.findAll();
    }

    @Override
    public void deleteAppointmentById(Integer appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
