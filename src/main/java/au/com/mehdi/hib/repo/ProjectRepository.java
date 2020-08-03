package au.com.mehdi.hib.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mehdi.hib.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
