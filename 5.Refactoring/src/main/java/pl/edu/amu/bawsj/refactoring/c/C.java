package pl.edu.amu.bawsj.refactoring.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// znajdź błąd
public class C {
    SearchManager searcher;

    public C() {
        // troche slabo ta metoda tutaj wyglada, robi tylko jedna linijke, ktora z powodzeniem moglbys tutaj zrobic.
        setSearcher();
    }

    public static void main(String[] args) throws IOException {

        C c = new C();
        c.checkIfExist("Jan", "Jansss");
    }


    public void checkIfExist(String... args) throws IOException
    {
        if (CheckIfEmpty(args))
        {
            System.out.println("nie podałeś imienia");
            return;
        }


        for (String arg : args) {
            searcher.newSearch(arg);
            searcher.report();
        }
    }


    private static boolean CheckIfEmpty(String[] args) {
        return args.length == 0;
    }

    private void setSearcher() {
        searcher = new SearchManager();
    }

    void setSearcher(SearchManager searcher) {
        this.searcher = searcher;
    }
}
