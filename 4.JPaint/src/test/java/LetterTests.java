import org.junit.Assert;
import org.junit.Test;
import pl.edu.amu.bawsj.encog.numerrecognition.newReader.BitImage;
import pl.edu.amu.bawsj.encog.numerrecognition.newReader.BoardArray;
import pl.edu.amu.bawsj.encog.numerrecognition.newReader.Letter;

/**
 * Created by JanJa on 12.02.2017.
 */
public class LetterTests {

    @Test
    public void LetterCreate() {
        int[][] arr = {{1, 1, 0}, {1, 1, 0}, {1, 1, 0}};
        BitImage bitImage = new BitImage(arr);
        Letter letter = new Letter(bitImage);

    }


    @Test
    public void removeRedundantTopLinesShouldWork() {
        int[][] arr = {{1, 1, 1}, {1, 1, 0}, {1, 1, 0}, {1, 1, 1}};
        BitImage bitImage = new BitImage(arr);
        Letter letter = new Letter(bitImage);
        System.out.println(letter.toString());
    }


    @Test
    public void shouldScaleSmallerCorrectly() {
        int[][] arr = {{1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0}
        };
        BitImage bitImage = new BitImage(arr);

        Letter letter = new Letter(bitImage);

        int[][] expected = {{1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        BoardArray boardArr = new BoardArray(expected);
        Assert.assertTrue(boardArr.toString().equals(letter.toString()));


    }

    @Test
    public void shouldScaleBiggerCorrectly() {
        int[][] arr = {{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1,0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        BitImage bitImage = new BitImage(arr);

        Letter letter = new Letter(bitImage);

        int[][] expected = {{0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        BoardArray boardArr = new BoardArray(expected);

        Assert.assertTrue(boardArr.toString().equals(letter.toString()));


    }



    @Test
    public void LettershouldTranslateToDoubleArray() {
        int[][] arr = {{1, 1, 0}, {1, 1, 0}, {1, 1, 0}};
        BitImage bitImage = new BitImage(arr);
        Letter letter = new Letter(bitImage);

        double[] doubleArr = letter.toDoubleArray();
double[] exp = {1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0};



      Assert.assertArrayEquals(exp,doubleArr,0.0);

    }


}
