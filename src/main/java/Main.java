import core.analyzer.WhiteSpaceAnalyzer;
import core.index.Index;
import core.index.IndexWriter;
import core.models.Document;
import core.search.Searcher;
import core.search.result.Ranking;

/**
 * Created by Kyle on 7/12/15.
 */
public class Main {
    public static void main(String[] argv) {
        IndexWriter indexer = new IndexWriter("index");
        Document doc = new Document(new WhiteSpaceAnalyzer());
        doc.addContent("carnegie mellon university");
        doc.addContent("university of california berkeley");
        doc.addContent("stanford university");
        indexer.addDocument(doc);
        indexer.close();

        Searcher searcher = new Searcher("index");
        Ranking rank = searcher.search("university");
    }
}
