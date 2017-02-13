package pl.edu.amu.bawsj.encog.numerrecognition.newReader.BitImageCutter.States;

import pl.edu.amu.bawsj.encog.numerrecognition.newReader.ColorBinary;
import pl.edu.amu.bawsj.encog.numerrecognition.newReader.BitImageCutter.ChangeCuttingStateListener;


import java.util.stream.IntStream;

/**
 * Created by JanJa on 11.02.2017.
 */
public class InWhiteState implements CuttingState {

    ChangeCuttingStateListener listener;

    public InWhiteState(ChangeCuttingStateListener listener) {
        this.listener = listener;
    }


    @Override
    public void sendLine(int[] line) {

        boolean containsBlack = IntStream.of(line).anyMatch(x -> x == ColorBinary.BLACK.value);
        if(containsBlack){
            CuttingState state = new InBlackState(listener);
            state.sendLine(line);
            listener.changeState(state);
        }

    }

}
