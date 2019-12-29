package jialei.com.spitter.demodataaccess.basehibernate.repository;

import jialei.com.spitter.demodataaccess.domain.SpittleDomain;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 *
 * @author jialei
 * @version : HibernateRepository.java, v 0.1 2019年11月28日 10:14 上午 jialei Exp $
 */
@Repository
@EnableTransactionManagement
public class BaseHibernateRepository {
    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession(){
//        return sessionFactory.getCurrentSession();
        return sessionFactory.openSession();
    }

    @Transactional
    public List<SpittleDomain> finAll(){
        return (List<SpittleDomain>)currentSession().createCriteria(SpittleDomain.class).list();
    }

    @Transactional
    public SpittleDomain findOne(long id){
        return (SpittleDomain)currentSession().get(SpittleDomain.class, id);
    }
}