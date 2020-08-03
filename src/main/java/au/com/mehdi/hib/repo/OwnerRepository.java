package au.com.mehdi.hib.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import au.com.mehdi.hib.domain.Owner;

@RepositoryRestResource( collectionResourceRel = "owner", path = "owner")
public interface OwnerRepository extends JpaRepository<Owner, Long> {

	List<Owner> findAllByName(String name);

}
