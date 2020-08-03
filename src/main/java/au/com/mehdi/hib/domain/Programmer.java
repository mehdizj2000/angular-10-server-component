package au.com.mehdi.hib.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Programmer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;

	@ManyToMany(mappedBy = "programmers", cascade = CascadeType.ALL)
	private Set<Project> projects;
	
	public void addProject(Project project) {
		if(projects == null) {
			projects = new HashSet<Project>();
		}
		
		project.addProgrammer(this);
		projects.add(project);
	}

}
