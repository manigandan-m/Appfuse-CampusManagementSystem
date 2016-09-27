package com.i2i.service;

import com.i2i.model.Address;
import com.i2i.exception.DatabaseException;

import java.util.List;

public interface AddressManager extends GenericManager<Address, Long> {
    
    void addAddress(Address address) throws DatabaseException;

    Address getAddressById(int id) throws DatabaseException;

    void editAddress(Address address) throws DatabaseException;

    List<Address> getAddresses() throws DatabaseException;
}