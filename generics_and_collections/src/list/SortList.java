package list;

import comparator.ArtistComparator;
import comparator.ReleasedComparator;
import comparator.RockSong;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class SortList {

    private static final Path PROJECT_PATH = Paths.get("");
    private static final Path ROCK_SONG_LIST_RELATIVE_PATH = Paths.get("generics_and_collections/src/the best rock songs.txt");
    private static final Path ROCK_SONG_LIST_ABS_PATH = PROJECT_PATH.resolve(ROCK_SONG_LIST_RELATIVE_PATH);

    public static void main(String[] args) throws IOException {
        sortListOfComparableObjects();
        List<RockSong> rockSongList = getRockSongListFromFile();
        sortListByComparators(rockSongList);
        sortListByLambda(rockSongList);
    }

    private static void sortListOfComparableObjects() {
        System.out.println("\n--------------- Sort list of Short ---------------");
        short a = -29;
        short b = 44;
        short c = 180;
        List<Short> shortList = Arrays.asList(c, a, b);
        Short[] shortArray = new Short[shortList.size()];
        shortArray = shortList.toArray(shortArray);

        System.out.println("Short list = " + shortList);
        Collections.sort(shortList);
        System.out.println("Natural order = " + shortList);
        Comparator<Object> reverseComparator = Collections.reverseOrder();
        Collections.sort(shortList, reverseComparator);
        System.out.println("Reverse order = " + shortList);

        System.out.println("\n--------------- Sort array of Short ---------------");
        System.out.println("Short array = " + Arrays.toString(shortArray));
        Arrays.sort(shortArray);
        System.out.println("Natural order = " + Arrays.toString(shortArray));
        Arrays.sort(shortArray, reverseComparator);
        System.out.println("Reverse order = " + shortArray);
    }

    private static List<RockSong> getRockSongListFromFile() throws IOException {
        System.out.println("\n--------------- Sort list of RockSong ---------------");
        System.out.println("\nReading rock songs list from file " + ROCK_SONG_LIST_RELATIVE_PATH);

        List<RockSong> rockSongList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ROCK_SONG_LIST_ABS_PATH.toString()))) {
            String line;
            while ( (line = bufferedReader.readLine()) != null) {
                String[] songProps = line.split("/");
                RockSong rockSong = new RockSong(songProps[0], songProps[1], Integer.parseInt(songProps[2]));
                rockSongList.add(rockSong);
            }
        }

        print("Rock songs list", rockSongList);
        return rockSongList;
    }

    private static void print(String msg, List<RockSong> rockSongList) {
        System.out.println(msg);
        for (RockSong rockSong : rockSongList) {
            System.out.println("\u25E6 " + rockSong);
        }
    }

    private static void sortListByComparators(List<RockSong> rockSongList) throws IOException {
        Collections.sort(rockSongList, new ArtistComparator());
        print("\nOrdered by ArtistComparator", rockSongList);
        Collections.sort(rockSongList, new ReleasedComparator());
        print("Ordered by ReleasedComparator", rockSongList);
    }

    private static void sortListByLambda(List<RockSong> rockSongList) {
        Collections.sort(rockSongList, (song1, song2) -> song1.getArtist().compareTo(song2.getArtist()));
        print("\nOrdered by LAMBDA that replace the ArtistComparator", rockSongList);
        Collections.sort(rockSongList, (song1, song2) -> song1.getReleased().compareTo(song2.getReleased()));
        print("Ordered by LAMBDA that replace the ReleasedComparator", rockSongList);
    }
}