package core.index;

import core.collections.Document;
import core.collections.Term;

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
        doc.setDocId(docId);
        List<String> fieldList = doc.getFieldList();
        for (String field : fieldList) {
            index.setSource(docId, field, doc.getSource(field));
            List<Term> termList = doc.getTermList(field);
            for (Term term : termList) {
                index.addTermDocPair(docId, field, term);
            }
        }
        index.incDocNum();
        return true;
    }

    public void close() {
        index.close();
    }
}
