package core.search;

import core.analyzer.Analyzer;
import core.analyzer.WhiteSpaceAnalyzer;
import core.index.Index;
import core.search.model.BooleanModel;
import core.search.operator.Query;
import core.search.operator.QueryParser;
import core.search.model.Model;
import core.search.result.Ranking;

/**
 * Created by Kyle on 7/12/15.
 */
public class Searcher {
    private Index index;
    private Model model = new BooleanModel(); // default to be Unranked Boolean model
    private Analyzer analyzer; // default to be white space analyzer

    public Searcher(String dir) {
        this.index = new Index(dir);
        this.analyzer = new WhiteSpaceAnalyzer();
    }

    public Ranking search(String queryText) {
        QueryParser parser = new QueryParser(analyzer, index);
        Query queryTree = parser.parse(queryText);
        Ranking rank = (Ranking) queryTree.evaluate(model);
        return rank;
    }
}
