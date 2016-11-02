package pl.edu.amu.bawsj.mockito.c;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

/**
 * Created by Bocian on 03.02.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class StringCreatorTest {

    @Mock
    SoutPrinter soutPrinter;

    StringCreator stringCreator;


    @Before
    public void setUp() {
        stringCreator = new StringCreator(soutPrinter);

        Mockito.doAnswer(invocation ->{
                {
                    System.out.println(invocation.getArguments()[0]);
                }
                return null;
            }
        ).when(soutPrinter).print(Matchers.anyString());

    }
    @Test
    public void shouldPerformSomeCalculationCorrectly() {

        stringCreator.create();
    }

    @Test
    public void shouldExecuteExactlyTwoTimes() {

        stringCreator.create();
        Mockito.verify(soutPrinter, Mockito.times(2)).print(Matchers.anyObject());
    }



}