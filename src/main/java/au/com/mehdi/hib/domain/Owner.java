package au.com.mehdi.hib.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Owner {

    public Owner() {
	super();
	// TODO Auto-generated constructor stub
    }

    public Owner(String name, String address, LocalDate dateOfBirth) {
	this(null, name, address, dateOfBirth);
    }

    public Owner(Long id) {
	this(id, null, null, null);
    }

    public Owner(Long id, String name, String address, LocalDate dateOfBirth) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
	this.dateOfBirth = dateOfBirth;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String address;

    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Account> accounts;

    public void addAccount(Account account) {
	if (this.accounts == null)
	    this.accounts = new ArrayList<>();
	this.accounts.add(account);
	account.setOwner(this);
    }

    public void removeAccount(Account account) {
	if (this.accounts == null)
	    this.accounts = new ArrayList<>();
	this.accounts.remove(account);
	account.setOwner(null);
    }

}
