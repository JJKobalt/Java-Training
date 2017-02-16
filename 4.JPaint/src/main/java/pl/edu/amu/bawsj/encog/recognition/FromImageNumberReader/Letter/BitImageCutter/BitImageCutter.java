package pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.BitImageCutter;

import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.BitImage;
import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.BitImageCutter.States.CuttingState;
import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.BitImageCutter.States.InWhiteState;
import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.Letter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanJa on 10.02.2017.
 */
public class BitImageCutter {

    CuttingState state;


    public List<Letter> BitImageToListOfLetters(BitImage bitImage) {
        {
            List<Letter> letters = new ArrayList<>();
            List<BitImage> horizontalLines = cutBitImageHorizontal(bitImage);

            for (BitImage lineOfLetters : horizontalLines) {
                List<BitImage> lineLetters = cutBitImageVertical(lineOfLetters);

                for (BitImage rawLetter : lineLetters) {
                    letters.add(new Letter(rawLetter));
                }

            }


            return letters;
        }


    }

    public List<BitImage> cutBitImageHorizontal(BitImage image) {

        List<BitImage> horizontalLines = new ArrayList<>();

        state = new InWhiteState(new ChangeCuttingStateListener() {
            @Override
            public void addToList(BitImage image) {

                horizontalLines.add(image);
            }

            @Override
            public void changeState(CuttingState newState) {
                state = newState;

            }
        });

        for (int i = 0; i < image.getHeight(); i++) {
            int[] line = image.getHorizontalLine(i);
            state.sendLine(line);

        }


        return horizontalLines;

    }

    public List<BitImage> cutBitImageVertical(BitImage lineOfLetters) {

        List<BitImage> bitImageLetters = new ArrayList<>();

        state = new InWhiteState(new ChangeCuttingStateListener() {

            @Override
            public void addToList(BitImage image) {
                image.invert();
                bitImageLetters.add(image);
            }

            @Override
            public void changeState(CuttingState newState) {
                state = newState;

            }
        });


        for (int i = 0; i < lineOfLetters.getWidth(); i++) {
            int[] line = lineOfLetters.getVerticalLineArray(i);


            state.sendLine(line);


        }
        return bitImageLetters;
    }


}
