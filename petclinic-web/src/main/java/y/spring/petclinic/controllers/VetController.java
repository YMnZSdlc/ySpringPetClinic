package y.spring.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import y.spring.petclinic.model.Vet;
import y.spring.petclinic.services.VetService;

import java.util.Comparator;
import java.util.stream.Collectors;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll()
                .stream()
                .sorted(Comparator.comparing(Vet::getId))
                .collect(Collectors.toList()));
        return "vets/index";
    }
}
