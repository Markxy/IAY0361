import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public static String[] readFile(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }

    public static void writeToFile(String filename, String contents) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(filename, "UTF-8");
        writer.println(contents);
        writer.close();
    }

}
