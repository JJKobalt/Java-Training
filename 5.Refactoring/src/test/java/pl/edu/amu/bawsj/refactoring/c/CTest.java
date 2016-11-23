package pl.edu.amu.bawsj.refactoring.c;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

/**
 * Created by JanJa on 23.11.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class CTest {

    @Mock
    SearchManager mockSearchManager;


    @Test
    public void NewSearchShouldPerformForEveryParametr() throws IOException {

        C c = new C();
        c.setSearcher(mockSearchManager);
        c.checkIfExist("One","Two","Three");
        Mockito.verify(mockSearchManager, Mockito.times(3)).newSearch(Matchers.anyString());
    }


}
