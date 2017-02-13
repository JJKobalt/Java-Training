import org.junit.Test;
import pl.edu.amu.bawsj.encog.numerrecognition.newReader.BitImage;
import pl.edu.amu.bawsj.encog.numerrecognition.newReader.BitImageCutter.BitImageCutter;
import pl.edu.amu.bawsj.encog.numerrecognition.newReader.FromImageNumberReader;
import pl.edu.amu.bawsj.encog.numerrecognition.newReader.Letter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by JanJa on 12.02.2017.
 */
public class OverallTests {

    @Test
    public void test() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("testWieloliniowy.png").getFile());
        BufferedImage testImg = ImageIO.read(file);


        BitImage image = new BitImage(testImg);
        BitImageCutter cutter = new BitImageCutter();
        BitImage bitImage = new BitImage(testImg);
        List<Letter> letters = cutter.BitImageToListOfLetters(bitImage);
        for(Letter letter: letters)
        {
            System.out.println(letter.toString());
            System.out.println();
        }

    }





    @Test
    public void tryRecognize() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test1.png").getFile());
        BufferedImage testImg = ImageIO.read(file);
FromImageNumberReader reader = new FromImageNumberReader();
        System.out.println(reader.readFromImage(testImg));

    }
}
