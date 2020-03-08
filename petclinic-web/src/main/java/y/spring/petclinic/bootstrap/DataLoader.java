package y.spring.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import y.spring.petclinic.model.*;
import y.spring.petclinic.services.*;

import java.sql.SQLOutput;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialityService specialityService,
                      VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        loadOwnerAndPetAndPetTypeAndVisit();
        loadVetAndSpeciality();
    }

    private void loadOwnerAndPetAndPetTypeAndVisit() {
        PetType dog = new PetType();
        dog.setName("Pies");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Kot");
        PetType savedCat = petTypeService.save(cat);

        PetType pig = new PetType();
        pig.setName("świnia");
        PetType savedPig = petTypeService.save(pig);

        System.out.println("Loaded Pet Types...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Andrzej");
        owner1.setLastName("Andrzejewski");
        owner1.setAddress("Aleksandrowska 1");
        owner1.setCity("Aleksandrów Łódzki");
        owner1.setTelephone("111 111 111");
        Pet petDog = new Pet();
        petDog.setName("Pieseł");
        petDog.setPetType(savedDog);
        petDog.setOwner(owner1);
        petDog.setBirthDate(LocalDate.of(2011, 1, 11));
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bartek");
        owner2.setLastName("Bartkowski");
        owner2.setAddress("Biała 2");
        owner2.setCity("Bełchatów");
        owner2.setTelephone("222 222 222");
        Pet petCat = new Pet();
        petCat.setName("Koteł");
        petCat.setPetType(savedCat);
        petCat.setOwner(owner2);
        petCat.setBirthDate(LocalDate.now());
        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Celina");
        owner3.setLastName("Celińska");
        owner3.setAddress("Czerwona 2");
        owner3.setCity("Cedynia");
        owner3.setTelephone("333 333 333");
        Pet petPig = new Pet();
        petPig.setName("Świneł");
        petPig.setPetType(savedPig);
        petPig.setOwner(owner3);
        petPig.setBirthDate(LocalDate.of(2018, 8, 10));
        ownerService.save(owner3);

        System.out.println("Loaded Owners...");

        Visit pigVisit = new Visit();
        pigVisit.setPet(petPig);
        pigVisit.setDate(LocalDate.now());
        pigVisit.setDescription("Kastracja");
        visitService.save(pigVisit);

        System.out.println("Add visit to owner3");
    }

    private void loadVetAndSpeciality() {
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiologia");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Chirurgia");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentystyka");
        Speciality savedDentistry = specialityService.save(dentistry);

        System.out.println("Loaded Vets Specialities...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Daniel");
        vet1.setLastName("Danielski");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Edward");
        vet2.setLastName("Edwardzki");
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Filip");
        vet3.setLastName("Filipowski");
        vet3.getSpecialities().add(savedSurgery);
        vetService.save(vet3);

        System.out.println("Loaded Vets...");
    }
}
