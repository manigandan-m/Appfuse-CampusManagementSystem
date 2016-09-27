package com.i2i.dao.hibernate;

import com.i2i.model.Address;
import com.i2i.dao.AddressDao;
import com.i2i.exception.DatabaseException;

import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDaoHibernate extends GenericDaoHibernate<Address, Long> implements AddressDao {
    /**
     * Constructor to create a Generics-based version using Student as the entity
     */
    public AddressDaoHibernate() {
        super(Address.class);
    }
    
    /**
     * Saves the address model object to the database by passing it
     * 
     * @param address
     *     address to be inserted for a user
     * @throws DatabaseException
     */
    public void insertAddress(Address address) throws DatabaseException {
        Session session = getSession();
        try {
            session.save(address);           
        } catch (HibernateException e) {
            throw new DatabaseException("Entered address is not added. ..", e);
        }                                                                         
    }
	
    
	/**
     * Edits the address details by accessing the database, passing the address.
     * 
     * @param address
     *     address whose details have to be edited
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public void editAddress(Address address) throws DatabaseException {
	    Session session = getSession();
        try {
            session.update(address);
        } catch (HibernateException e) {
            throw new DatabaseException("Please check the data you have given..." , e);  
       }
    }
    
    /**
     * Retrieves the address object by passing id of the address
     * 
     * @param id
     *     id of the address whose record has to be viewed
     * @return address
     *    address of the corresponding id
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public Address retrieveAddressById(int id) throws DatabaseException {
         Session session = getSession();
         try {
             Address address = (Address)session.get(Address.class, id); 
             return address;
         } catch (HibernateException e) {
             throw new DatabaseException("Check address ID, please enter different id", e);  
         } 
    }
    
    /**
     * Retrieves  the list of address from the database
     * 
     * @return addresses
     *     list of address
     * @throws DataBaseException
     *     if there is an error in getting the object like NullPointerException,
     *     NumberFormatException, HibernateException
     */
    public List<Address> retrieveAddresses() throws DatabaseException {
        Session session = getSession();
        try {
            List<Address> addresses = session.createQuery("FROM Address").list(); 
            return addresses;
        } catch (HibernateException e) {
            throw new DatabaseException("Data is not present at the moment...", e); 
        }		
    }
}