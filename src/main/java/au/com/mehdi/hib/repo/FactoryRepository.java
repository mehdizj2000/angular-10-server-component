package au.com.mehdi.hib.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mehdi.hib.domain.Factory;

public interface FactoryRepository extends JpaRepository<Factory, Long> {

}
