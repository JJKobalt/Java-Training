package pl.edu.amu.bawsj.encog.numerrecognition.newReader;

import pl.edu.amu.bawsj.encog.numerrecognition.newReader.NeuronNetwork.NeuronInterpeter;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanJa on 11.02.2017.
 */
public class FromImageNumberReader {

    NeuronInterpeter neuronInterpeter;

  public   FromImageNumberReader() {
        neuronInterpeter = new NeuronInterpeter();

    }


    public String readFromImage(BufferedImage image) {

        StringBuilder sb = new StringBuilder();
        List<double[]> listOfDoubles = fromImageToDoubleList(image);

        for (double[] input:listOfDoubles) {
            sb.append(neuronInterpeter.resolveArrayToString(input));
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
