package au.com.mehdi.hib.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mehdi.hib.domain.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
