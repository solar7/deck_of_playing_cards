package lxft.deck;

import java.util.List;

public interface CardFactory<T> {

    List<T> createCards();

}
