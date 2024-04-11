package edu.miu.cs.cs489.dentalsurgeryapp.service;

import edu.miu.cs.cs489.dentalsurgeryapp.model.Dentist;

import java.util.List;

public interface DentistService {
    Dentist addNewDentist(Dentist newDentist);
    Dentist updateDentist(Dentist dentist);
    List<Dentist> getAllDentist();
    void deleteDentistById(Integer dentistId);
}
