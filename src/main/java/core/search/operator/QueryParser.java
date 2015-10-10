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
        /**
         * Only allow one term query now
         * If there were more terms in the query
         * Only the first term is processed.
         */
        List<Term> terms = analyzer.tokenize(queryText);
        Query retRoot = new QueryOR();
        QueryTerm qTerm = new QueryTerm(index.getInvList("title", terms.get(0)));
        QueryScore qScore = new QueryScore();
        qScore.addSubQuery(qTerm);
        return qScore;
    }
}
