package pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.LineCutter;

import java.util.List;

/**
 * Created by JanJa on 06.01.2017.
 */
public class VerticalLineCutter {

    LineDivider lineDivider;
    public VerticalLineCutter(int[][] binaryPixels) {




        lineDivider= new LineDivider();


        for (int i = 0; i < binaryPixels.length; i++) {

            int[] lineVertical = getVerticalLine(binaryPixels, i);
            lineDivider.getLine(lineVertical);
        }


    }

    private int[] getVerticalLine(int[][] binaryPixels, int i) {
        int[] lineVertical = new int[binaryPixels[i].length];
        for (int j = 0; j < binaryPixels[i].length; j++) {
            lineVertical[j] = binaryPixels[i][j];
        }

        return lineVertical;
    }


    public List<int[][]> getVerticalLines()
    {
    return    lineDivider.getLines();
    }

}

