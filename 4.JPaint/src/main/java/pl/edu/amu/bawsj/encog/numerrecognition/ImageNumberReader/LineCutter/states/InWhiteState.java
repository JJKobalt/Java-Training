package pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.LineCutter.states;

import pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.ColorBinary;
import pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.LineCutter.LineDivider;

/**
 * Created by JanJa on 05.01.2017.
 */
public class InWhiteState extends State {

    LineDivider lineDivider;

    public InWhiteState(LineDivider lineDivider) {
        this.lineDivider = lineDivider;

    }


    @Override
    public void takeLine(int[] lineHorizontal) {



        for(int i: lineHorizontal)
        {
            if(i == ColorBinary.BLACK.value)
            {
                changeState( lineHorizontal);
                return;
            }
        }

    }

    private void changeState(int[] lineHorizontal) {

        lineDivider.state = new InBlackState(lineDivider);
        lineDivider.state.takeLine(lineHorizontal);
    }
}
