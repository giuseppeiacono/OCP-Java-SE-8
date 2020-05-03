public class LambdaAsInnerClass {

    public static void main(String[] args) {
        Game gameImplementor = new Game() {
            @Override
            public void play() {
                System.out.println("play game");
            }
        };

        Game gameLambda = () -> System.out.println("play game");

        gameImplementor.play();
        gameLambda.play();
    }
}

interface Game {
    void play();
}
