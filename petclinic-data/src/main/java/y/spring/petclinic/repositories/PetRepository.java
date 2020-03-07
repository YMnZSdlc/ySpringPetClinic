package y.spring.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import y.spring.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
