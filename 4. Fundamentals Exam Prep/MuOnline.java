import java.util.Scanner;
//You have initial health 100 and initial bitcoins 0. You will be given a string, representing the dungeons rooms. Each room is separated with '|' (vertical bar): "room1|room2|room3…"
//Each room contains a command and a number, separated by space. The command can be:
//"potion"
//oYou are healed with the number in the second part. But your health cannot exceed your initial health (100).
//oFirst print: "You healed for {amount} hp.".
//oAfter that, print your current health: "Current health: {health} hp.".
//"chest"
//oYou've found some bitcoins, the number in the second part.
//oPrint: "You found {amount} bitcoins."
//In any other case you are facing a monster, you are going to fight. The second part of the room, contains the attack of the monster.
// You should remove the monster's attack from your health.
//oIf you are not dead (health <= 0) you've slain the monster, and you should print ("You slayed {monster}.")
//oIf you've died, print "You died! Killed by {monster}." and your quest is over. Print the best room you`ve manage to reach: "Best room: {room}".
//If you managed to go through all the rooms in the dungeon, print on the next three lines:
//"You've made it!", "Bitcoins: {bitcoins}", "Health: {health}".


public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentHealth = 100; boolean isDead = false; int bitcoins = 0;
        int counter = 0; int maxHealth = 100;

        String[] input = scanner.nextLine().split("\\|");
        String[] commands = new String[input.length];
        for (int i = 0; i < input.length; i++) {
            commands = input[i].split(" ");
            if (commands[0].equals("potion")){
                int oldHealth = currentHealth;
                currentHealth += Integer.parseInt(commands[1]);
                    if (currentHealth > 100){
                        int diff = maxHealth - oldHealth;
                        currentHealth += diff - Integer.parseInt(commands[1]);
                        System.out.println("You healed for " + diff + " hp.");
                        System.out.printf("Current health: %d hp.%n", currentHealth);
                    }else {
                       // currentHealth += Integer.parseInt(commands[1]);
                        System.out.println("You healed for " + commands[1] + " hp.");
                        System.out.printf("Current health: %d hp.%n", currentHealth);
                    }
            }else if (commands[0].equals("chest")){
                System.out.println("You found " + commands[1] + " bitcoins.");
                bitcoins += Integer.parseInt(commands[1]);
            }else {
                currentHealth -= Integer.parseInt(commands[1]);
                if (currentHealth <= 0){
                    isDead = true;
                    counter++;
                    break;
                }else {
                    System.out.println("You slayed " + commands[0] + ".");
                }
            }

            counter++;
        }
        if (isDead){
            System.out.println("You died! Killed by " + commands[0] + ".");
            System.out.printf("Best room: %d", counter);
        }else {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d", currentHealth);
        }
        }
    }

