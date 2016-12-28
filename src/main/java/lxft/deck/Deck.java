package lxft.deck;

import java.util.List;

public interface Deck<T> extends Iterable<T>{

    void shuffle();

    void addCard(T card);

    void removeCard(T card);

    List<T> getCards();

    int size();

}
