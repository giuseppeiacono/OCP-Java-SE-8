package list;

import comparator.ArtistComparator;
import comparator.ReleasedComparator;
import comparator.RockSong;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortList {

    private static final Path PROJECT_PATH = Paths.get("");
    private static final Path ROCK_SONG_LIST_RELATIVE_PATH = Paths.get("generics_and_collections/src/the best rock songs.txt");
    private static final Path ROCK_SONG_LIST_ABS_PATH = PROJECT_PATH.resolve(ROCK_SONG_LIST_RELATIVE_PATH);

    public static void main(String[] args) throws IOException {
        System.out.println("\n--------------- Sort list ---------------");
        sortListOfComparableObjects();
        sortListByComparators();
    }

    private static void sortListOfComparableObjects() {
        short a = -29;
        short b = 44;
        short c = 180;
        List<Short> shortList = Arrays.asList(c, a, b);
        Short[] shortArray = new Short[shortList.size()];
        shortArray = shortList.toArray(shortArray);

        System.out.println("\nShort list = " + shortList);
        Collections.sort(shortList);
        System.out.println("ordered by Collections.sort() = " + shortList);

        System.out.println("\nShort array = " + Arrays.toString(shortArray));
        Arrays.sort(shortArray);
        System.out.println("Ordered by Arrays.sort() = " + Arrays.toString(shortArray));
    }

    private static void sortListByComparators() throws IOException {
        System.out.println("\nReading rock songs list from file...");
        List<RockSong> rockSongList = getRockSongListFromFile();

        print("Rock songs list", rockSongList);
        Collections.sort(rockSongList, new ArtistComparator());
        print("Ordered by ArtistComparator", rockSongList);
        Collections.sort(rockSongList, new ReleasedComparator());
        print("Ordered by ReleasedComparator", rockSongList);
    }

    private static void print(String msg, List<RockSong> rockSongList) {
        System.out.println(msg);
        for (RockSong rockSong : rockSongList) {
            System.out.println("\u25E6 " + rockSong);
        }
    }

    private static List<RockSong> getRockSongListFromFile() throws IOException {
        List<RockSong> rockSongList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ROCK_SONG_LIST_ABS_PATH.toString()))) {
            String line;
            while ( (line = bufferedReader.readLine()) != null) {
                String[] songProps = line.split("/");
                RockSong rockSong = new RockSong(songProps[0], songProps[1], Integer.parseInt(songProps[2]));
                rockSongList.add(rockSong);
            }
        }
        return rockSongList;
    }
}