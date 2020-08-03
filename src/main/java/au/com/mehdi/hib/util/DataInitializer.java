package au.com.mehdi.hib.util;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import au.com.mehdi.hib.domain.Account;
import au.com.mehdi.hib.domain.Owner;
import au.com.mehdi.hib.repo.OwnerRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
class DataInitializer implements ApplicationRunner {

    private OwnerRepository ownerRepo;

    public DataInitializer(OwnerRepository ownerRepo) {

	this.ownerRepo = ownerRepo;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

	Owner owner1 = new Owner("yahya", "Yahya Title", LocalDate.of(1985, Month.MARCH, 21));
	owner1.addAccount(new Account("admin", LocalDate.now()));
	owner1.addAccount(new Account("sdhasjkgh", LocalDate.now()));
	owner1.addAccount(new Account("sdhasjkghsd", LocalDate.now()));

	Owner owner2 = new Owner("mehdi", "Mehdi Title", LocalDate.of(1985, Month.MARCH, 21));
	owner2.addAccount(new Account("shoufer", LocalDate.now()));
	owner2.addAccount(new Account("ssdfhoufer", LocalDate.now()));

	Owner owner3 = new Owner("reza", "Reza Title", LocalDate.of(1985, Month.MARCH, 21));
	owner3.addAccount(new Account("user", LocalDate.now()));
	owner3.addAccount(new Account("sgsfgtfhtj", LocalDate.now()));

	ownerRepo.saveAll(Arrays.asList(owner1, owner2, owner3));

	ownerRepo.findAll().forEach(note -> log.info(note.toString()));
//
//	accountRepo.findAll().forEach(account -> log.info(account.toString()));

    }
}