package com.i2i.service.impl;

import com.i2i.dao.AddressDao;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Address;
import com.i2i.service.AddressManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("addressManager")
public class AddressManagerImpl extends GenericManagerImpl<Address, Long> implements AddressManager {
	AddressDao addressDao;

    @Autowired
    public AddressManagerImpl(AddressDao addressDao) {
        super(addressDao);
        this.addressDao = addressDao;
    }

    /**
     * <p>
     * Calls the AddressDao class method to add the standard to the database by passing the Address class object
     * </p>
     * 
     * @param address
     *     address is the particulars of a place where a person lives
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void addAddress(Address address) throws DatabaseException {                 
        addressDao.insertAddress(address);                     
    }
	
    /**
     * <p>
     * Invokes the addressDao method to edit the address details by passing the Address class object
     * </p>
     * 
     * @param address
     *     address is the particulars of a place where a person lives
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public void editAddress(Address address) throws DatabaseException {
        addressDao.editAddress(address);
    }
    
    /**
     * <p>
     * Invokes the AddressDao class method to get the list of all of addresss
     * </p>
     *  
     * @return 
     *     list of addresses returned
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public List<Address> getAddresses() throws DatabaseException {
    	return addressDao.retrieveAddresses();
    }
    
    /**
     * <p>
     * It returns the object of Address class by passing the id of address
     * Invokes the AddressDao method to get the address object
     * </p>
     * 
     * @param addressId
     *     ID of address passed as argument to get the address
     * @return
     *     address of a person
     * @throws DatabaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException
     */
    public Address getAddressById(int addressId) throws DatabaseException {
        return (addressDao.retrieveAddressById(addressId));        
    }
}
