package bg.softuni.battleships.web;

import bg.softuni.battleships.model.dto.ShipAddDTO;
import bg.softuni.battleships.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AddShipController {
    private ShipService shipService;

    @Autowired
    public AddShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("/add-ship")
    public String addShip(Model model) {
        if (!model.containsAttribute("addShip")) {
            model.addAttribute("addShip", new ShipAddDTO());
        }
        return "ship-add";
    }

    @PostMapping("/add-ship")
    public String addShip(@Valid @ModelAttribute("addShip") ShipAddDTO addShip,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addShip", addShip);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addShip", bindingResult);
            return "redirect:/add-ship";
        }

        this.shipService.addShip(addShip);
        return "redirect:/home";
    }
}
