package com.i2i.dao;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Address;

import java.util.List;

public interface AddressDao extends GenericDao<Address, Long> {

    void insertAddress(Address address) throws DatabaseException;
    
    Address retrieveAddressById(int id) throws DatabaseException;

    void editAddress(Address address) throws DatabaseException;

    List<Address> retrieveAddresses() throws DatabaseException;
}
