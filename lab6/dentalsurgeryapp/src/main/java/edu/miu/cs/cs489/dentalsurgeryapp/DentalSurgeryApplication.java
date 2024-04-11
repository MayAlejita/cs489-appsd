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
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(DentalSurgeryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var address1 = registerAddress("1000 N 4th", "Fairfield","IA","52557");
		var address2 = registerAddress("Rd 654", "Warren","MI","52557");
		var address3 = registerAddress("1702 Ruk", "DesMoines","IA","53221");
		var address4 = registerAddress("St 46", "Otummwa","IA","51555");
		var dentist1 = registerDentist();
		var dentist2 = registerDentist1();
		var dentist3 = registerDentist2();
		var patient1 = registerPatient(address1);
		var patient2 = registerPatient1(address2);
		var patient3 = registerPatient2(address3);
		var patient4 = registerPatient3(address4);
		var surgery1 = registerSurgery(address3);
		var surgery2 = registerSurgery1(address2);
		var surgery3 = registerSurgery2(address1);

		registerAppointment1(dentist1, patient1, surgery3);
		registerAppointment2(dentist1, patient2, surgery3);
		registerAppointment3(dentist2, patient3, surgery1);
		registerAppointment4(dentist2, patient3, surgery1);
		registerAppointment5(dentist3, patient2, surgery3);
		registerAppointment6(dentist3, patient4, surgery2);

		getAllAppointments();

		System.out.println("--------------------------------------");
		System.out.println("-----------Patient List --------------");
		List<Patient> patients = getAllPatients();
		for (Patient p: patients){
			System.out.println("Name: " + p.getFirstName()+ " " + p.getLastName() + " " + p.getAddress());
		}

		int id = 1;
		getDentistById(1);

		registerUser();

	}

	private void registerUser() {
		Role role = new OfficeManager("Anna");
		roleService.addNewRole(role);
		Role role1 = new OfficeMember("John");
		roleService.addNewRole(role1);
		User user = new User(null, "Joe", List.of(role, role1));
		userService.addNewUser(user);
	}

	private void getDentistById(Integer dentistId){
		Dentist dentist = dentistService.getDentistById(dentistId);
		if(dentist != null){
			System.out.println(dentist.getFirstName());
		}
	}

	private List<Patient> getAllPatients(){
		return patientService.getAllPatient();
	}

	private void getAllAppointments() {
		List<Appointment> appoints = appointmentService.getAllAppointment();
		for (Appointment ap : appoints){
			System.out.println(ap.getAppointmentId()+ " " + ap.getDateAppointment());
		}
	}

	private Appointment registerAppointment1(Dentist dentist, Patient patient, Surgery surgery) {
		Appointment appointment = new Appointment(null, LocalDateTime.of(2024,04,10,10,0),
				patient, dentist, surgery);
		return appointmentService.addNewAppointment(appointment);
	}

	private Appointment registerAppointment2(Dentist dentist, Patient patient, Surgery surgery) {
		Appointment appointment = new Appointment(null, LocalDateTime.of(2024,04,10,12,0),
				patient, dentist, surgery);
		return appointmentService.addNewAppointment(appointment);
	}

	private Appointment registerAppointment3(Dentist dentist, Patient patient, Surgery surgery) {
		Appointment appointment = new Appointment(null, LocalDateTime.of(2024,04,10,10,0),
				patient, dentist, surgery);
		return appointmentService.addNewAppointment(appointment);
	}

	private Appointment registerAppointment4(Dentist dentist, Patient patient, Surgery surgery) {
		Appointment appointment = new Appointment(null, LocalDateTime.of(2024,04,12,14,0),
				patient, dentist, surgery);
		return appointmentService.addNewAppointment(appointment);
	}

	private Appointment registerAppointment5(Dentist dentist, Patient patient, Surgery surgery) {
		Appointment appointment = new Appointment(null, LocalDateTime.of(2024,04,12,16,30),
				patient, dentist, surgery);
		return appointmentService.addNewAppointment(appointment);
	}

	private Appointment registerAppointment6(Dentist dentist, Patient patient, Surgery surgery) {
		Appointment appointment = new Appointment(null, LocalDateTime.of(2024,04,13,18,0),
				patient, dentist, surgery);
		return appointmentService.addNewAppointment(appointment);
	}

	private Surgery registerSurgery(Address address) {
		Surgery surgery = new Surgery(null,"ADS Fairfield","654-908-7656", address);
		return surgeryService.addNewSurgery(surgery);
	}

	private Surgery registerSurgery1(Address address) {
		Surgery surgery = new Surgery(null,"ADS DesMoines","454-908-7656", address);
		return surgeryService.addNewSurgery(surgery);
	}

	private Surgery registerSurgery2(Address address) {
		Surgery surgery = new Surgery(null,"ADS Warren","754-908-7656", address);
		return surgeryService.addNewSurgery(surgery);
	}


	private Patient registerPatient(Address address) {
		Patient patient = new Patient(null,"Gillian", "White", LocalDate.of(1990,10,10),
				"654-998-9807","gill@email.com", address);
		return patientService.addNewPatient(patient);
	}

	private Patient registerPatient1(Address address) {
		Patient patient = new Patient(null,"Jill", "Bell", LocalDate.of(1987,05,31),
				"311-998-9807","jill@email.com", address);
		return patientService.addNewPatient(patient);
	}

	private Patient registerPatient2(Address address) {
		Patient patient = new Patient(null,"Ian", "MacKay", LocalDate.of(1962,11,03),
				"555-998-9807","ian@email.com", address);
		return patientService.addNewPatient(patient);
	}

	private Patient registerPatient3(Address address) {
		Patient patient = new Patient(null,"John", "Walker", LocalDate.of(2000,02,10),
				"654-998-1234","john@email.com", address);
		return patientService.addNewPatient(patient);
	}

	private Address registerAddress(String street, String city, String state, String zip) {
		Address address = new Address(null, street, city,state,zip);
		return addressService.addNewAddress(address);
	}

	private Dentist registerDentist() {
		Dentist dentist = new Dentist(null,"Tony","Smith","641-456-3456","tony@email.com");
		return dentistService.addNewDentist(dentist);
	}

	private Dentist registerDentist1() {
		Dentist dentist = new Dentist(null,"Helen","Pearson","641-456-3457","helen@email.com");
		return dentistService.addNewDentist(dentist);
	}

	private Dentist registerDentist2() {
		Dentist dentist = new Dentist(null,"Robin","Plevin","741-456-3456","robin@email.com");
		return dentistService.addNewDentist(dentist);
	}
}
