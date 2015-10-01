package core.index;

import core.models.Document;
import core.models.Term;

import java.util.List;

/**
 * Created by Kyle on 7/13/15.
 */
public class IndexWriter {
    private Index index;

    public IndexWriter(String dir) {
        this.index = new Index(dir);
    }

    public boolean addDocument(Document doc) {
        long docId = index.getDocNum() + 1;
        List<Term> termList = doc.getTermList();
        for (Term term : termList) {
            index.addTermDocPair(term, docId);
        }
        return true;
    }

    public void close() {
        index.close();
    }
}
