package lxft.deck;

import java.util.ArrayList;
import java.util.List;

public class SuitOrderedCardFactory implements CardFactory<Card> {

    @Override
    public List<Card> createCards() {
        List<Card> cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        return cards;
    }

}
