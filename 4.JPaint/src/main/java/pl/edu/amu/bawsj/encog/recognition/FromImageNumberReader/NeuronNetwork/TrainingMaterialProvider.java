package pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.NeuronNetwork;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by JanJa on 08.01.2017.
 */
public class TrainingMaterialProvider {

    final String fileName = "trainingMaterial.txt";
    String filePath;
    List<double[]> input;
    List<double[]> idealOutput;

    HashMapParser hashMapParser;



    public TrainingMaterialProvider() {
        hashMapParser= new HashMapParser();
        ClassLoader classLoader = getClass().getClassLoader();
        filePath = classLoader.getResource(fileName).getPath();

        input = new ArrayList<>();
        idealOutput = new ArrayList<>();
        readTrainingFile();


    }

    public double[][] getTrainingInput() {

        double[][] TrainingInput = new double[input.size()][];

        for(int i=0; i< input.size();i++)
        {
            TrainingInput[i]=input.get(i);

        }
        return TrainingInput;
    }

    public double[][] getTrainingOutput() {

        double[][] TrainingOutput = new double[idealOutput.size()][];

        for(int i=0; i< input.size();i++)
        {
            TrainingOutput[i]=idealOutput.get(i);

        }
        return TrainingOutput;
    }


    private void readTrainingFile() {

        String line ;
        System.out.println("readTrainingFile");
        StringBuilder inputLine = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            while ((line = reader.readLine()) != null) {

                inputLine.append(" ");
                if (!line.contains(";")) {
                    inputLine.append(line);
                } else {
                    String[] splitLine = line.split(";");
                    inputLine.append(splitLine[0]);

                    double[] inputArray = stringToDoubleArray(inputLine.toString());
                    input.add(inputArray);

                    double[] outputArray = toOutputArray(splitLine[1]);
                    idealOutput.add(outputArray);

                    inputLine = new StringBuilder();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void printArray(double[] tab) {
        for (double d : tab) {
            System.out.print(" " + d);
        }
        System.out.println();
    }


    private double[] toOutputArray(String s) {
       s = s.replaceAll("\\s+","");


        return hashMapParser.StringOutputToArray(s);
    }

    private double[] stringToDoubleArray(String inputLine) {


        Pattern p = Pattern.compile("(\\d+(?:\\.\\d+))");
        Matcher m = p.matcher(inputLine);

        List<Double> listAnswer = new ArrayList<>();

        while (m.find()) {
            double foundedDouble = Double.parseDouble(m.group(1));
            listAnswer.add(foundedDouble);
        }


        double[] answer = new double[listAnswer.size()];
        for (int i = 0; i < listAnswer.size(); i++) {
            answer[i] = listAnswer.get(i);

        }
        return answer;
    }

}
