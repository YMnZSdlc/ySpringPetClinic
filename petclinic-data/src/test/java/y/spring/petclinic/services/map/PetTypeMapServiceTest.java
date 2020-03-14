package y.spring.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import y.spring.petclinic.model.PetType;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetTypeMapServiceTest {

    PetTypeMapService petTypeMapService;

    final Long petTypeId = 1L;

    @BeforeEach
    void setUp() {
        petTypeMapService = new PetTypeMapService();
        petTypeMapService.save(PetType.builder().id(petTypeId).build());
    }

    @Test
    void findAll() {
        Set<PetType> petTypeAll = petTypeMapService.findAll();

        assertEquals(1, petTypeAll.size());
    }

    @Test
    void findById() {
        PetType petTypeById = petTypeMapService.findById(petTypeId);

        assertEquals(petTypeId, petTypeById.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        PetType petTypeToSave = PetType.builder().id(id).build();
        PetType savedPetType = petTypeMapService.save(petTypeToSave);

        assertEquals(id, savedPetType.getId());
    }

    @Test
    void saveNoId() {
        PetType savedPetType = petTypeMapService.save(PetType.builder().build());

        assertNotNull(savedPetType);
        assertNotNull(savedPetType.getId());
    }

    @Test
    void delete() {
        petTypeMapService.delete(petTypeMapService.findById(petTypeId));

        assertEquals(0,petTypeMapService.findAll().size());
    }

    @Test
    void deleteById() {
        petTypeMapService.deleteById(petTypeId);

        assertEquals(0,petTypeMapService.findAll().size());
    }
}