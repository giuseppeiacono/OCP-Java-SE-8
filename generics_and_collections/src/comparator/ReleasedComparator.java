package comparator;

import java.util.Comparator;

public class ReleasedComparator implements Comparator<RockSong> {

    @Override
    public int compare(RockSong song1, RockSong song2) {
        // compare integer numerically
        return song1.getReleased().compareTo(song2.getReleased());
    }
}
