public class AnonymousArgumentDefinedInnerClasses {

    public static void main(String[] args) {
        AnonymousArgumentDefinedInnerClasses anonymousClass = new AnonymousArgumentDefinedInnerClasses();
        anonymousClass.playSport(
                5,
                new Sport() {
                    @Override
                    public void play() {
                        System.out.println("playing sport...");
                    }
                },
                "football"); // semicolon is mandatory to compile successfully
    }

    public void playSport(int i, Sport sport, String sportName) {
        sport.play();
    }
}

interface Sport {
    void play();
}