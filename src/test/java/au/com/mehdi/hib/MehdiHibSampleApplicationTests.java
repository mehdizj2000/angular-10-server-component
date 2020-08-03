package au.com.mehdi.hib;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import au.com.mehdi.hib.domain.Address;
import au.com.mehdi.hib.domain.Customer;
import au.com.mehdi.hib.domain.Factory;
import au.com.mehdi.hib.domain.Invoice;
import au.com.mehdi.hib.domain.Order;
import au.com.mehdi.hib.domain.Programmer;
import au.com.mehdi.hib.domain.Project;
import au.com.mehdi.hib.domain.UserInfo;
import au.com.mehdi.hib.domain.VerificationToken;
import au.com.mehdi.hib.domain.Worker;
import au.com.mehdi.hib.repo.AddressRepository;
import au.com.mehdi.hib.repo.CustomerRepository;
import au.com.mehdi.hib.repo.FactoryRepository;
import au.com.mehdi.hib.repo.InvoiceRepository;
import au.com.mehdi.hib.repo.OrderRepository;
import au.com.mehdi.hib.repo.ProgrammerRepository;
import au.com.mehdi.hib.repo.UserInfoRepository;
import au.com.mehdi.hib.repo.VerificationTokenRepository;
import au.com.mehdi.hib.repo.WorkerRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class MehdiHibSampleApplicationTests {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private ProgrammerRepository programmerRepo;

	@Autowired
	private AddressRepository addressRepo;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private InvoiceRepository invoiceRepo;

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private WorkerRepository workerRepo;

	@Autowired
	private FactoryRepository factoryRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void inheritedEntitiesTest() {

		Factory factory = new Factory();
		factory.setDescription("hsfghdgfhdfgdhgfhdgfhg");
		factory.setType("electrinics");
		factory.setNumOfWorkers(8);

		Worker worker01 = new Worker();
		worker01.setEmail("dburns@yahoo.com");
		worker01.setFirstName("dave");
		worker01.setLastName("burns");
		
		factory.addWorker(worker01);
		
		Worker worker02 = new Worker();
		worker02.setEmail("lryan@yahoo.com");
		worker02.setFirstName("leo");
		worker02.setLastName("ryan");
		
		factory.addWorker(worker02);

		Worker worker03 = new Worker();
		worker03.setEmail("mjorshari@yahoo.com");
		worker03.setFirstName("mehdi");
		worker03.setLastName("jorshari");
		
		factory.addWorker(worker03);
		
		
		factoryRepo.save(factory);
		
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>> {}", factory);

	}

	@Test
//	@Transactional
//	@Rollback(false)
	public void unidircetionalRelTest() {

		UserInfo userInfo = new UserInfo();
		userInfo.setEmail("shafal@yahoo.com");
		userInfo.setUserName("ghazanfar");

		UserInfo info = userInfoRepository.save(userInfo);

		VerificationToken token = new VerificationToken();
		token.setToken(UUID.randomUUID().toString());
		token.setUserInfo(info);

		VerificationToken verificationToken = verificationTokenRepository.save(token);

		assertNotNull(verificationToken);

		log.info(">>>>>>>>>>>>>>>>>>>> {}", verificationToken);

		verificationTokenRepository.findById(1L).ifPresent(vt -> {
			verificationTokenRepository.delete(vt);
		});

	}

	@Test
	@Transactional
	@Rollback(false)
	public void projectProgrammerTest() {

		Programmer programmer = new Programmer();
		programmer.setEmail(RandomStringUtils.random(5, true, false) + "@gmail.com");

		Project project = new Project();
		project.setProjectDescription(RandomStringUtils.random(45, true, false));
		project.setProjectName(RandomStringUtils.random(15, true, false));

		programmer.addProject(project);

		Programmer programmer2 = programmerRepo.save(programmer);

		log.info(">>>>>>>>>>>>>>>>>>>>>>>> {}", programmer2);

	}

	@Test
	@Transactional
	@Rollback(false)
	void customerAddressTest() {

		List<Customer> customers = new ArrayList<Customer>();

		for (int i = 0; i < 15; i++) {

			Customer customer = new Customer();
			customer.setAge(40);
			customer.setFirstName(RandomStringUtils.random(5, true, false));
			customer.setLastName(RandomStringUtils.random(8, true, false));
			customer.setEmail(RandomStringUtils.random(5, true, false) + "@gmail.com");
			customer.setPhone(RandomStringUtils.random(10, false, true));

			Address add01 = new Address();
			add01.setAddressLine1("line01");
			add01.setAddressLine2("line02");
			add01.setCountry("Australia");
			add01.setPostCode("2116");
			add01.setState("NSW");
			add01.setTown("Rydalmere");

			customer.addAddress(add01);

			Address add02 = new Address();
			add02.setAddressLine1(RandomStringUtils.random(25, true, true));
			add02.setAddressLine2(RandomStringUtils.random(15, true, true));
			add02.setCountry("Australia");
			add02.setPostCode("2106");
			add02.setState("NSW");
			add02.setTown("Newport");

			customer.addAddress(add02);

			customers.add(customer);

		}

		List<Customer> savedCustomers = customerRepo.saveAll(customers);

		log.info(">>>>>>>>>>>>>>>>>>>>>>>>> {}", savedCustomers);

		addressRepo.findById(4L).ifPresent(add -> {
//			add.getCustomer().getAddresses().remove(add);
//			addressRepo.delete(add);
			add.setAddressLine1("18/15 Regardous Street");
			addressRepo.save(add);
		});

		Address add01 = new Address();
		add01.setAddressLine1("Ghazanvari");
		add01.setAddressLine2("line02");
		add01.setCountry("Australia");
		add01.setPostCode("2086");
		add01.setState("NSW");
		add01.setTown("Brookvale");

		addressRepo.save(add01);

		addressRepo.findById(31L).ifPresent(add -> {
			customerRepo.findById(3L).ifPresent(cust -> {
				cust.addAddress(add);
				customerRepo.save(cust);
			});
		});

		addressRepo.findById(31L).ifPresent(add -> {
			add.setCustomer(null);
			addressRepo.save(add);

			customerRepo.findById(4L).ifPresent(cust -> {
				cust.addAddress(add);
				customerRepo.save(cust);
			});
		});

	}

	@Test
	@Transactional
	@Rollback(false)
	void orderInvoiceTest() {

		List<Order> orders = new ArrayList<Order>();

		for (int i = 0; i < 15; i++) {

			Order order = new Order();
			order.setName(RandomStringUtils.random(5, true, true));

			String strPrice = RandomStringUtils.random(2, false, true) + "." + RandomStringUtils.random(2, false, true);
			order.setPrice(Double.valueOf(strPrice));

			Invoice invoice = new Invoice();
			invoice.setNumber(RandomStringUtils.random(10, false, true));
			invoice.setOrder(order);

			order.setInvoice(invoice);

			orders.add(order);

		}

		List<Order> savedOrds = orderRepository.saveAll(orders);
		log.info("saved orders: {}", savedOrds);

		invoiceRepo.findById(4l).ifPresent(inv -> {
			inv.getOrder().setInvoice(null);
			invoiceRepo.delete(inv);
		});

	}

}
