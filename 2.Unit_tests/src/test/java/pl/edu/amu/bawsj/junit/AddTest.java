//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package pl.edu.amu.bawsj.junit;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pl.edu.amu.bawsj.junit.Add;

public class AddTest {
    public AddTest() {
    }

    @Test
    public void shouldAddTwoPositiveNumbers() {
        Add add = new Add();
        int a = add.go(2, 3);
        Assert.assertEquals((long)a, 5L);
    }

    @Test
    public void shouldAddTwoZeros() {
        Add add = new Add();
        int a = add.go(0, 0);
        Assert.assertEquals(0L, (long)a);
    }

    @Test
    @Ignore
    public void shouldHandleIntegerOverflow() {
        Add add = new Add();
        int a = add.go(2147483647, 100);
        Assert.assertTrue(a > 0);
    }
}
