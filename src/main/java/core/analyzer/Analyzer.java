package core.analyzer;

import core.models.Term;

import java.util.List;

/**
 * Created by Kyle on 7/12/15.
 */
public abstract class Analyzer {
    public abstract List<Term> tokenize(String text);
}
