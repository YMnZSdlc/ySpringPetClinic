package y.spring.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import y.spring.petclinic.model.Visit;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VisitMapServiceTest {

    VisitMapService visitMapService;

    final Long visitId = 1L;

    @BeforeEach
    void setUp() {
        visitMapService = new VisitMapService();
        visitMapService.save(Visit.builder().id(visitId).build());
    }

    @Test
    void findAll() {
        Set<Visit> visitAll = visitMapService.findAll();

        assertEquals(1,visitAll.size());
    }

    @Test
    void findById() {
        Visit visitById = visitMapService.findById(visitId);

        assertEquals(visitId, visitById.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Visit visitToSave = Visit.builder().id(id).build();
        Visit savedVisit = visitMapService.save(visitToSave);

        assertEquals(id,savedVisit.getId());
    }

    @Test
    void saveNoId() {
        Visit savedVisit = visitMapService.save(Visit.builder().build());

        assertNull(savedVisit);
        assertNull(savedVisit.getId());
    }

    @Test
    void delete() {
        visitMapService.delete(visitMapService.findById(visitId));

        assertEquals(0,visitMapService.findAll().size());
    }

    @Test
    void deleteById() {
        visitMapService.deleteById(visitId);

        assertEquals(0,visitMapService.findAll().size());
    }
}