package CounterStriker.core;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.common.OutputMessages;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.lang.reflect.Field;

public class ControllerImpl implements Controller {
    private GunRepository guns;
    private PlayerRepository players;
    private Field field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
       Gun gun;

       switch (type) {
           case "Pistol":
               gun = new Pistol(name, bulletsCount);
               break;
           case "Rifle":
               gun = new Rifle(name, bulletsCount);
               break;
           default:
               throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN_TYPE);
       }

       guns.add(gun);
       return String.format(OutputMessages.SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Player player;

        Gun gunToAdd = guns.findByName(gunName);

        if (gunToAdd == null) {
            throw new NullPointerException(ExceptionMessages.GUN_CANNOT_BE_FOUND);
        }

        switch (type) {
            case "Terrorist":
                player = new Terrorist(username, health, armor, gunToAdd);
                break;
            case "CounterTerrorist":
                player = new CounterTerrorist(username, health, armor, gunToAdd);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }

        players.add(player);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        return null;
    }

    @Override
    public String report() {
       return players.toString();
    }
}
