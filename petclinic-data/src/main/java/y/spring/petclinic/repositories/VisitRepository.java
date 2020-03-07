package y.spring.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import y.spring.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
