package pl.edu.amu.bawsj.junit;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class MovingAverageTest
{

    // klasa ma wyliczac srednia z ostatnich N podanych liczb
    // jezeli uzytkownik nie poda zadnej liczby a zechce "srednia" to wyrzucany jest wyjatek: illegalstateexception


    // a jakieś testy do tego? Wrzucilem ten jeden tylko po to, żebyście zwrócili uwagę na implementację jakiej użyjecie

    // nie zastanowilo cie to, ze ten test sie wykonuje przeszlo 2.3s ?
    @Test
    public void shouldSupportBigSetOfData()
    {
        MovingAverage movingAverage = new MovingAverage( 3 );
        for( long i = 0; i < 10000000l; i++ )
        {
            movingAverage.push( 3 );
        }
        Assert.assertEquals( 3, movingAverage.getAvg(), 0.003 );
    }
}
