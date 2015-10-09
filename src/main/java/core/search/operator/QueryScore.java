package core.search.operator;

import core.search.model.Model;
import core.search.result.InvListResult;
import core.search.result.Ranking;
import core.search.result.ResultItem;

/**
 * Created by Kyle on 10/2/15.
 */
public class QueryScore extends Query {
    /**
     * SCORE query operator accept an inverted list as argument,
     * and return a score list based on the given model
     * @param model provided ranking model
     * @return a score list
     */
    @Override
    public Ranking evaluate(Model model) {
        evalChildren(model);
        assert resultList.size() == 1;
        Ranking rank = new Ranking();
        InvListResult invlist = (InvListResult) resultList.get(0);
        for (int i = 0; i < invlist.size(); i++) {
            Long docid = invlist.getDocIdAt(i);
            double score = model.score(invlist.getDocAt(i));
            rank.add(new ResultItem(docid, score));
        }
        return rank;
    }
}
