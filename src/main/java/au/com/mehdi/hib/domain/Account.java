package au.com.mehdi.hib.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Account {

    public Account() {
	super();
	// TODO Auto-generated constructor stub
    }

    public Account(String accountType, LocalDate dateCreated, Owner owner) {
	this(null, accountType, dateCreated, owner);
    }

    public Account(String accountType, LocalDate dateCreated) {
	this(null, accountType, dateCreated, null);
    }

    public Account(Long id, String accountType, LocalDate dateCreated, Owner owner) {
	super();
	this.id = id;
	this.accountType = accountType;
	this.dateCreated = dateCreated;
	this.owner = owner;
    }

    public Account(Long id) {
	this(id, null, null, null);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String accountType;

    private LocalDate dateCreated;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Owner owner;
}
