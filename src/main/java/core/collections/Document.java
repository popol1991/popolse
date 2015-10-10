package core.collections;

import core.analyzer.Analyzer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Kyle on 7/8/15.
 * Indexable and searchable unit for a search engine.
 */
public class Document {
    private long docId;
    private List<String> fieldList;
    // A map that stores the term list for each field
    private Map<String, List<Term>> fieldMap;
    private Map<String, String> fieldSourceMap;
    private Analyzer analyzer;

    public Document(Analyzer analyzer) {
        this.analyzer = analyzer;
        this.fieldList = new LinkedList<>();
        this.fieldMap = new HashMap<>();
        this.fieldSourceMap = new HashMap<>();
    }

    public void setContent(String field, String content) {
        if (!this.fieldMap.containsKey(field)) {
            this.fieldList.add(field);
        }
        this.fieldMap.put(field, analyzer.tokenize(content));
        this.fieldSourceMap.put(field, content);
    }

    public List<Term> getTermList(String field) {
        return this.fieldMap.get(field);
    }

    public void setDocId(long docId) {
        this.docId = docId;
    }

    public long getDocId() {
        return docId;
    }

    public List<String> getFieldList() {
        return fieldList;
    }

    public String getSource(String field) {
        return this.fieldSourceMap.get(field);
    }
}
