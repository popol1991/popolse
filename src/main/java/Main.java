import core.search.Searcher;
import core.search.result.Ranking;
import core.search.result.ResultItem;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Kyle on 7/12/15.
 */
public class Main {
    public static void main(String[] argv) throws IOException {
        Searcher searcher = new Searcher("index");
        Ranking rank = searcher.search("the");
        Iterator<ResultItem> it = rank.iterator();
        while (it.hasNext()) {
            long docId = it.next().getDocId();
            System.out.println(docId);
        }

//        WarcIndexTool index = new WarcIndexTool();
//        index.index("index", "/Users/Kyle/Develop/clueweb09/catB/");
    }
}
