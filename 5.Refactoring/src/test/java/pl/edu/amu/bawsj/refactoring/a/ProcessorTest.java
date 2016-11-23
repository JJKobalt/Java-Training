package pl.edu.amu.bawsj.refactoring.a;

import org.junit.Assert;
import org.junit.Test;

public class ProcessorTest
{


    @Test
    public void shouldProcessWhenOpen() {
        A a = new A();
        a.setProcessor(new Processor());
        a.openProcess();

        String testOpen = "testOpen";
        a.process(testOpen);


        Assert.assertEquals(testOpen,a.result.getText());
    }




    @Test
    public void shouldntProcessWhenClose() {
        A a = new A();
        a.setProcessor(new Processor());
        a.closeProcess();
        String testClose = "testClose";
        a.process(testClose);
        Assert.assertEquals("null",a.result.getText());
    }







}