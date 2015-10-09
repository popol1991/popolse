package core.search.result;

import core.collections.Document;

/**
 * Created by Kyle on 10/2/15.
 */
public class ResultItem {
    private long docid;
    private double score;

    public ResultItem(Long docid, double score) {
        this.docid = docid;
        this.score = score;
    }
    //TODO: there can be highlight or other metadata here

    public long getDocId() {
        return docid;
    }

    public double getScore() {
        return score;
    }
}