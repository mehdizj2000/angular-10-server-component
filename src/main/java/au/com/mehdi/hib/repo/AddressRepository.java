package au.com.mehdi.hib.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mehdi.hib.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
