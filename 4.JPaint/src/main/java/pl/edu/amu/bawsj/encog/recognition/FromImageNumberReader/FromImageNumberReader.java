package pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader;

import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.BitImage;
import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.Letter;
import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.NeuronNetwork.NeuronInterpreter;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanJa on 11.02.2017.
 */
public class FromImageNumberReader {

    NeuronInterpreter neuronInterpreter;

  public   FromImageNumberReader() {
        neuronInterpreter = new NeuronInterpreter();

    }


    public String readFromImage(BufferedImage image) {

        StringBuilder sb = new StringBuilder();
        List<double[]> listOfDoubles = fromImageToDoubleList(image);

        for (double[] input:listOfDoubles) {
            sb.append(neuronInterpreter.resolveArrayToString(input));
        }
        return sb.toString();
    }



    public List<double[]> fromImageToDoubleList(BufferedImage image)
    {
        List<double[]> doubleList = new ArrayList<>();

        BitImage bitImage = new BitImage(image);
        List<Letter> letters = bitImage.ToLettersList();

        for (Letter letter : letters) {
            doubleList.add(letter.toDoubleArray());
        }

        return doubleList;
    }

}
