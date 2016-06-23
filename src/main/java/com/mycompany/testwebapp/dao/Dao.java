
package com.mycompany.testwebapp.dao;

import com.mycompany.testwebapp.users.User;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author eguseynov
 */


@Transactional
@Repository("daoInterface")
public class Dao implements DaoInterface {
    
    private static final Log log = LogFactory.getLog(Dao.class);
    
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User save(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
        log.info("User saved by id: " + user.getId());
        return user;
    }

    @Override
    public void delete(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Integer id) {
        return (User) sessionFactory.getCurrentSession().getNamedQuery("User.findById").
                setParameter("id", id).uniqueResult();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from User u").list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllWithDetail() {
        return sessionFactory.getCurrentSession().getNamedQuery("User.findAllWithDetail").list();
    }
    
    
    
    
}
    

