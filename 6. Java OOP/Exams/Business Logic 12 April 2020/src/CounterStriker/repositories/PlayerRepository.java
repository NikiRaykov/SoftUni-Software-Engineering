package CounterStriker.repositories;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerRepository implements Repository<Player> {
    private List<Player> players;

    public PlayerRepository() {
        this.players = new ArrayList<>();
    }

    @Override
    public Collection<Player> getModels() {
        return players;
    }

    @Override
    public void add(Player player) {
        if (player == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_PLAYER_REPOSITORY);
        }

        this.players.add(player);
    }

    @Override
    public boolean remove(Player player) {
        return this.players.remove(player);
    }

    @Override
    public Player findByName(String name) {
        return this.players.stream().filter(p -> p.getUsername().equals(name))
                .findFirst()
                .orElse(null);
    }


}
