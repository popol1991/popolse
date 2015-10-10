import core.index.Index;
import core.index.tool.WarcIndexTool;
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
        Index index = new Index("index");
        Searcher searcher = new Searcher(index);
        Ranking rank = searcher.search("money");
        Iterator<ResultItem> it = rank.iterator();
        while (it.hasNext()) {
            long docId = it.next().getDocId();
            String trecId = index.getSource(docId, "id");
            System.out.println(trecId);
        }

//        WarcIndexTool index = new WarcIndexTool();
//        index.index("index", "/Users/Kyle/Develop/clueweb09/catB/");
    }
}
