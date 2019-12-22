package jialei.com.spitter.dataaccess.jpa.repository;

import jialei.com.spitter.dataaccess.domain.SpittleDomain;
import jialei.com.spitter.model.Spittle;
import jialei.com.spitter.repository.SpittleRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class MyJpaRepository {

    @PersistenceUnit
    private EntityManagerFactory emf;

    public SpittleDomain findOne(long id) {
        return emf.createEntityManager().find(SpittleDomain.class, id);
    }
}
