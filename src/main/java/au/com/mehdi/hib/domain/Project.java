package au.com.mehdi.hib.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String projectName;

	private String projectDescription;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "project_programmer", joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "programmer_id", referencedColumnName = "id"))
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<Programmer> programmers;
	
	public void addProgrammer(Programmer program) {
		if(programmers == null) {
			programmers = new HashSet<Programmer>();
		}
		programmers.add(program);
	}

}
