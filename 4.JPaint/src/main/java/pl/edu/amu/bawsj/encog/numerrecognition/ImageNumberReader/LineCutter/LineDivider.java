package pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.LineCutter;

import pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.LineCutter.states.InWhiteState;
import pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.LineCutter.states.State;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanJa on 05.01.2017.
 */
public class LineDivider {

    List<int[][]> lines;
    public State state;

    public List<int[][]> getLines() {
        return lines;
    }

    public LineDivider() {
        lines = new ArrayList<>();
        state = new InWhiteState(this);
    }


    public void getLine(int[] lineHorizontal) {

        state.takeLine(lineHorizontal);
    }

    public void addToLines(int[][] line) {

        lines.add(line);

    }
}
