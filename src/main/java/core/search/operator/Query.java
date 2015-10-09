package core.search.operator;

import core.search.model.Model;
import core.search.result.Ranking;
import core.search.result.Result;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kyle on 10/1/15.
 */
public abstract class Query {
    protected List<Query> subQueryList;
    protected List<Result> resultList;

    protected Query() {
        this.subQueryList = new LinkedList<>();
    }

    public void addSubQuery(Query query) {
        this.subQueryList.add(query);
    }

    public void evalChildren(Model model) {
        resultList = new ArrayList<>();
        for (Query q : subQueryList) {
            resultList.add(q.evaluate(model));
        }
    }

    public abstract Result evaluate(Model model);
}
