package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.roster =  new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }

    public void addPlayer(Player player) {
        if (this.capacity > this.roster.size()){
            this.roster.add(player);
        }
    }

    public int count() {
        return this.roster.size();
    }

    public boolean removePlayer(String name) {
        return this.roster.removeIf(n -> n.getName().equals(name));
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)){
                player.setRank("Member");
                break;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)){
                player.setRank("Trial");
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] result = roster.stream().filter(player -> player.getClazz().equals(clazz)).toArray(Player[]::new);
        setRoster(roster.stream().filter(player -> !player.getClazz().equals(clazz)).collect(Collectors.toList()));
        return result;
    }

    public String report() {
        StringBuilder out = new StringBuilder("Players in the guild: " + this.name + ":");
        System.out.println();
        for (Player player : roster) {
            out.append(System.lineSeparator());
            out.append(player);
        }
        return out.toString().trim();
    }
}
