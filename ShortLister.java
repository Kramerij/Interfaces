import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;


import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister {
    /*Then write a java main program ShortLister.java that lets the user pick a text file (JFileChooser)
     which uses the filter to display the short words from the file.
     */
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<String> Words = new ArrayList<>();
        ArrayList<String> lines = new ArrayList<>();
        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                int line = 0;
                while (reader.ready()) {
                    rec = reader.readLine();
                    lines.add(rec);
                    line++;
                }
                for(Object o : lines) {
                    boolean wordLess5 = new ShortWordFilter().accept(o);
                    if (wordLess5 == true){
                        Words.add(o.toString());
                    }
                }
                reader.close();
            }
//put filter here
            System.out.println(Words.toString());
            Main.collectAll(Words.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
