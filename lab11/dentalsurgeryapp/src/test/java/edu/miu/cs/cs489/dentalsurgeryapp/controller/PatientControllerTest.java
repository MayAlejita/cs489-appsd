package edu.miu.cs.cs489.dentalsurgeryapp.controller;

import edu.miu.cs.cs489.dentalsurgeryapp.dto.response.AddressResponse;
import edu.miu.cs.cs489.dentalsurgeryapp.dto.response.PatientResponse;
import edu.miu.cs.cs489.dentalsurgeryapp.service.PatientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PatientController.class)
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PatientService patientService;

    @Before
    public void setUp() {
        List<PatientResponse> patientList = List.of(new PatientResponse(1, "John", "Doe", LocalDate.of(1990,9,9),
                "546-098-0000", "john@email.com", new AddressResponse(1,"1000 Nth","Fairfield","IA","52557")));
        Mockito.when(patientService.getAllPatient()).thenReturn(patientList);
    }

    @Test
    public void testListPatients() throws Exception {
        mockMvc.perform(get("/adsweb/api/v1/patient/list"))
                .andExpect(status().isOk());
    }
}
