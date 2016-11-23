package pl.edu.amu.bawsj.refactoring.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class B {

    private BufferedReader reader;
    private double avg;
    String fileName = "gold.csv";

    B(BufferedReader reader) {
        this.reader = reader;
    }

    B() {
    }

    public static void main(String[] args) {
        B b = new B();

        b.initializeReader(b.fileName);

        try {
            System.out.println(b.GetMaxLineAvg());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    double GetMaxLineAvg() throws IOException {
        avg = Double.MIN_VALUE;
        String s;
        while ((s = reader.readLine()) != null) {

            String[] split = s.split(",");
           double lineAvg =  getAvgOfLine(split);
            CompereWithPreviousBest(lineAvg);
        }
        return avg;
    }

    private void CompereWithPreviousBest(double avgOfLine) {
        avg = Math.max(avg, avgOfLine);

    }

    double getAvgOfLine(String[] split) {
        return (Double.parseDouble(split[1]) + Double.parseDouble(split[2]) + Double
                .parseDouble(split[3])) / 3.0;
    }

    private void initializeReader(String fileName) {
        InputStream inputStream = B.class.getClassLoader().getResourceAsStream(fileName);
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }


}
