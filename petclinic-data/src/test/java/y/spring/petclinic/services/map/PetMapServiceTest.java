package y.spring.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import y.spring.petclinic.model.Pet;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetMapServiceTest {

    PetMapService petMapService;

    final Long petId = 1L;

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        petMapService.save(Pet.builder().id(petId).build());
    }

    @Test
    void findAll() {
        Set<Pet> petAll = petMapService.findAll();

        assertEquals(1,petAll.size());
    }

    @Test
    void findById() {
        Pet petById = petMapService.findById(petId);

        assertEquals(petId,petById.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Pet petToSave = Pet.builder().id(id).build();
        Pet savedPet = petMapService.save(petToSave);

        assertEquals(id, savedPet.getId());
    }

    @Test
    void saveNoId() {
        Pet savedPet = petMapService.save(Pet.builder().build());

        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());
    }

    @Test
    void delete() {
        petMapService.delete(petMapService.findById(petId));

        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void deleteById() {
        petMapService.deleteById(petId);

        assertEquals(0,petMapService.findAll().size());
    }
}