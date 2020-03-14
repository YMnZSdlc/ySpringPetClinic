package y.spring.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import y.spring.petclinic.model.Speciality;
import y.spring.petclinic.model.Vet;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VetMapServiceTest {

    VetMapService vetMapService;

    final Long vetId = 1L;

    @BeforeEach
    void setUp() {
        vetMapService = new VetMapService(new SpecialityMapService());
        vetMapService.save(Vet.builder().id(vetId).build());
    }

    @Test
    void findAll() {
        Set<Vet> vetAll = vetMapService.findAll();

        assertEquals(1, vetAll.size());
    }

    @Test
    void findById() {
        Vet vetById = vetMapService.findById(vetId);

        assertEquals(vetId,vetById.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Vet vetToSave = Vet.builder().id(id).build();
        Vet savedVet = vetMapService.save(vetToSave);

        assertEquals(id,savedVet.getId());
    }

    @Test
    void saveNoId() {
        Vet savedVet = vetMapService.save(Vet.builder().build());

        assertNull(savedVet);
        assertNull(savedVet.getId());
    }

    @Test
    void delete() {
        vetMapService.delete(vetMapService.findById(vetId));

        assertEquals(0,vetMapService.findAll().size());
    }

    @Test
    void deleteById() {
        vetMapService.deleteById(vetId);

        assertEquals(0,vetMapService.findAll().size());
    }
}