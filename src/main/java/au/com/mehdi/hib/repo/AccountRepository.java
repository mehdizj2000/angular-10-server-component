package au.com.mehdi.hib.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import au.com.mehdi.hib.domain.Account;
import au.com.mehdi.hib.domain.Owner;

@RepositoryRestResource(collectionResourceRel = "account", path = "account")
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByOwner(Owner id);

}
