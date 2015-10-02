package core.search.operator;

import core.search.model.Model;
import core.search.result.Ranking;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kyle on 10/1/15.
 */
public abstract class Query {
    protected List<Query> subQueryList;

    protected Query() {
        this.subQueryList = new LinkedList<>();
    }

    public void addSubQuery(Query query) {
        this.subQueryList.add(query);
    }

    public abstract Ranking evaluate(Model model);
}
