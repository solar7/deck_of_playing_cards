package lxft.deck;

import java.util.Collections;
import java.util.List;

public class JavaCollectionsShuffle implements ShuffleStrategy<Card> {

    @Override
    public void shuffle(List<Card> list) {
        Collections.shuffle(list);
    }

}
