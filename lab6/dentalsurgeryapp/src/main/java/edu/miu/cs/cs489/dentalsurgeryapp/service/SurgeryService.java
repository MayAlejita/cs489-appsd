package edu.miu.cs.cs489.dentalsurgeryapp.service;

import edu.miu.cs.cs489.dentalsurgeryapp.model.Surgery;

import java.util.List;

public interface SurgeryService {
    Surgery addNewSurgery(Surgery newSurgery);
    Surgery getSurgeryById(Integer surgeryId);
    Surgery updateSurgery(Surgery surgery);
    List<Surgery> getAllSurgery();
    void deleteSurgeryById(Integer surgeryId);
}
