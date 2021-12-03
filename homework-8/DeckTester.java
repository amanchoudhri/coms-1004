public class DeckTester{
    public static void main(String[] args) {
        // no longer needed since constructor automatically shuffles deck
        Deck d = new Deck();
        System.out.println(d);
        d.shuffle();
        System.out.println(d);
    }
}