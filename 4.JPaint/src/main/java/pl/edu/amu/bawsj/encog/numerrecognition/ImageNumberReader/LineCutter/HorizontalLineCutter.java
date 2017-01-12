package pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.LineCutter;

import pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.LineCutter.states.InWhiteState;
import pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.LineCutter.states.State;
import pl.edu.amu.bawsj.jpaint.shape.Line;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanJa on 05.01.2017.
 */
public class HorizontalLineCutter {


    LineDivider lineDivider;

    public HorizontalLineCutter(int[][] binaryPixels) {



        lineDivider= new LineDivider();


        for (int i = 0; i < binaryPixels[0].length; i++) {

            int[] lineHorizontal = getHorizontalLine(binaryPixels, i);
            lineDivider.getLine(lineHorizontal);
        }


    }

    private int[] getHorizontalLine(int[][] binaryPixels, int i) {
        int[] lineHorizontal = new int[binaryPixels.length];
        for (int j = 0; j < binaryPixels.length; j++) {
            lineHorizontal[j] = binaryPixels[j][i];
        }
        return lineHorizontal;
    }


    public List<int[][]> getHorizontalLines()
    {
       return  lineDivider.getLines();
    }

}


