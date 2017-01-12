/**
 * Created by JanJa on 06.01.2017.
 */


import org.junit.Assert;
import org.junit.Test;
import pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.LineCutter.HorizontalLineCutter;
import pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.LineCutter.LineDivider;
import pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.LineCutter.VerticalLineCutter;
import pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.NeuronNetwork.TrainingMaterialHandler;
import pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.NeuronNetwork.NeuronInterpeter;
import pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.SingleLetterArray;

public class NumberRecognitionTests {

    @Test
    public void test() {
        int[] tab = {1, 1, 0, 0, 1, 0, 0, 1, 1};
        LineDivider lineDivider = new LineDivider();
        lineDivider.getLine(tab);


    }



    @Test
    public void verticalLineTest() {
        int[][] tab = {{1, 1, 0, 0, 1, 0, 0, 1, 1},
                {1, 1, 0, 0, 1, 0, 0, 1, 1}
        };
        VerticalLineCutter verticalLineCutter = new VerticalLineCutter(tab);
        HorizontalLineCutter horizontalLineCutter = new HorizontalLineCutter(tab);
    }

    @Test
    public void makeSquareDimensionsShouldWork() {
        int[][] tab = {{0,0,0,1},{0,0,1,0},{0,0,1,1}
        };
        SingleLetterArray singleLetterArray = new SingleLetterArray();
       int [][] a = singleLetterArray.makeSquareDimensions(tab);



        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j <  a.length; j++)
            {
                System.out.printf("%5d ", a[i][j]);
            }
            System.out.println();
        }
    }

    @Test
    public void isBlackInSectionTest() {
        int[][] tab = {{0,1,1,1},{1,0,1,1},{1,1,0,1},{1,1,1,0}
        };
        SingleLetterArray singleLetterArray = new SingleLetterArray();



        Assert.assertEquals(0,singleLetterArray.isBlackInSection(tab,0.4,0,0));
        Assert.assertEquals(0,singleLetterArray.isBlackInSection(tab,0.4,1,0));
        Assert.assertEquals(0,singleLetterArray.isBlackInSection(tab,0.4,2,0));
        Assert.assertEquals(1,singleLetterArray.isBlackInSection(tab,0.4,3,0));
        Assert.assertEquals(1,singleLetterArray.isBlackInSection(tab,0.4,5,0));

        Assert.assertEquals(0,singleLetterArray.isBlackInSection(tab,0.4,2,2));

        Assert.assertEquals(0,singleLetterArray.isBlackInSection(tab,0.4,9,9));
    }


    @Test
    public void neuralTrainerTests() {
        TrainingMaterialHandler neuralTrainer = new TrainingMaterialHandler();
    }

    @Test
    public void NeuronInterpeterTrainingTest() {
        NeuronInterpeter neuronInterpeter = new NeuronInterpeter();


    }


    @Test
    public void NeuronInterpeterExampleTest() {
        NeuronInterpeter neuronInterpeter = new NeuronInterpeter();
        double[] a={1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0};
                System.out.println( neuronInterpeter.resolveArrayToString(a));


    }




}
