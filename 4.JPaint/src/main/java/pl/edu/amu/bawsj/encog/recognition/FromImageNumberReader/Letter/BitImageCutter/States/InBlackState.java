package pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.BitImageCutter.States;

import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.ColorBinary;
import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.BitImage;
import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.BitImageCutter.ChangeCuttingStateListener;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by JanJa on 11.02.2017.
 */
public class InBlackState implements CuttingState {

    ChangeCuttingStateListener listener;
    List<int[]> linesWithContent;


    public InBlackState(ChangeCuttingStateListener listener) {
        this.listener = listener;
        linesWithContent = new LinkedList<>();
    }


    @Override
    public void sendLine(int[] line) {

        boolean containsBlack = IntStream.of(line).anyMatch(x -> x == ColorBinary.BLACK.value);

        if (containsBlack) {

            linesWithContent.add(line);
        } else {

            int[][] pixels = linesWithContent.toArray(new int[0][]);
            BitImage lineOfLetters = new BitImage(pixels);
            listener.addToList(lineOfLetters);
            listener.changeState(new InWhiteState(listener));
        }


    }
}
