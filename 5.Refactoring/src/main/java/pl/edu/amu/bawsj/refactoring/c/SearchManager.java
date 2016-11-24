package pl.edu.amu.bawsj.refactoring.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by JanJa on 23.11.2016.
 */

// przyszlosciowo: jezeli mas zklase, ktora ma w nazwie Manager, wiedz ze cos sie dzieje...
class SearchManager {
    private BufferedReader reader;
    private String searched;
    private String line;
    boolean found;


    void newSearch(String arg) throws IOException {

        initializeSearch(arg);
        search();

    }

    private void initializeSearch(String arg) {
        searched = arg;
        found = false;
        reader = setReader();
    }

    private BufferedReader setReader() {
        InputStream inputStream = C.class.getClassLoader().getResourceAsStream("imieniny.txt");
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    private void search() throws IOException {
        while ((getNewLine()) != null) {

            if (line.trim().equals(searched.trim())) {
                found = true;
                break;
            }
        }
    }


    private void closeSearch() throws IOException {
        found = false;
        reader.close();
    }

    private String getNewLine() throws IOException {
        return line = reader.readLine();
    }

    void report() throws IOException {
        if (found) {
            System.out.println(searched + " istnieje!");

        } else {
            System.out.println(searched + " nie istnieje!");
        }
        closeSearch();
    }
}
