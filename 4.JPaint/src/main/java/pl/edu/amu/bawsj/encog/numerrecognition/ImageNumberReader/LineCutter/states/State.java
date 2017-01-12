package pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.LineCutter.states;

import pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.ColorBinary;

/**
 * Created by JanJa on 05.01.2017.
 */
public abstract class State {

    public abstract void takeLine(int[] lineHorizontal);


     boolean isEntirelyWhite(int[] lineHorizontal) {
        for(int i: lineHorizontal)
        {
            if(i == ColorBinary.BLACK.value)
            {
                return false;

            }
        }
        return true;
    }
}
