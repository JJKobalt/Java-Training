import org.junit.Ignore;
import org.junit.Test;
import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.BitImage;
import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.BitImageCutter.BitImageCutter;
import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.FromImageNumberReader;
import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.Letter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by JanJa on 12.02.2017.
 */
public class FromImageNumberReaderTests {






    @Test
    @Ignore
    public void tryRecognize() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test1.png").getFile());
        BufferedImage testImg = ImageIO.read(file);
        FromImageNumberReader reader = new FromImageNumberReader();
        System.out.println(reader.readFromImage(testImg));

    }
}
