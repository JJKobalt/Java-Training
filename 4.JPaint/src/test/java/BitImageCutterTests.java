import org.junit.Assert;
import org.junit.Test;
import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.BitImage;
import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.BitImageCutter.BitImageCutter;
import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.Letter;

import java.io.IOException;
import java.util.List;

/**
 * Created by JanJa on 11.02.2017.
 */
public class BitImageCutterTests {


    @Test
    public void cutHorizontalBitImageCutterShouldWork() {
        int[][] arr = {{1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1}};

        BitImage image = new BitImage(arr);
        BitImageCutter cutter = new BitImageCutter();
        List<BitImage> list = cutter.cutBitImageHorizontal(image);
        Assert.assertEquals(2, list.size());

    }


    @Test
    public void cutVerticalBitImageCutterShouldWork() {
        int[][] arr = {{1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1}};

        BitImage image = new BitImage(arr);
        BitImageCutter cutter = new BitImageCutter();
        List<BitImage> list = cutter.cutBitImageVertical(image);

        Assert.assertEquals(2, list.size());

    }


    @Test
    public void BitImageCutterShouldWork() throws IOException {


        int[][] arr = {{1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1}};

        BitImage image = new BitImage(arr);


        BitImageCutter cutter = new BitImageCutter();
        List<Letter> letters = cutter.BitImageToListOfLetters(image);

        Assert.assertEquals(6, letters.size());
    }


}
