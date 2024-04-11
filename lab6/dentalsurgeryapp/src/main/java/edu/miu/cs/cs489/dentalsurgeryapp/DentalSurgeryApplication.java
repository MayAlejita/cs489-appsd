package edu.miu.cs.cs489.dentalsurgeryapp;

import edu.miu.cs.cs489.dentalsurgeryapp.model.*;
import edu.miu.cs.cs489.dentalsurgeryapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class DentalSurgeryApplication implements CommandLineRunner {

	@Autowired
	private SurgeryService surgeryService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private DentistService dentistService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private AppointmentService appointmentService;

	public static void main(String[] args) {
		SpringApplication.run(DentalSurgeryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var appointment = registerAppointment();
		var appointment1 = registerAppointment1();
		var appointment2 = registerAppointment2();
		var appointment3 = registerAppointment3();
		var appointment4 = registerAppointment4();
		var address = registerAddress();
		registerDentist(List.of(appointment, appointment1));
		registerDentist1(List.of(appointment, appointment2));
		registerDentist2(List.of(appointment3, appointment4));
		registerPatient(address, List.of(appointment));
		registerPatient1(address, List.of(appointment1, appointment3));
		registerPatient2(address, List.of(appointment, appointment2));
		registerPatient3(address, List.of(appointment4));
		registerSurgery(address, List.of(appointment, appointment1, appointment3));
		registerSurgery1(address, List.of(appointment, appointment2));
		registerSurgery2(address, List.of(appointment4));

		List<Patient> patients = getAllPatients();
		patients.stream().forEach(System.out::println);

		List<Appointment> appointments = getAllAppointments();
		appointments.stream().forEach(System.out::println);
	}

	private List<Patient> getAllPatients(){
		return patientService.getAllPatient();
	}

	private List<Appointment> getAllAppointments() {
		return appointmentService.getAllAppointment();
	}

	private Appointment registerAppointment() {
		Appointment appointment = new Appointment(null, LocalDateTime.of(2024,04,10,10,0));
		return appointmentService.addNewAppointment(appointment);
	}

	private Appointment registerAppointment1() {
		Appointment appointment = new Appointment(null, LocalDateTime.of(2024,04,10,12,0));
		return appointmentService.addNewAppointment(appointment);
	}

	private Appointment registerAppointment2() {
		Appointment appointment = new Appointment(null, LocalDateTime.of(2024,04,12,14,0));
		return appointmentService.addNewAppointment(appointment);
	}

	private Appointment registerAppointment3() {
		Appointment appointment = new Appointment(null, LocalDateTime.of(2024,04,12,16,30));
		return appointmentService.addNewAppointment(appointment);
	}

	private Appointment registerAppointment4() {
		Appointment appointment = new Appointment(null, LocalDateTime.of(2024,04,13,18,0));
		return appointmentService.addNewAppointment(appointment);
	}

	private void registerSurgery(Address address, List<Appointment> appointments) {
		Surgery surgery = new Surgery(null,"ADS Fairfield","654-908-7656", address, appointments);
		surgeryService.addNewSurgery(surgery);
	}

	private void registerSurgery1(Address address, List<Appointment> appointments) {
		Surgery surgery = new Surgery(null,"ADS DesMoines","454-908-7656", appointments);
		surgeryService.addNewSurgery(surgery);
	}

	private void registerSurgery2(Address address, List<Appointment> appointments) {
		Surgery surgery = new Surgery(null,"ADS Warren","754-908-7656", appointments);
		surgeryService.addNewSurgery(surgery);
	}


	private void registerPatient(Address address, List<Appointment> appointments) {
		Patient patient = new Patient(null,"Gillian", "White", LocalDate.of(1990,10,10),
				"654-998-9807","gill@email.com", address, appointments);
		patientService.addNewPatient(patient);
	}

	private void registerPatient1(Address address, List<Appointment> appointments) {
		Patient patient = new Patient(null,"Jill", "Bell", LocalDate.of(1987,05,31),
				"311-998-9807","jill@email.com", appointments);
		patientService.addNewPatient(patient);
	}

	private void registerPatient2(Address address, List<Appointment> appointments) {
		Patient patient = new Patient(null,"Ian", "MacKay", LocalDate.of(1962,11,03),
				"555-998-9807","ian@email.com", appointments);
		patientService.addNewPatient(patient);
	}

	private void registerPatient3(Address address, List<Appointment> appointments) {
		Patient patient = new Patient(null,"John", "Walker", LocalDate.of(2000,02,10),
				"654-998-1234","john@email.com", appointments);
		patientService.addNewPatient(patient);
	}

	private Address registerAddress() {
		Address address = new Address(null, "1000 N 4th", "Fairfield","IA","52557");
		return addressService.addNewAddress(address);
	}

	private Dentist registerDentist(List<Appointment> appointments) {
		Dentist dentist = new Dentist(null,"Tony","Smith","641-456-3456","tony@email.com",
				appointments);
		return dentistService.addNewDentist(dentist);
	}

	private Dentist registerDentist1(List<Appointment> appointments) {
		Dentist dentist = new Dentist(null,"Helen","Pearson","641-456-3457","helen@email.com",
				appointments);
		return dentistService.addNewDentist(dentist);
	}

	private Dentist registerDentist2(List<Appointment> appointments) {
		Dentist dentist = new Dentist(null,"Robin","Plevin","741-456-3456","robin@email.com",
				appointments);
		return dentistService.addNewDentist(dentist);
	}
}
