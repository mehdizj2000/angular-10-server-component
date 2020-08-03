package au.com.mehdi.hib.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Worker extends BaseEntity {

	private String firstName;

	private String lastName;

	private String email;

	@ManyToOne
	@JoinColumn(name = "fk_factory")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Factory factory;

}
