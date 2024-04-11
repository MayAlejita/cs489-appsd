package edu.miu.cs.cs489.dentalsurgeryapp.service.impl;

import edu.miu.cs.cs489.dentalsurgeryapp.model.Surgery;
import edu.miu.cs.cs489.dentalsurgeryapp.repository.SurgeryRepository;
import edu.miu.cs.cs489.dentalsurgeryapp.service.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryServiceImpl implements SurgeryService {
    @Autowired
    private SurgeryRepository surgeryRepository;

    @Override
    public Surgery addNewSurgery(Surgery newSurgery) {
        return surgeryRepository.save(newSurgery);
    }

    @Override
    public Surgery getSurgeryById(Integer surgeryId) {
        return surgeryRepository.findById(surgeryId).orElse(null);
    }

    @Override
    public Surgery updateSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    @Override
    public List<Surgery> getAllSurgery() {
        return surgeryRepository.findAll();
    }

    @Override
    public void deleteSurgeryById(Integer surgeryId) {
        surgeryRepository.deleteById(surgeryId);
    }
}
