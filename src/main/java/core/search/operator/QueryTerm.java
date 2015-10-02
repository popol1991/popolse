package core.search.operator;

import core.search.model.Model;
import core.search.result.Ranking;

import java.util.List;

/**
 * Created by Kyle on 10/2/15.
 */
public class QueryTerm extends Query {
    private List<Long> invList;

    public QueryTerm(List<Long> invList) {
        super();
        this.invList = invList;
    }

    @Override
    public Ranking evaluate(Model model) {
        return null;
    }
}
