package y.spring.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import y.spring.petclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final Long ownerId = 1L;
    final String ownerLastName = "Kowalski";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName(ownerLastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerAll = ownerMapService.findAll();
        assertEquals(1, ownerAll.size());
    }

    @Test
    void findById() {
        Owner ownerById = ownerMapService.findById(ownerId);
        assertEquals(ownerId, ownerById.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner ownerToSave = Owner.builder().id(2L).build();
        Owner savedOwner = ownerMapService.save(ownerToSave);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner ownerToSave = ownerMapService.save(Owner.builder().build());
        assertNotNull(ownerToSave);
        assertNotNull(ownerToSave.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner ownerByLastName = ownerMapService.findByLastName(ownerLastName);
        assertNotNull(ownerByLastName);
        assertEquals(ownerId,ownerByLastName.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner ownerByLastName = ownerMapService.findByLastName("nic");
        assertNull(ownerByLastName);
    }
}