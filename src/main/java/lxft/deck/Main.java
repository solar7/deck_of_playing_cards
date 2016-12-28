package lxft.deck;

public class Main {

    public static void main(String[] args) {
        StandardCardDeck deck = new StandardCardDeck(
                new SuitOrderedCardFactory(), new JavaCollectionsShuffle());

        System.out.print("Before shuffle:");
        System.out.println(deck.getCards());

        deck.shuffle();

        System.out.print("After shuffle: ");
        System.out.println(deck.getCards());
    }

}
