package y.spring.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import y.spring.petclinic.model.Owner;
import y.spring.petclinic.services.OwnerService;

import java.util.Comparator;
import java.util.stream.Collectors;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll()
                .stream()
                .sorted(Comparator.comparing(Owner::getId))
                .collect(Collectors.toList()));
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(){
        return "notimpl";
    }

}
