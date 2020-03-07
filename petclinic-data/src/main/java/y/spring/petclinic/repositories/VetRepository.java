package y.spring.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import y.spring.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
