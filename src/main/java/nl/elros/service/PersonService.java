package nl.elros.service;

import nl.elros.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {
        logger.info("Find person by id: " + id);
        return Person.builder()
                .id(counter.incrementAndGet())
                .firstName("John")
                .lastName("Doe")
                .address("Somewhere over the rainbow")
                .gender("MALE")
                .build();
    }

    public List<Person> findAll() {
        logger.info("Find all");
        Person person1 = Person.builder()
                .id(counter.incrementAndGet())
                .firstName("Jane")
                .lastName("Doe")
                .address("Somewhere over the rainbow")
                .gender("FEMALE")
                .build();

        Person person2 = Person.builder()
                .id(counter.incrementAndGet())
                .firstName("Jane")
                .lastName("Doe")
                .address("Somewhere over the rainbow")
                .gender("FEMALE")
                .build();


        return List.of(person1, person2);
    }

    public Person create(Person person) {
        logger.info("Create person: " + person);
        person.setId(counter.incrementAndGet());
        return person;
    }

    public Person update(Person person) {
        logger.info("Update person: " + person);
        return person;
    }

    public void delete(String id) {
        logger.info("Delete person: " + id);
    }
}
