package core.models;

import java.io.Serializable;
import java.util.Hashtable;

/**
 * Created by Kyle on 7/10/15.
 * A class that keep tracts of all terms and the mapping between term and term ID.
 */
public class Dictionary implements Serializable {
    private Hashtable<String, Integer> idMap; // map term to term ID

    public Dictionary() {
        this.idMap = new Hashtable<String, Integer>();
    }

    public int termNum() {
        return this.idMap.size();
    }

    public void addTerm(Term term) {
        int termId = this.termNum() + 1;
        this.idMap.put(term.getText(), termId);
    }

    public boolean hasTerm(Term term) {
        return this.idMap.containsKey(term.getText());
    }

    public int getTermId(Term term) {
        return idMap.get(term.getText());
    }
}
