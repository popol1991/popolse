package core.models;

import core.analyzer.Analyzer;

import java.util.List;

/**
 * Created by Kyle on 7/8/15.
 * Indexable and searchable unit for a search engine.
 */
public class Document {
    private List<Term> termList;
    private Analyzer analyzer;

    public Document(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    public void addContent(String content) {
        this.termList = this.analyzer.tokenize(content);
    }

    public List<Term> getTermList() {
        return this.termList;
    }
}
