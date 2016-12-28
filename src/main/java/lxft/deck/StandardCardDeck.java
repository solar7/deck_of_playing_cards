package lxft.deck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StandardCardDeck implements Deck<Card> {

    public static final int DECK_SIZE = 52;

    private final List<Card> cards;

    private ShuffleStrategy<Card> shuffleStrategy;

    public StandardCardDeck(CardFactory<Card> cardFactory,
            ShuffleStrategy<Card> shuffleStrategy) {
        this.cards = new ArrayList<>(cardFactory.createCards());
        this.shuffleStrategy = shuffleStrategy;
    }

    @Override
    public void shuffle() {
        shuffleStrategy.shuffle(cards);
    }

    @Override
    public void addCard(Card card) {
        if (cards.contains(card)) {
            throw new RuntimeException(card + " is from another Deck");
        }
        cards.add(card);
    }

    @Override
    public void removeCard(Card card) {
        boolean removed = cards.remove(card);
        if (!removed) {
            throw new RuntimeException(card + " is not in the Deck");
        }
    }

    @Override
    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    @Override
    public int size() {
        return cards.size();
    }

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }

    public void setShuffleStrategy(ShuffleStrategy<Card> shuffleStrategy) {
        this.shuffleStrategy = shuffleStrategy;
    }

}
