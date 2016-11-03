package pl.edu.amu.bawsj.mockito.b;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

import static org.mockito.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
public class DataConcatenatorTest {

    @Mock
    DataChanger dataChanger;


    DataConcatenator dataConcatenator;
    Data data;

    @Before
    public void setUp() {
        dataConcatenator = new DataConcatenator(dataChanger);
    }


    // co ten test robi. Jakas ma konkretna nazwe?
    @Test
    public void shouldNameThisFunctionInACorrectWay() {


        Mockito.doAnswer(invocation -> {
                    //Pytanie: ten przykład działa
                    data.setA("XXX");
                    data.setB("XXX");

                    //Ale ten sposób
                    //data = new Data("ZZZ","ZZZ");
                    // Już nie, dlaczego?

            // dlatego, ze tworzysz tutaj nowy obiekt, a masz zmienić tylko ten co dostaniesz.

                    return null;
                }
        ).when(dataChanger).change(Matchers.anyObject());






        data = new Data("YYY", "YYY");
        String answer = dataConcatenator.concatenate(data);
        Assert.assertEquals("XXX:XXX",answer);
    }
}