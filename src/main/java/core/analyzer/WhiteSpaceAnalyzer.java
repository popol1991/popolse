package core.analyzer;

import core.collections.Term;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kyle on 7/12/15.
 */
public class WhiteSpaceAnalyzer extends Analyzer {
    public static final String RE_WHITE_SPACE = "[ \t\n]+";

    @Override
    public List<Term> tokenize(String text) {
        String[] words = text.split(RE_WHITE_SPACE);

        List<Term> retList = new ArrayList<Term>();
        for (String word : words) {
            int termId = getTermId(word);
            Term term = new Term(termId, word);
            retList.add(term);
        }
        return retList;
    }
}
