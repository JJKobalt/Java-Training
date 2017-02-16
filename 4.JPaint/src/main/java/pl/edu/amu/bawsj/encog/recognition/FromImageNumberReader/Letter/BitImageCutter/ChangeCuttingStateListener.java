package pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.BitImageCutter;

import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.BitImage;
import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.BitImageCutter.States.CuttingState;

/**
 * Created by JanJa on 11.02.2017.
 */
public interface ChangeCuttingStateListener {

void addToList(BitImage image);

void changeState(CuttingState state);

}
