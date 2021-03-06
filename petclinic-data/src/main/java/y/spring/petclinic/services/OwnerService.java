package y.spring.petclinic.services;

import org.springframework.data.jpa.repository.Query;
import y.spring.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
