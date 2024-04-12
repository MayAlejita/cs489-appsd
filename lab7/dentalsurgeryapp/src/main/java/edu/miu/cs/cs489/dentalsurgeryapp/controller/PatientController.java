package edu.miu.cs.cs489.dentalsurgeryapp.controller;

import edu.miu.cs.cs489.dentalsurgeryapp.dto.patient.PatientRequest;
import edu.miu.cs.cs489.dentalsurgeryapp.dto.patient.PatientResponse;
import edu.miu.cs.cs489.dentalsurgeryapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.dentalsurgeryapp.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/patient")
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<PatientResponse>> listPatients() {
        return ResponseEntity.ok(patientService.getAllPatient());
    }

    @GetMapping("/get/{patientId}")
    public ResponseEntity<PatientResponse> getPatientById(@PathVariable Integer patientId) throws PatientNotFoundException {
        return ResponseEntity.ok(patientService.getPatientById(patientId));
    }

    @PostMapping("/register")
    public ResponseEntity<PatientResponse> registerPatient(@RequestBody PatientRequest patient) {
        return new ResponseEntity<>(patientService.addNewPatient(patient), HttpStatus.CREATED);
    }

    @PutMapping("/update/{patientId}")
    public ResponseEntity<PatientResponse> updatePatient(@PathVariable Integer patientId, @RequestBody PatientRequest patient)
            throws PatientNotFoundException{
        return new ResponseEntity<>(patientService.updatePatient(patientId, patient), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable Integer patientId) {
        patientService.deletePatientById(patientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search/{searchString}")
    public ResponseEntity<List<PatientResponse>> searchPatient(@PathVariable String searchString) {
        return ResponseEntity.ok(patientService.searchPatient(searchString));
    }
}
