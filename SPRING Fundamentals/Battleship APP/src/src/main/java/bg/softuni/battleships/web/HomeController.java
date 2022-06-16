package bg.softuni.battleships.web;

import bg.softuni.battleships.model.Ship;
import bg.softuni.battleships.model.dto.AttackDTO;
import bg.softuni.battleships.model.dto.ShipAddDTO;
import bg.softuni.battleships.service.ShipService;
import bg.softuni.battleships.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {
    private ShipService shipService;
    private CurrentUser currentUser;

    @Autowired
    public HomeController(ShipService shipService,
                          CurrentUser currentUser) {
        this.shipService = shipService;
        this.currentUser = currentUser;
    }

    @GetMapping("/home")
    public String getHome(Model model) {
        if (!model.containsAttribute("ourShip")) {
            List<ShipAddDTO> ourShip = this.shipService.getAllOwnedShips(currentUser.getUsername());
            model.addAttribute("ourShip", ourShip);
        }
        if (!model.containsAttribute("theirShip")) {
            List<ShipAddDTO> theirShip = this.shipService.getAllTheirShips(currentUser.getUsername());
            model.addAttribute("theirShip", theirShip);
        }
        if (!model.containsAttribute("attack")) {
            model.addAttribute("attack", new AttackDTO());
        }
        return "home";
    }

    @PostMapping("/home")
    public String attack(@RequestParam(name = "attacker") String attacker1,
                         @RequestParam(name = "defender") String defender1,
                         RedirectAttributes redirectAttributes) {

        List<ShipAddDTO> allShip = this.shipService.takeDamageAndGetAll(attacker1, defender1);
        redirectAttributes.addFlashAttribute("allShip", allShip);
        return "redirect:/home";
    }
}
