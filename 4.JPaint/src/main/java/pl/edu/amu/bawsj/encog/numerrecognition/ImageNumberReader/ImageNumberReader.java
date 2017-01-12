package pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader;

import pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.LineCutter.*;
import pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.NeuronNetwork.NeuronInterpeter;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by JanJa on 05.01.2017.
 */
public class ImageNumberReader {

    int[][] binaryPixels;
NeuronInterpeter neuronInterpeter;

    public ImageNumberReader() {
     neuronInterpeter = new NeuronInterpeter();
    }

    public String ReadFromImage(BufferedImage img) {


        initializePixelsArray(img);
        List<int[][]> horizontalLines = cutPixelArrayHorizontaly();

        SingleLetterArray singleLetterArray = cutLinesVerticaly(horizontalLines);
        List<double[]> inputList = getInputFromLetterArray(singleLetterArray);

      //  printList(inputList);

        StringBuilder readedText = new StringBuilder();

        for(double[] letter:inputList)
        {
         readedText.append(neuronInterpeter.resolveArrayToString(letter));
        }



return readedText.toString();

    }

    private void printList(List<double[]> inputList) {

    for(double[] input: inputList)
    {
        for(int i=0;i<input.length;i++)
        {
            System.out.print(input[i]+" ");
        }
        System.out.println();
    }

    }

    private List<double[]> getInputFromLetterArray(SingleLetterArray singleLetterArray) {
        return singleLetterArray.getInputValues();
    }

    private SingleLetterArray cutLinesVerticaly(List<int[][]> horizontalLines) {
        SingleLetterArray singleLetterArray = new SingleLetterArray();

        for (int[][] horizontalLine : horizontalLines) {
            singleLetterArray.newLine();
            VerticalLineCutter verticalLineCutter = new VerticalLineCutter(horizontalLine);


            for (int[][] letter : verticalLineCutter.getVerticalLines()) {
                letter = removeRedundantTopAndBottomLines(letter);

                singleLetterArray.addLetter(letter);
            }

        }


        return singleLetterArray;
    }

    private int[][] removeRedundantTopAndBottomLines(int[][] letter) {


        int lineWhereBlackStart = findWhereLettersBegins(letter);
        int lineWhereBlackEnds = findLineWhereBlackEnds(letter);

        int newHeight = lineWhereBlackEnds - lineWhereBlackStart;
        int[][] shorterLetter = new int[newHeight][letter[0].length];

        for (int i = 0; i < shorterLetter.length; i++) {
            for (int j = 0; j < shorterLetter[i].length; j++) {
                shorterLetter[i][j] = letter[i + lineWhereBlackStart][j];
            }
        }


        return shorterLetter;
    }

    private int findLineWhereBlackEnds(int[][] letter) {


        int lineWhereBlackEnds = letter.length;
        for (int i = letter.length-1; i > 0; i--) {


            for (int j = 0; j < letter[i].length; j++) {
                if (letter[i][j] == ColorBinary.BLACK.value) {

                    return i;
                }
            }

        }
        return letter.length;
    }

    private int findWhereLettersBegins(int[][] letter) {
        for (int i = 0; i < letter.length; i++) {

            for (int j = 0; j < letter[i].length; j++) {
                if (letter[i][j] == ColorBinary.BLACK.value) {

                    return i;

                }
            }

        }
        return 0;
    }

    private List<int[][]> cutPixelArrayHorizontaly() {

        HorizontalLineCutter horizontalLineCutter = new HorizontalLineCutter(binaryPixels);
        return horizontalLineCutter.getHorizontalLines();


    }


    private BufferedImage initializePixelsArray(BufferedImage img) {

        binaryPixels = new int[img.getWidth()][img.getHeight()];

        for (int i = 0; i < img.getHeight(); i++) {

            for (int j = 0; j < img.getWidth(); j++) {

                Color c = new Color(img.getRGB(j, i));

                if (c.getRGB() != -1) {
                    img.setRGB(j, i, ColorBinary.BLACK.value);
                    binaryPixels[j][i] = ColorBinary.BLACK.value;
                } else {
                    binaryPixels[j][i] = ColorBinary.WHITE.value;
                }


            }
        }
        return img;
    }

    private void saveToDisk(BufferedImage img, String name) {
        File outputfile = new File("savedPictures/" + name + ".png");
        try {
            ImageIO.write(img, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Nie udalo sie zapisac");
        }
    }
}
