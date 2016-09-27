package com.i2i.dao;

import java.util.List;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Role;

/**
 * Role Data Access Object (DAO) interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface RoleDao extends GenericDao<Role, Long> {
    /**
     * Gets role information based on rolename
     * @param rolename the rolename
     * @return populated role object
     */
    Role getRoleByName(String rolename);

    /**
     * Removes a role from the database by name
     * @param rolename the role's rolename
     */
    void removeRole(String rolename);
    
    /**
     * Retrieves  the list of roles from the database
     * 
     * @return roles
     *     List of roles
     * @throws DatabaseException
     *     if there is an error in getting the list of roles like HibernateException
     */
    public List<Role> retrieveRoles() throws DatabaseException; 
}
