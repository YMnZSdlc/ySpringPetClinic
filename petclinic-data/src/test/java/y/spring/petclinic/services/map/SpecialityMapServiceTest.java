package y.spring.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import y.spring.petclinic.model.Speciality;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SpecialityMapServiceTest {

    SpecialityMapService specialityMapService;

    final Long specialityId = 1L;

    @BeforeEach
    void setUp() {
        specialityMapService = new SpecialityMapService();
        specialityMapService.save(Speciality.builder().id(specialityId).build());
    }

    @Test
    void findAll() {
        Set<Speciality> specialityAll = specialityMapService.findAll();

        assertEquals(1, specialityAll.size());
    }

    @Test
    void findById() {
        Speciality specialityById = specialityMapService.findById(specialityId);

        assertEquals(specialityId,specialityById.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Speciality specialityToSave = Speciality.builder().id(id).build();
        Speciality savedSpeciality = specialityMapService.save(specialityToSave);

        assertEquals(id, savedSpeciality.getId());
    }

    @Test
    void saveNoId() {
        Speciality savedSpeciality = specialityMapService.save(Speciality.builder().build());

        assertNotNull(savedSpeciality);
        assertNotNull(savedSpeciality.getId());
    }

    @Test
    void delete() {
        specialityMapService.delete(specialityMapService.findById(specialityId));

        assertEquals(0,specialityMapService.findAll().size());
    }

    @Test
    void deleteById() {
        specialityMapService.deleteById(specialityId);

        assertEquals(0,specialityMapService.findAll().size());
    }
}