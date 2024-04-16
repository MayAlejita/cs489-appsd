package edu.miu.cs.cs489.dentalsurgeryapp.service.impl;

import edu.miu.cs.cs489.dentalsurgeryapp.dto.address.AddressResponse2;
import edu.miu.cs.cs489.dentalsurgeryapp.dto.patient.PatientResponse2;
import edu.miu.cs.cs489.dentalsurgeryapp.model.Address;
import edu.miu.cs.cs489.dentalsurgeryapp.repository.AddressRepository;
import edu.miu.cs.cs489.dentalsurgeryapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address addNewAddress(Address newAddress) {
        return addressRepository.save(newAddress);
    }

    @Override
    public Address getAddressByID(Integer addressId) {
        return addressRepository.findById(addressId).orElse(null);
    }

    @Override
    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<AddressResponse2> getAllAddress() {

        return addressRepository.findAll(Sort.by("city"))
                .stream()
                .map(a -> new AddressResponse2(
                        a.getAddressId(),
                        a.getStreet(),
                        a.getCity(),
                        a.getState(),
                        a.getZipCode(),
                        (a.getPatient() != null) ? new PatientResponse2(
                                a.getPatient().getPatientId(),
                                a.getPatient().getFirstName(),
                                a.getPatient().getLastName(),
                                a.getPatient().getDateOfBirth(),
                                a.getPatient().getPhoneNumber(),
                                a.getPatient().getEmail()
                        ) : null
                ))
                .toList();
    }

    @Override
    public void deleteAddressById(Integer addressId) {
        addressRepository.deleteById(addressId);
    }
}
