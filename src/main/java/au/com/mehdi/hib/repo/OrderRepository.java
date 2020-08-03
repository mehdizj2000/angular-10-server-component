package au.com.mehdi.hib.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mehdi.hib.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
