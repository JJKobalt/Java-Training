
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.BitImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by JanJa on 10.02.2017.
 */
public class BitImageTests {


    @Test
    @Ignore
    public void BitImageFromArrayShouldWork() {
        int[][] arr = {{1, 1, 0}, {1, 1, 0}, {1, 1, 0}};

        BitImage image = new BitImage(arr);

        System.out.println(image.toString());
    }


    @Test
    @Ignore
    public void BitImageFromBufferedImageShouldWork() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test1.png").getFile());
        BufferedImage testImg = ImageIO.read(file);


        BitImage image = new BitImage(testImg);

        System.out.println(image.toString());
    }


    @Test
    public void invertShouldWork() throws IOException {


        int[][] arr = {{1, 1,},
                {1, 0},
                {1, 0},
                {1, 1}};

        BitImage image = new BitImage(arr);

        image.invert();

        Assert.assertEquals(2,image.getHeight());

    }


}
