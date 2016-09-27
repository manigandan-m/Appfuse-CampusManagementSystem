package com.i2i.dao.hibernate;

import com.i2i.dao.RoleDao;
import com.i2i.exception.DatabaseException;
import com.i2i.model.Role;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * This class interacts with hibernate session to save/delete and
 * retrieve Role objects.
 *
 * @author <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 * @author jgarcia (updated to hibernate 4)
 */
@Repository
public class RoleDaoHibernate extends GenericDaoHibernate<Role, Long> implements RoleDao {

    /**
     * Constructor to create a Generics-based version using Role as the entity
     */
    public RoleDaoHibernate() {
        super(Role.class);
    }

    /**
     * {@inheritDoc}
     */
    public Role getRoleByName(String rolename) {
        List roles = getSession().createCriteria(Role.class).add(Restrictions.eq("name", rolename)).list();
        if (roles.isEmpty()) {
            return null;
        } else {
            return (Role) roles.get(0);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void removeRole(String rolename) {
        Object role = getRoleByName(rolename);
        Session session = getSessionFactory().getCurrentSession();
        session.delete(role);
    }
    
    /**
     * Retrieves  the list of roles from the database
     * 
     * @return roles
     *     List of roles
     * @throws DatabaseException
     *     if there is an error in getting the list of roles like HibernateException
     */
    public List<Role> retrieveRoles() throws DatabaseException {
        Session session = getSession();        
        try {
            List<Role> roles = session.createQuery("FROM Role").list();
            if (roles.isEmpty()) {
                throw new DatabaseException("The role list is empty");
            }            
            return roles;              
        } catch (HibernateException e) {            
            throw new DatabaseException("The roles are not viewed. Kindly try again with vaild input data", e);
        } finally {
            session.close();
        }                      
    }
}
