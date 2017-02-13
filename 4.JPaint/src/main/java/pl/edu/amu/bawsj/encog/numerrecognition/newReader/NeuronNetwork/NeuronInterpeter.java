package pl.edu.amu.bawsj.encog.numerrecognition.newReader.NeuronNetwork;

import java.io.*;

import org.encog.Encog;
import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;
import org.encog.persist.EncogDirectoryPersistence;

/**
 * Created by JanJa on 08.01.2017.
 */
public class NeuronInterpeter {


    BasicNetwork network ;
    final String FILENAME = "NeuralNetwork.txt";

    public NeuronInterpeter() {
        initializeNetwork();
    }

    private void initializeNetwork() {
        try {
           File f = new File(FILENAME);
            System.out.println(f);
             network = (BasicNetwork) EncogDirectoryPersistence.loadObject(new File(FILENAME));
            System.out.println("Load Network");



        } catch (Exception e) {
            System.out.println("Create New Network");
            train();
        }
    }

    private void train() {
        MLDataSet trainingSet = setTrainingResources();
        network=getBasicNetwork();
        final ResilientPropagation train = new ResilientPropagation(network, trainingSet);

        System.out.println("Training Started");
        do {
            train.iteration();
            System.out.println("Error " +train.getError());
        } while (train.getError() > 0.006);

        System.out.println("Training Finished");
        double e = network.calculateError(trainingSet);
        System.out.println("Network trained to error: " + e);
        EncogDirectoryPersistence.saveObject(new File(FILENAME), network);
        //  printTrainingResults(trainingSet);


    }

    private MLDataSet setTrainingResources() {
        TrainingMaterialReader neuralTrainer = new TrainingMaterialReader();

        double TrainingInput[][] = neuralTrainer.getTrainingInput();

        double TrainingOutput[][] = neuralTrainer.getTrainingOutput();



        return new BasicMLDataSet(TrainingInput, TrainingOutput);
    }

    private void printTrainingResults(MLDataSet trainingSet) {

        HashMapParser hashMapParser = new HashMapParser();
        hashMapParser.initializeIntCodeToStringHashMap();
        System.out.println("Neural Network Results:");


        for (int i = 0; i < trainingSet.size(); i++) {
            final MLData output = network.compute(trainingSet.get(i).getInput());
            System.out.println("Próbka nr " + i);
            System.out.println("Wartosci idealne");
            printArray(trainingSet.get(i).getIdealArray());


            System.out.println("Wartosci rzeczywiste");
            printArray(output.getData());
            System.out.println("Rozpoznano " + outputArrayToString(output.getData(), hashMapParser));


        }
    }

    public String resolveArrayToString(double[] letter) {
        double[] outPut = new double[17];
        network.compute(letter, outPut);
        HashMapParser hashMapParser = new HashMapParser();
        hashMapParser.initializeStringToArrayHashMap();
        return outputArrayToString(outPut, hashMapParser);

    }


    private void printArray(double[] tab) {
        for (double v : tab) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    private BasicNetwork getBasicNetwork() {
        BasicNetwork network = new BasicNetwork();
        network.addLayer(new BasicLayer(null, true, 100));
        network.addLayer(new BasicLayer(new ActivationSigmoid(), true, 58));
        network.addLayer(new BasicLayer(new ActivationSigmoid(), false, 16));
        network.getStructure().finalizeStructure();

        network.reset();
        return network;
    }


    private String outputArrayToString(double[] outputArray, HashMapParser hashMapParser) {

        double max = 0;

        int maxId = outputArray.length - 1;
        for (int i = 0; i < outputArray.length; i++) {
            if (outputArray[i] > max) {
                maxId = i;
                max = outputArray[i];
            }
        }

        hashMapParser.initializeIntCodeToStringHashMap();
        return hashMapParser.intCodeToString(maxId);
    }


    void shutDown() {
        Encog.getInstance().shutdown();
    }
}
