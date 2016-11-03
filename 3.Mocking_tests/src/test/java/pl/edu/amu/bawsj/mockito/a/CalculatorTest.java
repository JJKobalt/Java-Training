package pl.edu.amu.bawsj.mockito.a;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
// ok
@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    @Mock
    DataProvider dataProvider;

    Calculator calculator;

    @Before
    public void setUp(){
        calculator = new Calculator(dataProvider);

        when(dataProvider.get()).thenReturn(10.0);

    }

    @Test
    public void shouldPerformSomeCalculationCorrectly() {

        Assert.assertEquals(100.0,calculator.calculate(),0.001);
    }

    @Test
    public void getShouldExecuteExactlyTwoTimes() {
        calculator.calculate();
        Mockito.verify(dataProvider,Mockito.times(2)).get();
    }

}