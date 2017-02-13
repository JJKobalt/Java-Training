package pl.edu.amu.bawsj.encog.numerrecognition.newReader.BitImageCutter;

import pl.edu.amu.bawsj.encog.numerrecognition.newReader.BitImage;
import pl.edu.amu.bawsj.encog.numerrecognition.newReader.BitImageCutter.States.CuttingState;

/**
 * Created by JanJa on 11.02.2017.
 */
public interface ChangeCuttingStateListener {

void addToList(BitImage image);

void changeState(CuttingState state);

}
