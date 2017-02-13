package pl.edu.amu.bawsj.javafx.b;

import pl.edu.amu.bawsj.javafx.b.calculations.CalculationStrategy;
import sun.rmi.runtime.Log;

/**
 * Created by JanJa on 25.11.2016.
 */
public class SetFirstNumberState implements CalculatorState {


    private CalculatorModel model;


    SetFirstNumberState(CalculatorModel model) {

        this.model = model;

    }

    @Override
    public void addNumber(String number) {

        model.addToLine(number);
    }

    @Override
    public void addCalculation() {
        model.firstNumber = Double.valueOf( model.takeFromLine());
        model.calculatorState = new setCalculationState(model);
    }


    @Override
    public void perform() {
        System.err.println("Nothing will happen");
    }
}
