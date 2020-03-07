package y.spring.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import y.spring.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
