package edu.miu.cs.cs489.dentalsurgeryapp.service;

import edu.miu.cs.cs489.dentalsurgeryapp.model.Address;

import java.util.List;

public interface AddressService {
    Address addNewAddress(Address newAddress);
    Address getAddressByID(Integer addressId);
    Address updateAddress(Address address);
    List<Address> getAllAddress();
    void deleteAddressById(Integer addressId);
}
