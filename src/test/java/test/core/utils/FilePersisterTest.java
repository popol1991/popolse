package test.core.utils;

import core.utils.FilePersister;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

/**
 * Created by Kyle on 7/25/15.
 */
public class FilePersisterTest {

    public static final String TEST_PATH = "testpath";

    @Before
    public void setup() {
        File testPath = new File(TEST_PATH);
        testPath.mkdir();
    }

    @Test
    public void ObjectPersistTest() {
        String path = TEST_PATH + "/" + "test.bin";
        HashMap<String, String> obj = new HashMap<String, String>();
        obj.put("key1", "val1");
        FilePersister.saveObject(path, obj);
        HashMap<String, String> loaded = (HashMap<String, String>) FilePersister.loadObject(path);
        assertTrue(obj.equals(loaded));
    }

    @After
    public void teardown() {
        FilePersister.delete(TEST_PATH);
    }
}
