package lxft.deck;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StandardCardDeckTest {

    private CardFactory<Card> cardFactory;
    private ShuffleStrategy<Card> shuffleStrategy;
    private StandardCardDeck deck;

    @Before
    public void initDeck() {
        cardFactory = new SuitOrderedCardFactory();
        shuffleStrategy = new JavaCollectionsShuffle();
        deck = new StandardCardDeck(cardFactory, shuffleStrategy);
    }

    @Test
    public void testDeckSize() {
        assertEquals(StandardCardDeck.DECK_SIZE, deck.size());
        deck.shuffle();
        assertEquals(StandardCardDeck.DECK_SIZE, deck.size());
    }

    @Test
    public void testRemoveAllCards() {
        List<Card> cards = cardFactory.createCards();
        for (Card card : cards) {
            deck.removeCard(card);
        }
        assertEquals(0, deck.size());
    }

    @Test(expected=RuntimeException.class)
    public void testRemoveInexistentCard() {
        List<Card> cards = cardFactory.createCards();
        for (Card card : cards) {
            deck.removeCard(card);
        }
        deck.removeCard(cards.get(0));
    }

    @Test
    public void testCardUniqueness() {
        int exceptionCounter = 0;
        List<Card> cards = cardFactory.createCards();
        for (Card card : cards) {
            try {
                deck.addCard(card);
            } catch (RuntimeException e) {
                exceptionCounter++;
            }
        }
        assertEquals(StandardCardDeck.DECK_SIZE, exceptionCounter);
    }

    @Test
    public void testShuffleOrder() {
        List<Card> before = deck.getCards();
        deck.shuffle();
        List<Card> after = deck.getCards();
        assertNotEquals(before, after);
        assertEquals(deck.getCards(), deck.getCards());
    }

}
