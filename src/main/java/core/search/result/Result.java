package core.search.result;

import core.collections.Document;

/**
 * Created by Kyle on 10/2/15.
 */
public class Result {
    private Document doc;
    private double score;
    //TODO: there can be highlight or other metadata here

    public long getDocId() {
        return doc.getDocId();
    }
}