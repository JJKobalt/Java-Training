package pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader.NeuronNetwork;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by JanJa on 08.01.2017.
 */
public class TrainingMaterialHandler {

    String fileName = "trainingMaterial.txt";
    String filePath;
    List<double[]> input;
    List<double[]> idealOutput;

    HashMapParser hashMapParser;



    public TrainingMaterialHandler() {
        hashMapParser= new HashMapParser();
        ClassLoader classLoader = getClass().getClassLoader();
        filePath = classLoader.getResource(fileName).getPath();
        hashMapParser.initializeStringToArrayHashMap();
        input = new ArrayList<>();
        idealOutput = new ArrayList<>();
        readTrainingFile();


    }



    private void readTrainingFile() {

        String line = new String();
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
                   // System.out.println("InputArray");
                  //  printArray(inputArray);
                    input.add(inputArray);


                    inputLine = new StringBuilder();

                    double[] outputArray = toOutputArray(splitLine[1]);


               //     printArray(outputArray);
                    idealOutput.add(outputArray);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void printArray(double[] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.print(" " + tab[i]);
        }
        System.out.println();
    }


    private double[] toOutputArray(String s) {

        s.replace(" ", "");
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
}
