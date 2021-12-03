import java.util.ArrayList;

public class OutcomeTester {
    public static void main(String[] args) {
        String[][] tests = {
            // Royal flush cases
            {"s1", "s13", "s12", "s10", "s11"},
            {"h1", "h12", "h10", "h11", "h13"},
            // Straight flush
            {"h9", "h12", "h10", "h11", "h13"},
            {"c4", "c5", "c3", "c2", "c1"},
            {"d5", "d6", "d7", "d9", "d8"},
            // Four of a kind
            {"h4", "h3", "c4", "d4", "s4"},
            {"s13", "c13", "d13", "h13", "h12"},
            // Full house
            {"c12", "h12", "d12", "c4", "s4"},
            {"d2", "h2", "d12", "c12", "s12"},
            // Flush
            {"c12", "c1", "c3", "c5", "c6"},
            {"s4", "s3", "s1", "s6", "s7"},
            // Straight
            {"c1", "s2", "h3", "h4", "d5"},
            {"d1", "s13", "h12", "d11", "d10"},
            // Three of a kind
            {"d1", "h1", "c1", "d13", "h3"},
            // Two pairs
            {"h13", "d13", "d2", "s3", "s2"},
            // One pair
            {"h1", "s1", "h2", "d6", "c4"},
            // Nothing
            {"h4", "h5", "c6", "c8", "d9"},
        };
        for (String[] testCase : tests) {
            // convert String[] to arraylist of cards
            Game g = new Game();
            Deck d = new Deck(testCase);
            ArrayList<Card> tc = new ArrayList<>();
            // Add the given cards to the arraylist
            for (int i = 0; i < 5; i++) {
                tc.add(d.deal());
            }
            // note to self using deck to avoid duplicating processing code lol
            System.out.println(g.checkHand(tc));
        }
    }
}