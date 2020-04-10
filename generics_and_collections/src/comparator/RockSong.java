package comparator;

public class RockSong {

    private String artist;
    private String single;
    private Integer released;

    public RockSong(String artist, String single, Integer released) {
        this.artist = artist;
        this.single = single;
        this.released = released;
    }

    public String getArtist() {
        return artist;
    }

    public String getSingle() {
        return single;
    }

    public Integer getReleased() {
        return released;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public void setReleased(int released) {
        this.released = released;
    }

    @Override
    public String toString() {
        return artist + ", " + single + ", " + released;
    }
}
