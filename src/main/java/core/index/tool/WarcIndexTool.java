package core.index.tool;

import core.analyzer.Analyzer;
import core.analyzer.WhiteSpaceAnalyzer;
import core.collections.Document;
import core.index.IndexWriter;
import edu.cmu.lemurproject.WarcHTMLResponseRecord;
import edu.cmu.lemurproject.WarcRecord;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.*;
import org.jsoup.Jsoup;

import java.io.*;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;

/**
 * Created by Kyle on 10/9/15.
 */
public class WarcIndexTool {
    public void index(String indexDir, String dataDir) throws IOException {
        IndexWriter indexer = new IndexWriter("index");
        Iterator<File> fileIterator = FileUtils.iterateFiles(new File(dataDir),
                new SuffixFileFilter(".warc.gz"),
                DirectoryFileFilter.INSTANCE);

        while (fileIterator.hasNext()) {
            String warcPath = fileIterator.next().getPath();
            GZIPInputStream gzInStream = new GZIPInputStream(new FileInputStream(warcPath));
            DataInputStream inStream = new DataInputStream(gzInStream);

            WarcRecord thisWorcRecord;
            Analyzer analyzer = new WhiteSpaceAnalyzer();
            while ((thisWorcRecord = WarcRecord.readNextWarcRecord(inStream)) != null) {
                if (thisWorcRecord.getHeaderRecordType().equals("response")) {
                    WarcHTMLResponseRecord htmlRecord = new WarcHTMLResponseRecord(thisWorcRecord);
                    String trecID = htmlRecord.getTargetTrecID();
                    String html = htmlRecord.getRawRecord().getContentUTF8();
                    org.jsoup.nodes.Document soup = Jsoup.parse(html);
                    String title = soup.title();
                    Document doc = new Document(analyzer);
                    doc.setContent("title", title);
                    doc.setContent("id", trecID);
                    indexer.addDocument(doc);
                }
            }
        }
        indexer.close();
    }
}
