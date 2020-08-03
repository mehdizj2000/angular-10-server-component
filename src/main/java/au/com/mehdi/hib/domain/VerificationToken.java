package au.com.mehdi.hib.domain;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import lombok.Data;

@Data
@Entity
public class VerificationToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String token;

	@Column(nullable = false)
	private LocalTime expiration;

	@OneToOne
	@JoinColumn(name = "fk_user_id")
	private UserInfo userInfo;

	@PrePersist
	public void prePersist() {
		expiration = LocalTime.now().minusMinutes(30);
	}

}
