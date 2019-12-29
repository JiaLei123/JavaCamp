package jialei.com.spitter.demodataaccess.springdata.repository;


import jialei.com.spitter.demodataaccess.domain.SpittleDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataRepository extends JpaRepository<SpittleDomain, Long> {
    List<SpittleDomain> readSpittleDomainByMessageContains(String message);
}
