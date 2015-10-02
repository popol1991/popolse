package core.search.result;

import core.collections.Document;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Kyle on 10/1/15.
 */
public class Ranking implements Iterable<Result> {
    private List<Result> resultList;

    @Override
    public Iterator<Result> iterator() {
        return resultList.iterator();
    }
}
