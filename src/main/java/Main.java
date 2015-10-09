import core.analyzer.WhiteSpaceAnalyzer;
import core.index.IndexWriter;
import core.collections.Document;
import core.search.Searcher;
import core.search.result.Ranking;
import core.search.result.ResultItem;

import java.util.Iterator;

/**
 * Created by Kyle on 7/12/15.
 */
public class Main {
    public static void main(String[] argv) {
        IndexWriter indexer = new IndexWriter("index");
        Document doc = new Document(new WhiteSpaceAnalyzer());
        doc.addContent("carnegie mellon university");
        indexer.addDocument(doc);
        doc = new Document(new WhiteSpaceAnalyzer());
        doc.addContent("university of california berkeley");
        indexer.addDocument(doc);
        doc = new Document(new WhiteSpaceAnalyzer());
        doc.addContent("stanford university");
        indexer.addDocument(doc);
        indexer.close();

        Searcher searcher = new Searcher("index");
        Ranking rank = searcher.search("california");
        Iterator<ResultItem> it = rank.iterator();
        while (it.hasNext()) {
            long docId = it.next().getDocId();
            System.out.println(docId);
        }
    }
}
