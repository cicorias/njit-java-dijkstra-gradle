package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dijkstra {

}

final class FileHelper {
    public long lines = 0;
    public int columns = 0;
    List<List<String>> records = new ArrayList<>();

    // File _file;
    void ReadFile(String fileName) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(getFilePath(fileName)));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                if (0 == columns && 0 == lines)
                    columns = values.length;
                else if (0 == values.length)
                    break;
                else if (columns != values.length)
                    throw new IOException("all columns are not same failed at line " + (lines + 1));
                
                lines++;
                records.add(Arrays.asList(values));
            }
        }
        finally {
            if (null != br) br.close();
        }
       
    }

    String getFilePath(String fileName) {
        // if the file contains a platform file separator
        // assume the arg is fully qualified and findable
        String rv = null;
        if (fileName.contains(File.separator)) {
            rv = fileName;
        } else {
            String currentDirectory = System.getProperty("user.dir");
            rv = currentDirectory + File.separator + fileName;
        }
        return rv;

    }
}
