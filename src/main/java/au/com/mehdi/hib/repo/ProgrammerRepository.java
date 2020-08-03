package au.com.mehdi.hib.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mehdi.hib.domain.Programmer;

public interface ProgrammerRepository extends JpaRepository<Programmer, Long> {

}
