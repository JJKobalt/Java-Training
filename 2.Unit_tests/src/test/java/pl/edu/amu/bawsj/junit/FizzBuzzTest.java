package pl.edu.amu.bawsj.junit;

import org.junit.Assert;
import org.junit.Test;
public class FizzBuzzTest {
    public FizzBuzzTest() {
    }

    @Test
    public void shouldLoopPerform100times() {
        FizzBuzz fb = new FizzBuzz();
        Assert.assertEquals(100L, (long)fb.checkLoop());
    }

    @Test
    public void shouldReturnGoodValues() {
        FizzBuzz fb = new FizzBuzz();
        Assert.assertEquals(fb.checkValueFor(3), "Fizz");
        Assert.assertEquals(fb.checkValueFor(4), "4");
        Assert.assertEquals(fb.checkValueFor(5), "Buzz");
        Assert.assertEquals(fb.checkValueFor(1), "1");
        Assert.assertEquals(fb.checkValueFor(100), "Buzz");
        Assert.assertEquals(fb.checkValueFor(15), "FizzBuzz");
    }
}
