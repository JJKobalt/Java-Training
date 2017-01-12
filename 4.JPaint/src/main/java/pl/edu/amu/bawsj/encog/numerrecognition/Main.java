package pl.edu.amu.bawsj.encog.numerrecognition;


import pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.ImageNumberReader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

/**
 * Created by JanJa on 05.01.2017.
 */
public class Main {

    File file;

    Main() {
        ClassLoader classLoader = getClass().getClassLoader();
        String test1 = "testWieloliniowy.png";
        String test2 = "test1.png";
        String test3 = "wszystkieZnaki.png";
        String test4 = "learning/0zero.png";
        String test5 = "learning/1one.png";
        String test6 = "learning/2two.png";
        String test7 = "learning/3three.png";
        String test8 = "learning/4four.png";
        String test9 = "learning/5five.png";
        String test10 = "learning/6six.png";
        String test11 = "learning/7seven.png";
        String test12 = "learning/8eight.png";
        String test13 = "learning/9nine.png";
        String test14 = "learning/plus.png";
        String test15 = "learning/minus.png";
        String test16 = "learning/multiple.png";
        String test17 = "learning/divide1.png";
        String test18 = "learning/divide2.png";
        String test19 = "learning/equation.png";
        file = new File(classLoader.getResource(test1).getFile());

    }

    public static void main(final String args[]) {

        Main m = new Main();

        try {
            BufferedImage testImg = ImageIO.read(m.file);
            ImageNumberReader imageNumberReader = new ImageNumberReader();
            String answer = imageNumberReader.ReadFromImage(testImg);
            System.out.println(answer);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("nie znaleziono");
        }

    }
}
