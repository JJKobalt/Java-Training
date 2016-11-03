package pl.edu.amu.bawsj.junit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MovingAverage {

    // SOLID, a raczej literka L się kłania. List<Double> data = new ArrayList<>();
    private ArrayList<Double> data = new ArrayList<>();
    private int windowSize;

    MovingAverage(int windowSize) {
        this.windowSize = windowSize;
    }

    public void push(double val) {
        this.data.add(Double.valueOf(val));
    } // Bezsensu. Niepotrzebny Boxing zmiennej

    public double getAvg() {
        this.checkIfWindowIsBigEnough(); // po co this?
        List<Double> usedData = this.getWindowList();
        return this.calculateAvg(usedData);
    }

    private void checkIfWindowIsBigEnough() {
        if(this.data.size() < this.windowSize) {
            throw new IllegalStateException("window is too big");
        }
    }


    private List<Double> getWindowList() {
        return this.data.subList(this.data.size() - this.windowSize, this.data.size());
    }

    private double calculateAvg(List<Double> data) {
        double sum = 0.0D;

        double x;
        for(Iterator<Double> var4 = data.iterator(); var4.hasNext(); sum += x) {
            x = (var4.next()).doubleValue();
        }

        return sum / (double)data.size();
    }




}
