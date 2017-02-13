package pl.edu.amu.bawsj.encog.numerrecognition.TrainingMaterialCreator;

import java.io.*;

import pl.edu.amu.bawsj.encog.numerrecognition.newReader.FromImageNumberReader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanJa on 13.02.2017.
 */
public class TrainingMaterialWriter {

String trainingMaterialname = "trainingMaterial";
    List<TrainingSetEntity> listOfTraining;
    public PrintWriter writer;
    ClassLoader classLoader;

    TrainingMaterialWriter() {

        listOfTraining = new ArrayList<>();
        classLoader = getClass().getClassLoader();

        listOfTraining.add(new TrainingSetEntity("0", "learning/0.png"));
        listOfTraining.add(new TrainingSetEntity("1", "learning/1.png"));
        listOfTraining.add(new TrainingSetEntity("2", "learning/2.png"));
        listOfTraining.add(new TrainingSetEntity("3", "learning/3.png"));
        listOfTraining.add(new TrainingSetEntity("4", "learning/4.png"));
        listOfTraining.add(new TrainingSetEntity("5", "learning/5.png"));
        listOfTraining.add(new TrainingSetEntity("6", "learning/6.png"));
        listOfTraining.add(new TrainingSetEntity("7", "learning/7.png"));
        listOfTraining.add(new TrainingSetEntity("8", "learning/8.png"));
        listOfTraining.add(new TrainingSetEntity("9", "learning/9.png"));
        listOfTraining.add(new TrainingSetEntity("+", "learning/+.png"));
        listOfTraining.add(new TrainingSetEntity("-", "learning/-.png"));
        listOfTraining.add(new TrainingSetEntity("*", "learning/multiplication.png"));
        listOfTraining.add(new TrainingSetEntity(":", "learning/division1.png"));
        listOfTraining.add(new TrainingSetEntity("/", "learning/division2.png"));
        listOfTraining.add(new TrainingSetEntity("=", "learning/equals.png"));

    }

    private void setWriter() throws IOException {

        writer =
                new PrintWriter(
                        new File(classLoader.getResource("trainingMaterial.txt").getPath()));


    }

    public static void main(final String args[]) {


        TrainingMaterialWriter trainingWriter = new TrainingMaterialWriter();

        FromImageNumberReader reader = new FromImageNumberReader();
        try {
            trainingWriter.setWriter();



            for (TrainingSetEntity trainingEntity : trainingWriter.listOfTraining) {

                File file =
                        new File(
                                trainingWriter.classLoader.getResource(trainingEntity.filePath).getFile());
                BufferedImage testImg = ImageIO.read(file);

                List<double[]> listOfDoubles = reader.fromImageToDoubleList(testImg);

                trainingWriter.addLearningData(trainingEntity.character, listOfDoubles);

            }


        } catch (IOException e) {
            System.err.println(e.getMessage()+ " " + e.getCause());
        } finally {
            trainingWriter.writer.close();
        }



    }

    private void addLearningData(String character, List<double[]> listOfDoubles) {


        for (double[] letterArray : listOfDoubles) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < letterArray.length; i++) {
                sb.append(letterArray[i]);
                if (i != letterArray.length - 1) sb.append(" ");
                else sb.append("; " + character);
            }

            append(sb.toString());
        }


    }


    public void append(String line) {
        writer.println(line);
    }



}
