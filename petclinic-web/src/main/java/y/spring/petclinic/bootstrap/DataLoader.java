package y.spring.petclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import y.spring.petclinic.model.Owner;
import y.spring.petclinic.model.Vet;
import y.spring.petclinic.services.OwnerService;
import y.spring.petclinic.services.VetService;
import y.spring.petclinic.services.map.OwnerServiceMap;
import y.spring.petclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Andrzej");
        owner1.setLastName("Andrzejewski");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Bartek");
        owner2.setLastName("Bartkowski");
        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setId(3L);
        owner3.setFirstName("Celina");
        owner3.setLastName("Celińska");
        ownerService.save(owner3);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Daniel");
        vet1.setLastName("Danielski");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Edward");
        vet2.setLastName("Edwardzki");
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setId(3L);
        vet3.setFirstName("Filip");
        vet3.setLastName("Filipowski");
        vetService.save(vet3);

        System.out.println("Loaded Vets...");


    }
}
