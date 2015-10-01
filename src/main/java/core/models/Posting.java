package core.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Kyle on 7/10/15.
 * Implement the inverted index structure used by search engines.
 */
public class Posting implements Serializable {
    private Hashtable<Integer, List<Long>> invList;

    public Posting() {
        this.invList = new Hashtable<Integer, List<Long>>();
    }

    public void addTermDocPair(int termId, long docId) {
        if (!invList.containsKey(termId)) {
            invList.put(termId, new ArrayList<Long>());
        }
        invList.get(termId).add(docId);
    }
}
