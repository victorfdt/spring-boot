package nl.elros.service;

import nl.elros.exception.ResourceNotFoundException;
import nl.elros.model.Person;
import nl.elros.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonService.class);
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Person findById(Long id) {
        log.debug("Finding person by id={}", id);
        return getExistingPerson(id);
    }

    @Transactional(readOnly = true)
    public List<Person> findAll() {
        log.debug("Finding all persons");
        return repository.findAll();
    }

    @Transactional
    public Person create(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person must not be null");
        }
        log.debug("Creating person");
        return repository.save(person);
    }

    @Transactional
    public Person update(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person must not be null");
        }
        if (person.getId() == null) {
            throw new IllegalArgumentException("Person id must not be null for update");
        }

        log.debug("Updating person id={}", person.getId());
        getExistingPerson(person.getId());

        return repository.save(person);
    }

    @Transactional
    public void delete(Long id) {
        log.debug("Deleting person id={}", id);
        getExistingPerson(id);
        repository.deleteById(id);
    }

    private Person getExistingPerson(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person with id " + id + " not found"));
    }
}
