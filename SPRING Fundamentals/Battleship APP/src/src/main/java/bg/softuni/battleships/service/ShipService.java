package bg.softuni.battleships.service;

import bg.softuni.battleships.model.Category;
import bg.softuni.battleships.model.Ship;
import bg.softuni.battleships.model.User;
import bg.softuni.battleships.model.dto.ShipAddDTO;
import bg.softuni.battleships.repository.CategoryRepository;
import bg.softuni.battleships.repository.ShipRepository;
import bg.softuni.battleships.repository.UserRepository;
import bg.softuni.battleships.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShipService {
    private ShipRepository shipRepository;
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;
    private CurrentUser currentUser;

    @Autowired
    public ShipService(ShipRepository shipRepository,
                       CategoryRepository categoryRepository,
                       UserRepository userRepository,
                       CurrentUser currentUser) {
        this.shipRepository = shipRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    public void addShip(ShipAddDTO addShip) {
        Ship ship = new Ship();
        ship.setName(addShip.getName());
        ship.setHealth(addShip.getHealth());
        ship.setPower(addShip.getPower());
        ship.setCreated(addShip.getCreated());
        Category category = this.categoryRepository.findByName(addShip.getCategory());
        ship.setCategory(category);
        User user = this.userRepository.findByUsername(currentUser.getUsername());
        ship.setUser(user);

        this.shipRepository.save(ship);
    }

    public List<ShipAddDTO> getAllOwnedShips(String username) {
        List<Ship> ships = this.shipRepository.findAllByUserUsername(username);
        List<ShipAddDTO> shipAddDTOs = new ArrayList<>();
        ships.forEach(s -> {
            ShipAddDTO shipAddDTO = new ShipAddDTO();
            shipAddDTO.setName(s.getName());
            shipAddDTO.setHealth(s.getHealth());
            shipAddDTO.setPower(s.getPower());
            shipAddDTOs.add(shipAddDTO);
        });

        return shipAddDTOs;
    }

    public List<ShipAddDTO> getAllTheirShips(String username) {
        List<Ship> ships = this.shipRepository.findAllByUserUsernameNot(username);
        List<ShipAddDTO> shipAddDTOs = new ArrayList<>();
        ships.forEach(s -> {
            ShipAddDTO shipAddDTO = new ShipAddDTO();
            shipAddDTO.setName(s.getName());
            shipAddDTO.setHealth(s.getHealth());
            shipAddDTO.setPower(s.getPower());
            shipAddDTOs.add(shipAddDTO);
        });

        return shipAddDTOs;
    }

    public List<ShipAddDTO> takeDamageAndGetAll(String attacker, String defender) {
        Ship attackerShip = this.shipRepository.findByName(attacker);
        Ship defenderShip = this.shipRepository.findByName(defender);
        defenderShip.setHealth(defenderShip.getHealth() - attackerShip.getPower());
        if (defenderShip.getHealth() <= 0) {
            this.shipRepository.delete(defenderShip);
        } else {
            this.shipRepository.save(defenderShip);
        }
        List<Ship> ships = this.shipRepository.findAll();
        List<ShipAddDTO> shipAddDTOs = new ArrayList<>();
        ships.forEach(s -> {
            ShipAddDTO shipAddDTO = new ShipAddDTO();
            shipAddDTO.setName(s.getName());
            shipAddDTO.setHealth(s.getHealth());
            shipAddDTO.setPower(s.getPower());
            shipAddDTOs.add(shipAddDTO);
        });
        return shipAddDTOs;
    }
}
