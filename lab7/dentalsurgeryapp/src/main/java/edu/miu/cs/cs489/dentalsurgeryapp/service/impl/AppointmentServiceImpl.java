package edu.miu.cs.cs489.dentalsurgeryapp.service.impl;

import edu.miu.cs.cs489.dentalsurgeryapp.dto.appointment.AppointmentResponse;
import edu.miu.cs.cs489.dentalsurgeryapp.dto.appointment.DentistResponse;
import edu.miu.cs.cs489.dentalsurgeryapp.dto.appointment.SurgeryResponse;
import edu.miu.cs.cs489.dentalsurgeryapp.dto.patient.PatientResponse2;
import edu.miu.cs.cs489.dentalsurgeryapp.exception.AppointmentNotFoundException;
import edu.miu.cs.cs489.dentalsurgeryapp.model.Appointment;
import edu.miu.cs.cs489.dentalsurgeryapp.repository.AppointmentRepository;
import edu.miu.cs.cs489.dentalsurgeryapp.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {this.appointmentRepository = appointmentRepository;}

    @Override
    public AppointmentResponse addNewAppointment(Appointment newAppointment) {
        Appointment appointment = appointmentRepository.save(newAppointment);
        return new AppointmentResponse(
                appointment.getAppointmentId(),
                appointment.getDateAppointment(),
                (appointment.getPatient() != null) ? new PatientResponse2(
                        appointment.getPatient().getPatientId(),
                        appointment.getPatient().getFirstName(),
                        appointment.getPatient().getLastName(),
                        appointment.getPatient().getDateOfBirth(),
                        appointment.getPatient().getPhoneNumber(),
                        appointment.getPatient().getEmail()
                ): null,
                (appointment.getDentist() != null) ? new DentistResponse(
                        appointment.getDentist().getDentistId(),
                        appointment.getDentist().getFirstName(),
                        appointment.getDentist().getLastName(),
                        appointment.getDentist().getPhoneNumber(),
                        appointment.getDentist().getEmail()
                ): null,
                (appointment.getSurgery() != null) ? new SurgeryResponse(
                        appointment.getSurgery().getSurgeryId(),
                        appointment.getSurgery().getName(),
                        appointment.getSurgery().getPhoneNumber()
                ): null
        );
    }

    @Override
    public AppointmentResponse getAppointmentById(Integer appointmentId) throws AppointmentNotFoundException {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElse(null);
        if(appointment == null){
            throw new AppointmentNotFoundException(String.format("Error: Appointment with Id, %d, is not found", appointmentId));
        }
        return new AppointmentResponse(
                appointment.getAppointmentId(),
                appointment.getDateAppointment(),
                (appointment.getPatient() != null) ? new PatientResponse2(
                        appointment.getPatient().getPatientId(),
                        appointment.getPatient().getFirstName(),
                        appointment.getPatient().getLastName(),
                        appointment.getPatient().getDateOfBirth(),
                        appointment.getPatient().getPhoneNumber(),
                        appointment.getPatient().getEmail()
                ): null,
                (appointment.getDentist() != null) ? new DentistResponse(
                        appointment.getDentist().getDentistId(),
                        appointment.getDentist().getFirstName(),
                        appointment.getDentist().getLastName(),
                        appointment.getDentist().getPhoneNumber(),
                        appointment.getDentist().getEmail()
                ): null,
                (appointment.getSurgery() != null) ? new SurgeryResponse(
                        appointment.getSurgery().getSurgeryId(),
                        appointment.getSurgery().getName(),
                        appointment.getSurgery().getPhoneNumber()
                ): null
        );
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<AppointmentResponse> getAllAppointment() {

        return appointmentRepository.findAll()
                .stream()
                .map(a -> new AppointmentResponse(
                        a.getAppointmentId(),
                        a.getDateAppointment(),
                        (a.getPatient() != null) ? new PatientResponse2(
                                a.getPatient().getPatientId(),
                                a.getPatient().getFirstName(),
                                a.getPatient().getLastName(),
                                a.getPatient().getDateOfBirth(),
                                a.getPatient().getPhoneNumber(),
                                a.getPatient().getEmail()
                        ): null,
                        (a.getDentist() != null) ? new DentistResponse(
                                a.getDentist().getDentistId(),
                                a.getDentist().getFirstName(),
                                a.getDentist().getLastName(),
                                a.getDentist().getPhoneNumber(),
                                a.getDentist().getEmail()
                        ): null,
                        (a.getSurgery() != null) ? new SurgeryResponse(
                                a.getSurgery().getSurgeryId(),
                                a.getSurgery().getName(),
                                a.getSurgery().getPhoneNumber()
                        ): null
                )).toList();
    }

    @Override
    public void deleteAppointmentById(Integer appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
