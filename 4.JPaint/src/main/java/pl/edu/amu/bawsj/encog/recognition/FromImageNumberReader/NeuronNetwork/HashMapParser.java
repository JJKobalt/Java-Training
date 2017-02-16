package pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.NeuronNetwork;

import java.util.HashMap;

/**
 * Created by JanJa on 08.01.2017.
 */
public class HashMapParser {

    private HashMap<String, double[]> stringToArrayHashMap;
    private HashMap<Integer, String> outputIntCodeToStringHashMap;

    public HashMapParser() {
        initializeStringToArrayHashMap();
        initializeIntCodeToStringHashMap();
    }

  private   void initializeStringToArrayHashMap() {
        stringToArrayHashMap = new HashMap<>();
        stringToArrayHashMap.put("0", new double[]{1.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0});
        stringToArrayHashMap.put("1", new double[]{0.0, 1.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0});
        stringToArrayHashMap.put("2", new double[]{0.0, 0.0, 1.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0});
        stringToArrayHashMap.put("3", new double[]{0.0, 0.0, 0.0, 1.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0});
        stringToArrayHashMap.put("4", new double[]{0.0, 0.0, 0.0, 0.0, 1.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0});
        stringToArrayHashMap.put("5", new double[]{0.0, 0.0, 0.0, 0.0, 0.0,
                1.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0});
        stringToArrayHashMap.put("6", new double[]{0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 1.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0});
        stringToArrayHashMap.put("7", new double[]{0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 1.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0});
        stringToArrayHashMap.put("8", new double[]{0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 1.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0});
        stringToArrayHashMap.put("9", new double[]{0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 1.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0});
        stringToArrayHashMap.put("+", new double[]{0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                1.0, 0.0, 0.0, 0.0, 0.0,
                0.0});
        stringToArrayHashMap.put("-", new double[]{0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 1.0, 0.0, 0.0, 0.0,
                0.0});
        stringToArrayHashMap.put("*", new double[]{0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 1.0, 0.0, 0.0,
                0.0});
        stringToArrayHashMap.put(":", new double[]{0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 1.0, 0.0,
                0.0});
        stringToArrayHashMap.put("/", new double[]{0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 1.0,
                0.0});
        stringToArrayHashMap.put("=", new double[]{0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0,
                1.0});

    }

  private   void initializeIntCodeToStringHashMap() {
        outputIntCodeToStringHashMap = new HashMap<>();
        outputIntCodeToStringHashMap.put(0, "0");
        outputIntCodeToStringHashMap.put(1, "1");
        outputIntCodeToStringHashMap.put(2, "2");
        outputIntCodeToStringHashMap.put(3, "3");
        outputIntCodeToStringHashMap.put(4, "4");
        outputIntCodeToStringHashMap.put(5, "5");
        outputIntCodeToStringHashMap.put(6, "6");
        outputIntCodeToStringHashMap.put(7, "7");
        outputIntCodeToStringHashMap.put(8, "8");
        outputIntCodeToStringHashMap.put(9, "9");
        outputIntCodeToStringHashMap.put(10, "+");
        outputIntCodeToStringHashMap.put(11, "-");
        outputIntCodeToStringHashMap.put(12, "*");
        outputIntCodeToStringHashMap.put(13, ":");
        outputIntCodeToStringHashMap.put(14, "/");
        outputIntCodeToStringHashMap.put(15, "=");

    }

    public String intCodeToString(int i) {
        if (outputIntCodeToStringHashMap == null) initializeStringToArrayHashMap();

        return outputIntCodeToStringHashMap.get(i);
    }


    public double[] StringOutputToArray(String s) {


        if (stringToArrayHashMap == null) initializeStringToArrayHashMap();
       // System.out.println(" stringToArrayHashMap " +stringToArrayHashMap.get(s));
        return stringToArrayHashMap.get(s);


    }
}
