package Songs;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSongs = Integer.parseInt(scanner.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < numberOfSongs; i++) {
            String input = scanner.nextLine();
            String[] songData = input.split("_");

            String typeList = songData[0];
            String name = songData[1];
            String time = songData[2];

            Song song = new Song();

            song.setName(name);
            song.setTypeList(typeList);
            song.setTime(time);

            songs.add(song);
        }
        String typeList = scanner.nextLine();

        if (typeList.equals("all")){
            for (Song song: songs){
                System.out.println(song.getName());
            }
        }else {
            for (Song song: songs){
                if (song.getTypeList().equals(typeList)){
                    System.out.println(song.getName());
                }
            }
        }
        }
    }

