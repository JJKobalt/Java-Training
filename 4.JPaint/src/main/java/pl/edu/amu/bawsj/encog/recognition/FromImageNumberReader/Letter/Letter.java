package pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter;

import java.util.Arrays;

/**
 * Created by JanJa on 10.02.2017.
 */
public class Letter {

    BoardArray pixels;

    public Letter(BitImage rawLetter) {
        this.pixels = rawLetter.pixels;

        normalize();


    }

    private void normalize() {
        cutRedundantLines();
        makeSquare();
        scaleSizesToTen();
    }

    private void makeSquare() {

        if (pixels.getWidth() > pixels.getHeight()) makeHigher();
        if (pixels.getWidth() < pixels.getHeight()) makeWider();


    }

    private void makeWider() {
        int size = pixels.getHeight();
        LiftSizesTo(size);
    }

    private void makeHigher() {
        int size = pixels.getWidth();
        LiftSizesTo(size);
    }

    private void LiftSizesTo(int size) {
        int[][] arr = new int[size][size];

        for (int[] row : arr) Arrays.fill(row, ColorBinary.WHITE.value);

        BoardArray newPixels = new BoardArray(arr);
        newPixels.overwriteFrom(pixels);
        pixels = newPixels;
    }


    public void cutRedundantLines() {
        cutAtTop();
        cutAtBottom();
    }

    private void cutAtTop() {
        int[] line = pixels.getHorizontalLineArray(0);
        if (containsBlack(line)) return;
        else {
            pixels.removeHorizontalLine(0);
            cutAtTop();
        }
    }

    private void cutAtBottom() {
        int[] line = pixels.getHorizontalLineArray(pixels.getHeight() - 1);
        if (containsBlack(line)) return;
        else {
            pixels.removeHorizontalLine(pixels.getHeight() - 1);
            cutAtBottom();
        }
    }


    private boolean containsBlack(int[] line) {
        for (int i : line) {
            if (i == ColorBinary.BLACK.value) return true;
        }
        return false;
    }


    private void scaleSizesToTen() {
        int[][] normalizedPixels = new int[10][10];

        double widthSize = Double.valueOf(pixels.getWidth() - 1) / 10;
        double heightSize = Double.valueOf(pixels.getHeight() - 1) / 10;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                normalizedPixels[i][j] = getColorInSection(j, i, widthSize, heightSize);
            }
        }
        pixels = new BoardArray(normalizedPixels);
    }


    public int getColorInSection(int x, int y, double widthSize, double heightSize) {
        int startX = new Double(x * widthSize).intValue();
        int endX = new Double(x * widthSize + widthSize).intValue();
        int startY = new Double(y * heightSize).intValue();
        int endY = new Double(y * heightSize + heightSize).intValue();


        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {

                if (pixels.get(j, i) == ColorBinary.BLACK.value) {
                    return ColorBinary.BLACK.value;
                }
            }
        }
        return ColorBinary.WHITE.value;
    }


    public double[] toDoubleArray() {

        double[] doubleArr =new double[pixels.getWidth() * pixels.getHeight()];
        for(int i=0;i<pixels.getHeight();i++)
        {
            for(int j=0;j<pixels.getWidth();j++)
            {
                doubleArr[i*pixels.getHeight()+j] = Double.valueOf(pixels.get(j,i));

            }
        }

        return doubleArr;
    }


    public String toString() {
        return pixels.toString();
    }

}
