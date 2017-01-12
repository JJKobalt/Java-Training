package pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.LineCutter.states;

import pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.LineCutter.LineDivider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanJa on 05.01.2017.
 */
public class InBlackState extends State {
    LineDivider lineDivider;
    List<int[]> horizontalLines;


    public InBlackState(LineDivider lineDivider) {
        this.lineDivider = lineDivider;
        horizontalLines = new ArrayList<>();
    }


    @Override
    public void takeLine(int[] horizontalLine) {


        if (isEntirelyWhite(horizontalLine)) {
            changeState(horizontalLine);
        } else {

            horizontalLines.add(horizontalLine);
        }

    }


    private void changeState(int[] lineHorizontal) {

        lineDivider.state = new InWhiteState(lineDivider);
        lineDivider.addToLines(horizontalLinesToArray());
    }

    private int[][] horizontalLinesToArray() {


        int[][] horizontalLinesArray = new int[horizontalLines.get(0).length][horizontalLines.size()];
      //  System.out.println("horizontalLinesArray.length "+ horizontalLinesArray.length + " horizontalLinesArray[0].length " +horizontalLinesArray[0].length);

        for(int i=0; i<horizontalLinesArray[0].length;i++)
        {
            for(int j=0; j< horizontalLinesArray.length;j++) {


                horizontalLinesArray[j][i] = horizontalLines.get(i)[j];
            }
        }

        return horizontalLinesArray;
    }
}

