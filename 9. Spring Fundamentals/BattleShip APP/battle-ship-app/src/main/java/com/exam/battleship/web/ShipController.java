package com.exam.battleship.web;

import com.exam.battleship.model.entity.dto.AddShipDTO;
import com.exam.battleship.model.entity.service.ShipServiceModel;
import com.exam.battleship.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class ShipController {

    private final ShipService shipService;
    private final ModelMapper modelMapper;

    public ShipController(ShipService shipService, ModelMapper modelMapper) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model){

        if(!model.containsAttribute("addShipDTO")) {
            model.addAttribute("addShipDTO", new AddShipDTO());
        }

        return "ship-add";
    }

    @PostMapping("/add")
    public String confirmAdd(@Valid @ModelAttribute("addShipDTO") AddShipDTO addShipDTO, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addShipDTO", addShipDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addShipDTO",
                    bindingResult);

            return "redirect:add";
        }

        shipService.add(modelMapper.map(addShipDTO, ShipServiceModel.class));

        return "redirect:/";

    }
}
