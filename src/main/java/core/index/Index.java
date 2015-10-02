package core.index;

import core.collections.Dictionary;
import core.collections.Posting;
import core.collections.Term;
import core.utils.Constants;
import core.utils.FilePersister;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Kyle on 7/8/15.
 */
public class Index {
    private String dir;
    private String dictPath;
    private String postingPath;

    private Dictionary dictionary;
    private long docNum;
    private Posting posting;

    public Index(String dir) {
        this.dir = dir;
        this.dictPath = dir + "/" + Constants.FILE_DICT;
        this.postingPath = dir + "/" + Constants.FILE_POSTING;

        Path path = Paths.get(dir);
        if (Files.exists(path)) { // index existed
            // load index from serialized files
            this.posting = (Posting) FilePersister.loadObject(postingPath);
            Dictionary.loadFromPath(dictPath);
            this.dictionary = Dictionary.getSingleton();
        } else { // index not existed
            this.posting = new Posting();
            this.dictionary = Dictionary.getSingleton();
            this.docNum = 0;
            flush();
        }
    }

    public long getDocNum() {
        return docNum;
    }

    public void addTermDocPair(Term term, long docId) {
        int termId = term.getTermId();
        posting.addTermDocPair(termId, docId);
    }

    public void close() {
        flush(); // flush index to hard drive files
    }

    private void flush() {
        FilePersister.saveObject(dictPath, dictionary);
        FilePersister.saveObject(postingPath, posting);
    }

    public List<Long> getInvList(Term term) {
        return this.posting.getInvList(term);
    }
}
