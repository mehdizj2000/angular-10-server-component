package au.com.mehdi.hib.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import au.com.mehdi.hib.domain.Owner;
import au.com.mehdi.hib.repo.OwnerRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class OwnerController {

    private OwnerRepository repository;

    public OwnerController(OwnerRepository repository) {
	super();
	this.repository = repository;
    }

    @GetMapping("/owner")
    public List<Owner> owners() {
	log.debug("ksdghfsdgfjsdgfjsdfjdghh");
	return repository.findAll();

    }

    @PostMapping("/owner")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOwner(@RequestBody Owner owner) {
	repository.save(owner);	
    }

    @GetMapping("/owner/{id}/account")
    public Owner ownerDetails(@PathVariable Long id) {
	return repository.findById(id).orElse(new Owner());
    }

}