package pl.edu.amu.bawsj.encog.numerrecognition.newReader;

import pl.edu.amu.bawsj.encog.numerrecognition.newReader.BitImageCutter.BitImageCutter;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Created by JanJa on 10.02.2017.
 */
public class BitImage {


    BoardArray pixels;

    private BitImage(int width, int height) {
        pixels = new BoardArray(new int[width][height]);
        invert();
    }


    public int getWidth() {
        return pixels.getWidth();
    }

    public int getHeight() {
        return pixels.getHeight();
    }


    public BitImage(BufferedImage img) {

        this(img.getWidth(), img.getHeight());
        final int white = -1;


        for (int i = 0; i < img.getHeight(); i++) {

            for (int j = 0; j < img.getWidth(); j++) {

                Color c = new Color(img.getRGB(j, i));

                if (c.getRGB() != white) {
                    setBlackfor(j, i);
                } else {
                    setWhitefor(j, i);
                }


            }
        }


    }

    public List<Letter> ToLettersList() {

        BitImageCutter bitImageCutter = new BitImageCutter();
        return bitImageCutter.BitImageToListOfLetters(this);
    }


    public BitImage(int[][] pixels) {

        this.pixels = new BoardArray(pixels);

    }

    public BitImage(BoardArray pixels) {

        this.pixels = pixels;

    }


    public String toString() {
        return pixels.toString();
    }


    void setBlackfor(int x, int y) {
        pixels.set(x, y, ColorBinary.BLACK.value);
    }

    void setWhitefor(int x, int y) {
        pixels.set(x, y, ColorBinary.WHITE.value);
    }




    public int[] getHorizontalLine(int i) {
        return pixels.getHorizontalLineArray(i);
    }



    public int[] getVerticalLineArray(int i) {
      return pixels.getVerticalLineArray(i);
    }



    public void invert() {

       pixels.invert();
    }
}
