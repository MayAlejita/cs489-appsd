package edu.miu.cs.cs489.dentalsurgeryapp.service.impl;

import edu.miu.cs.cs489.dentalsurgeryapp.model.Dentist;
import edu.miu.cs.cs489.dentalsurgeryapp.repository.DentistRepository;
import edu.miu.cs.cs489.dentalsurgeryapp.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {
    @Autowired
    private DentistRepository dentistRepository;

    @Override
    public Dentist addNewDentist(Dentist newDentist) {
        return dentistRepository.save(newDentist);
    }

    @Override
    public Dentist updateDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public List<Dentist> getAllDentist() {
        return dentistRepository.findAll();
    }

    @Override
    public void deleteDentistById(Integer dentistId) {
        dentistRepository.deleteById(dentistId);
    }
}
