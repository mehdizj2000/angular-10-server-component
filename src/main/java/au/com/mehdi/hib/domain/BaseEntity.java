package au.com.mehdi.hib.domain;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ZonedDateTime createdTime;

    private ZonedDateTime modifiedTime;

    @PrePersist
    public void prePersist() {
	createdTime = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("UTC"));
    }

}
