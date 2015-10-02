package core.search;

import core.analyzer.Analyzer;
import core.analyzer.WhiteSpaceAnalyzer;
import core.index.Index;
import core.search.core.search.operator.Query;
import core.search.operator.QueryParser;
import core.search.model.Model;
import core.search.result.Ranking;

/**
 * Created by Kyle on 7/12/15.
 */
public class Searcher {
    private Index index;
    private Model model;
    private Analyzer analyzer = new WhiteSpaceAnalyzer(); // default to be white space analyzer

    public Searcher(String dir) {
        this.index = new Index(dir);
    }

    public Ranking search(String queryText) {
        QueryParser parser = new QueryParser(analyzer, index);
        Query queryTree = parser.parse(queryText);
        Ranking rank = queryTree.evaluate(model);
        return rank;
    }
}
