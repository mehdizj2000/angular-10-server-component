package au.com.mehdi.hib.domain;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Insurance {
	
	private String providerName;
	private Double copay;

}
