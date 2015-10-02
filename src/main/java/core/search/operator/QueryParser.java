package core.search.operator;

import core.analyzer.Analyzer;
import core.collections.Term;
import core.index.Index;

import java.util.List;

/**
 * Created by Kyle on 10/2/15.
 */
public class QueryParser {
    private Analyzer analyzer;
    private Index index;

    public QueryParser(Analyzer analyzer, Index index) {
        this.analyzer = analyzer;
        this.index = index;
    }

    public Query parse(String queryText) {
        List<Term> terms = analyzer.tokenize(queryText);
        Query retRoot = new QueryOR();
        for (Term term : terms) {
            List<Long> invList = index.getInvList(term);
            QueryTerm qTerm = new QueryTerm(invList);
            QueryScore qScore = new QueryScore();
            qScore.addSubQuery(qTerm);
            retRoot.addSubQuery(qScore);
        }
        return retRoot;
    }
}
