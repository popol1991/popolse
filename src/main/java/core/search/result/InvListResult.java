package core.search.result;

import java.util.List;

/**
 * Created by Kyle on 10/9/15.
 */
public class InvListResult extends Result {
    private List<Long> invList;

    public InvListResult(List<Long> invList) {
        this.invList = invList;
    }

    public int size() {
        return this.invList.size();
    }

    public Long getDocIdAt(int i) {
        return invList.get(i);
    }

    public Long getDocAt(int i) {
        // Currently it is the same as getDocIdAt()
        // It will return a posting item object after
        // we have frequency, positions in the posting
        return invList.get(i);
    }
}
