package lxft.deck;

import java.util.List;

public interface ShuffleStrategy<T> {

    void shuffle(List<T> list);

}
