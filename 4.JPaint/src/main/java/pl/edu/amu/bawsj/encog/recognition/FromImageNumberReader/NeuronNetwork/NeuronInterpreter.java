package pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.NeuronNetwork;

import java.io.*;

import org.encog.Encog;
import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;
import org.encog.persist.EncogDirectoryPersistence;

/**
 * Created by JanJa on 08.01.2017.
 */
public class NeuronInterpreter {


    BasicNetwork network ;
    final String FILENAME = "NeuralNetwork.txt";

    public NeuronInterpreter() {
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
        } while (train.getError() > 0.01);

        System.out.println("Training Finished");
        double e = network.calculateError(trainingSet);
        System.out.println("Network trained to error: " + e);
        EncogDirectoryPersistence.saveObject(new File(FILENAME), network);
    }



    private MLDataSet setTrainingResources() {
        TrainingMaterialProvider trainingMaterialProvider = new TrainingMaterialProvider();


        double TrainingInput[][] = trainingMaterialProvider.getTrainingInput();
        double TrainingOutput[][] = trainingMaterialProvider.getTrainingOutput();

        return new BasicMLDataSet(TrainingInput, TrainingOutput);
    }

    private BasicNetwork getBasicNetwork() {
        BasicNetwork network = new BasicNetwork();
        network.addLayer(new BasicLayer(null, true, 100));
        network.addLayer(new BasicLayer(new ActivationSigmoid(), true, 75));
        network.addLayer(new BasicLayer(new ActivationSigmoid(), false, 16));
        network.getStructure().finalizeStructure();

        network.reset();
        return network;
    }

    public String resolveArrayToString(double[] letter) {
        double[] outPut = new double[17];
        network.compute(letter, outPut);
        HashMapParser hashMapParser = new HashMapParser();

        return outputArrayToString(outPut, hashMapParser);

    }





    private String outputArrayToString(double[] outputArray, HashMapParser hashMapParser) {


        int maxId = findIndexOfTheBiggestValue(outputArray);
        return hashMapParser.intCodeToString(maxId);
    }

    private int findIndexOfTheBiggestValue(double[] outputArray) {
        double max = 0;

        int maxId=-1;
        for (int i = 0; i < outputArray.length; i++) {
            if (outputArray[i] > max) {
                maxId = i;
                max = outputArray[i];
            }
        }
        return maxId;
    }




    void shutDown() {
        Encog.getInstance().shutdown();
    }
}
