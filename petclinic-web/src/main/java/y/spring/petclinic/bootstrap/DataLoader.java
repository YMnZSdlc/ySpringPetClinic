package y.spring.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import y.spring.petclinic.model.Owner;
import y.spring.petclinic.model.PetType;
import y.spring.petclinic.model.Vet;
import y.spring.petclinic.services.OwnerService;
import y.spring.petclinic.services.PetTypeService;
import y.spring.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

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
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bartek");
        owner2.setLastName("Bartkowski");
        owner2.setAddress("Biała 2");
        owner2.setCity("Bełchatów");
        owner2.setTelephone("222 222 222");
        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Celina");
        owner3.setLastName("Celińska");
        owner3.setAddress("Czerwona 2");
        owner3.setCity("Cedynia");
        owner3.setTelephone("333 333 333");
        ownerService.save(owner3);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Daniel");
        vet1.setLastName("Danielski");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Edward");
        vet2.setLastName("Edwardzki");
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Filip");
        vet3.setLastName("Filipowski");
        vetService.save(vet3);

        System.out.println("Loaded Vets...");
    }
}
