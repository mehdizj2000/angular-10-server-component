package au.com.mehdi.hib.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mehdi.hib.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
