package jialei.com.spitter.demodataaccess.jpa.repository;

import jialei.com.spitter.demodataaccess.domain.SpittleDomain;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Repository
public class MyJpaRepository {

    @PersistenceUnit
    private EntityManagerFactory emf;

    public SpittleDomain findOne(long id) {
        return emf.createEntityManager().find(SpittleDomain.class, id);
    }
}
