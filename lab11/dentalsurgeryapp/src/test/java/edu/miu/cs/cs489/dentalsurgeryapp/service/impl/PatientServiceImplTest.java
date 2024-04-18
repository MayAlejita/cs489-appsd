package edu.miu.cs.cs489.dentalsurgeryapp.service.impl;

import edu.miu.cs.cs489.dentalsurgeryapp.DentalsurgeryappApplicationTests;
import edu.miu.cs.cs489.dentalsurgeryapp.dto.response.PatientResponse;
import edu.miu.cs.cs489.dentalsurgeryapp.exception.PatientNotFoundException;
import edu.miu.cs.cs489.dentalsurgeryapp.service.PatientService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PatientServiceImplTest extends DentalsurgeryappApplicationTests {
    @Autowired
    PatientService patientService;

    @Before
    public void setUp() {
        logger.info("PatientServiceImplTest started");
    }

    @After
    public void tearDown() {
        logger.info("PatientServiceImplTest completed");
    }

    @Test
    public void testGetPatientById() throws PatientNotFoundException {
        Integer patientId = 1;
        PatientResponse patient = patientService.getPatientById(patientId);

        Assert.assertNotNull("Failure: expected patient to be not null", patient);
        Assert.assertEquals("Failure: expected bookId to match", patientId, patient.patientId());
        logger.info("Patient data: " + patient);
    }

    @Test
    public void testGetPatientByIdForInvalidId() throws PatientNotFoundException {
        Integer patientId = Integer.MAX_VALUE;

        PatientNotFoundException exception = Assert.assertThrows(PatientNotFoundException.class, () -> {
            patientService.getPatientById(patientId);
        });
        Assert.assertEquals(String.format("Error: Patient with Id, %d, is not found", patientId), exception.getMessage());
    }
}
