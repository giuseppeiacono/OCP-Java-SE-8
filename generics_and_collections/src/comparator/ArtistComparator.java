package comparator;

import java.util.Comparator;

public class ArtistComparator implements Comparator<RockSong> {

    @Override
    public int compare(RockSong song1, RockSong song2) {
        // compare strings lexicographically
        return song1.getArtist().compareTo(song2.getArtist());
    }
}
