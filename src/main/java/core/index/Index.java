package core.index;

import core.collections.Dictionary;
import core.collections.Posting;
import core.collections.Term;
import core.utils.Constants;
import core.utils.FilePersister;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kyle on 7/8/15.
 */
public class Index {
    private String dir;
    private String dictPath;
    private String postingPath;
    private String rawSourcePath;

    private long docNum;
    private Dictionary dictionary;
    private Map<String, Posting> postingMap;
    private Map<Long, Map<String, String>> rawSource;

    public Index(String dir) {
        this.dir = dir;
        this.dictPath = dir + "/" + Constants.FILE_DICT;
        this.postingPath = dir + "/" + Constants.FILE_POSTING;
        this.rawSourcePath = dir + "/" + Constants.FILE_SOURCE;

        Path path = Paths.get(dir);
        if (Files.exists(path)) { // index existed
            // load index from serialized files
            this.postingMap = (Map<String, Posting>) FilePersister.loadObject(postingPath);
            Dictionary.loadFromPath(dictPath);
            this.dictionary = Dictionary.getSingleton();
            this.rawSource = (Map<Long, Map<String, String>>) FilePersister.loadObject(rawSourcePath);
        } else { // index not existed
            // create index directory
            (new File(dir)).mkdir();
            this.postingMap = new HashMap<>();
            this.dictionary = Dictionary.getSingleton();
            this.rawSource = new HashMap<>();
            this.docNum = 0;
            flush();
        }
    }

    public long getDocNum() {
        return docNum;
    }

    public void addTermDocPair(long docId, String field, Term term) {
        int termId = term.getTermId();
        if (!postingMap.containsKey(field)) {
            postingMap.put(field, new Posting());
        }
        postingMap.get(field).addTermDocPair(termId, docId);
    }

    public void setSource(long docId, String field, String source) {
        if (!rawSource.containsKey(docId)) {
            rawSource.put(docId, new HashMap<>());
        }
        Map<String, String> map = rawSource.get(docId);
        map.put(field, source);
    }

    public void close() {
        flush(); // flush index to hard drive files
    }

    private void flush() {
        FilePersister.saveObject(dictPath, dictionary);
        FilePersister.saveObject(postingPath, postingMap);
        FilePersister.saveObject(rawSourcePath, rawSource);
    }

    public List<Long> getInvList(String field, Term term) {
        return this.postingMap.get(field).getInvList(term);
    }

    public void incDocNum() {
        this.docNum++;
    }

    public String getSource(long docId, String field) {
        return rawSource.get(docId).get(field);
    }
}
