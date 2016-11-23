package pl.edu.amu.bawsj.refactoring.c;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SearchMenagerTest {


    @Test
    public void shouldFindCorrectName() throws IOException {
        C c = new C();
        c.searcher = new SearchManager();
        c.searcher.newSearch("Jan");
        Assert.assertEquals(true, c.searcher.found);
    }

    @Test
    public void shouldNotFindWrongName() throws IOException {
        C c = new C();
        c.searcher = new SearchManager();
        c.searcher.newSearch("definitely not name");
        Assert.assertEquals(false, c.searcher.found);
    }

    @Test
    public void shouldRestart() throws IOException {
        C c = new C();

        c.searcher = new SearchManager();
        c.searcher.newSearch("Jan");
        Assert.assertEquals(true, c.searcher.found);
        c.searcher.newSearch("definitely not name");
        Assert.assertEquals(false, c.searcher.found);
    }

    @Test
    public void shouldReturnStableResults() throws IOException {
        C c = new C();
        c.searcher = new SearchManager();
        c.searcher.newSearch("Jan");
        Assert.assertEquals(true, c.searcher.found);
        c.searcher = new SearchManager();
        c.searcher.newSearch("Jan");
        Assert.assertEquals(true, c.searcher.found);
    }


}