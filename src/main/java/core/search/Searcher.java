package core.search;

import core.models.Dictionary;
import core.models.Posting;
import core.search.result.Ranking;
import core.utils.Constants;
import core.utils.FilePersister;

/**
 * Created by Kyle on 7/12/15.
 */
public class Searcher {
    private Dictionary dictionary;
    private Posting posting;

    public Searcher(String dir) {
        this.dictionary = (Dictionary) FilePersister.loadObject(dir + Constants.FILE_DICT);
        this.posting = (Posting) FilePersister.loadObject(dir + Constants.FILE_POSTING);
    }


    public Ranking search(String university) {
        return null;
    }
}
