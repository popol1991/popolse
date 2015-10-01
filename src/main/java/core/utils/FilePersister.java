package core.utils;

import java.io.*;

/**
 * Created by Kyle on 7/25/15.
 */
public class FilePersister {
    public static void saveObject(String path, Object obj) {
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static Object loadObject(String path) {
        Object obj = null;
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            obj = in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return obj;
    }

    /**
     * Delete a given directory recursively
     * @param path: Directory path
     * @return True if the dir were deleted successfully, False otherwise
     */
    public static boolean delete(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            return true;
        }

        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (String child : children) {
                boolean success = delete(child);
                if (!success) {
                    return false;
                }
            }
        }

        return dir.delete();
    }
}
