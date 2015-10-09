package core.search.result;

import java.util.Iterator;
import java.util.LinkedList; // TODO: implement a linked list
import java.util.List;

/**
 * Created by Kyle on 10/1/15.
 */
public class Ranking extends Result
        implements Iterable<ResultItem> {
    private List<ResultItem> resultItemList;

    public Ranking() {
        this.resultItemList = new LinkedList<>();
    }

    /**
     * Maintain a sorted result list.  Iterate to the
     * first score that is larger than given result,
     * insert the result before that item.
     * @param r
     */
    public void add(ResultItem r) {
        if (this.resultItemList.size() == 0) {
            this.resultItemList.add(r);
        } else {
            int idx = 0;
            for (ResultItem it : this.resultItemList) {
                if (it.getScore() > r.getScore()) {
                    break;
                }
                idx++;
            }
            this.resultItemList.add(idx, r);
        }
    }

    @Override
    public Iterator<ResultItem> iterator() {
        return resultItemList.iterator();
    }
}
