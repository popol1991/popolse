package core.analyzer;

import core.collections.Dictionary;
import core.collections.Term;

import java.util.List;

/**
 * Created by Kyle on 7/12/15.
 */
public abstract class Analyzer {
    public abstract List<Term> tokenize(String text);

    protected Dictionary dictionary;

    public Analyzer() {
        this.dictionary = Dictionary.getSingleton();
    }

    protected int getTermId(String word) {
        if (!this.dictionary.hasTerm(word)) {
            this.dictionary.addTerm(word);
        }
        int termId = this.dictionary.getTermId(word);
        return termId;
    }
}
