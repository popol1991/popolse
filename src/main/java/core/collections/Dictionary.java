package core.collections;

import core.utils.FilePersister;

import java.io.Serializable;
import java.util.Hashtable;

/**
 * Created by Kyle on 7/10/15.
 * A class that keep tracts of all terms and the mapping between term and term ID.
 * It is a singleton;
 */
public class Dictionary implements Serializable {
    private static Dictionary singleton = null;
    private Hashtable<String, Integer> idMap; // map term to term ID

    public static Dictionary getSingleton() {
        if (singleton == null) {
            System.err.println("Dictionary is not loaded!");
        }
        return singleton;
    }

    public static void loadFromPath(String path) {
        singleton = (Dictionary) FilePersister.loadObject(path);
    }

    private Dictionary() {
        this.idMap = new Hashtable<>();
    }

    public int termNum() {
        return this.idMap.size();
    }

    public void addTerm(String term) {
        int termId = this.termNum() + 1;
        this.idMap.put(term, termId);
    }

    public boolean hasTerm(String term) {
        return this.idMap.containsKey(term);
    }

    public int getTermId(String term) {
        return idMap.get(term);
    }
}
