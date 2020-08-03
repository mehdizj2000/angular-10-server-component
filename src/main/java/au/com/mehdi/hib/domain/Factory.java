package au.com.mehdi.hib.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Factory extends BaseEntity {

	private String description;

	private String type;

	private Integer numOfWorkers;

	@OneToMany(mappedBy = "factory", cascade = CascadeType.ALL)
	private Set<Worker> workers;
	
	public void addWorker(Worker worker) {
		if(workers == null)
			workers = new HashSet<Worker>();
		worker.setFactory(this);
		workers.add(worker);
	}
}
