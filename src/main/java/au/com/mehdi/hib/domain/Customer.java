package au.com.mehdi.hib.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private Integer age;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Address> addresses;

	public void addAddress(Address address) {
		if (address != null) {
			if (addresses == null) {
				addresses = new ArrayList<Address>();
			}
			address.setCustomer(this);
			this.addresses.add(address);
		}
	}

}
