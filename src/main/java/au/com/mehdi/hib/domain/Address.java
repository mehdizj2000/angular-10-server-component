package au.com.mehdi.hib.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String addressLine1;
	private String addressLine2;
	private String town;
	private String state;
	private String postCode;
	private String country;

	@ManyToOne
	@JoinColumn(name = "fk_customer_id")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Customer customer;

}
