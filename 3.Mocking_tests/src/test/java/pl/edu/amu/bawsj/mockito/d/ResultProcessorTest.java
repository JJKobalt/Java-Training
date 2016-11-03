package pl.edu.amu.bawsj.mockito.d;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.Random;

@RunWith(MockitoJUnitRunner.class)
public class ResultProcessorTest {

    @Mock
    ResultProvider resultProvider;

    ResultProcessor resultProcessor;


    @Test
    public void shouldCalculateWithoutExceptions() {

        resultProcessor = new ResultProcessor(resultProvider);
        Mockito.when(resultProvider.provide()).thenReturn(10.0);

        Assert.assertEquals("10.0 10.0", resultProcessor.provide());
    }

    @Test
   @Ignore
    public void shouldCalculateWithExceptions() {

        resultProcessor = new ResultProcessor(resultProvider);
        Mockito.doAnswer(invocation -> {
            throw new ArithmeticException("Division by zero");

        }).when(resultProvider).provide();

        Assert.assertEquals("10.0 10.0", resultProcessor.provide());
    }






}