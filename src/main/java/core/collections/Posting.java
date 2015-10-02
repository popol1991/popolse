package core.collections;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Kyle on 7/10/15.
 * Implement the inverted index structure used by search engines.
 */
public class Posting implements Serializable {
    /**
     * For simplicity the inverted list currently stores only the set of document ids
     * that a term appeared, no term frequency, no position, and not sorted.
     * TODO: Eventually need to encapsulate inverted list as a class
     */
    private Hashtable<Integer, Set<Long>> invList;

    public Posting() {
        this.invList = new Hashtable<>();
    }

    public void addTermDocPair(int termId, long docId) {
        if (!invList.containsKey(termId)) {
            invList.put(termId, new HashSet<>());
        }
        invList.get(termId).add(docId);
    }
}
