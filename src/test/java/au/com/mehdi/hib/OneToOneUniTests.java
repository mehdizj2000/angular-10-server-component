package au.com.mehdi.hib;

import java.time.LocalDate;
import java.time.Month;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import au.com.mehdi.hib.domain.Account;
import au.com.mehdi.hib.domain.Owner;
import au.com.mehdi.hib.repo.OwnerRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
class OneToOneUniTests {

    @Autowired
    private OwnerRepository ownerRepo;

    @Test
    public void insertBiDataTest() {

	Owner owner = new Owner("kasham", "North Street", LocalDate.of(1985, Month.FEBRUARY, 25));

	Account account = new Account();
	account.setAccountType("admin");
	account.setDateCreated(LocalDate.now());

	owner.addAccount(account);

	Owner savedOwner = ownerRepo.save(owner);
	String accountStr = ToStringBuilder.reflectionToString(savedOwner, ToStringStyle.JSON_STYLE);

	log.info(accountStr);

//	Owner owner2 = new Owner();
//	owner2.setId(5l);
//	Account foundAccount = accountRepo.findByOwner(owner2);
//
//	accountStr = ToStringBuilder.reflectionToString(foundAccount, ToStringStyle.JSON_STYLE);
//
//	log.info(accountStr);

    }

}
