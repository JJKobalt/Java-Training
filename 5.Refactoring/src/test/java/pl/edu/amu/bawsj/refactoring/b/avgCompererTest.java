package pl.edu.amu.bawsj.refactoring.b;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.when;

/**
 * Created by JanJa on 22.11.2016.
 */
// strasznie CI nie poszło z nazwa tego testu...
@RunWith(MockitoJUnitRunner.class)
public class avgCompererTest {

    @Mock
    BufferedReader mockReader;



    @Test
    public void shouldntPerformOnEmptyFile() throws IOException {
        when(mockReader.readLine()).thenReturn(null);
        B b = new B(mockReader);
        Assert.assertEquals(Double.MIN_VALUE, b.getMaxLineAvg(), 0.00001);
    }



    @Test
    public void shouldPerformSomeCalculations() {

        B b = new B();
        double d = b.getAvgOfLine(new String[]{"0", "2", "2", "2"});
        Assert.assertEquals(2, d, 0);
    }

    @Test
    public void shouldReturnStableResults() {

        B b = new B();
        double x = b.getAvgOfLine(new String[]{"0", "8", "2", "0.5"});
        double y = b.getAvgOfLine(new String[]{"0", "0.5", "8", "2"});
        Assert.assertEquals(x, y, 0);
    }


    @Test
    public void shouldReturnTheBiggestAvgFromLines() throws IOException {

        B b = new B(mockReader);
        String[] line = {"0,1,1,1", "0,1,3,3", "0,5,3,1", "0,4,4,4", "0,1,1,1"};

        final int[] i = {-1};

        Mockito.doAnswer(invocation -> {

                    i[0]++;
                    if (i[0] >= line.length) return null;
                    else return line[i[0]];
                }
        ).when(mockReader).readLine();

        Assert.assertEquals(4d, b.getMaxLineAvg(),0);



    }


    @Test
    public void shouldPerformIndepentlyFromPrevious() throws IOException {
// Z góry przepraszam za to jak to wygląda ,ale ze względu na to, że mockito używa tylko atrybutów final, nie mogłem tego zrobić lepiej
        B b = new B(mockReader);
        String[][] line = {{"0,1,1,1", "0,1,3,3", "0,4,4,4", "0,4,4,4", "0,1,1,1"}, {"0,3,3,3", "0,1,1,1", "0,1,1,1", "0,3,3,3", "0,1,1,1"}};
        final int[] dataChenger = {0};
        final int[] i = {-1};
        Mockito.doAnswer(invocation -> {

                    i[0]++;
                    if (i[0] >= line[0].length) {
                        i[0] = -1;
                        return null;
                    }

                    return line[dataChenger[0]][i[0]];
                }
        ).when(mockReader).readLine();

        Assert.assertEquals(4d, b.getMaxLineAvg(), 0);

        // masakrycznie to wyglada...
        dataChenger[0]++; //change data set

        Assert.assertEquals(3d, b.getMaxLineAvg(), 0);
    }



}
