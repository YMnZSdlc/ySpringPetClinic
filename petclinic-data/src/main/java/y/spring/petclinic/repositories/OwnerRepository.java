package y.spring.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import y.spring.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
