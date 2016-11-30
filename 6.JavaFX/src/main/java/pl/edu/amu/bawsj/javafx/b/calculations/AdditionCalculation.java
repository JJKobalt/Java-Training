package pl.edu.amu.bawsj.javafx.b.calculations;

import pl.edu.amu.bawsj.javafx.b.CalculatorModel;

/**
 * Created by JanJa on 30.11.2016.
 */
public class AdditionCalculation implements CalculationStrategy {

    private CalculatorModel model;


    public AdditionCalculation(CalculatorModel model)
    {
        this.model = model;
        this.model.addToLine("+");
    }


    @Override
    public double calculate() {

       return model.getFirstNumber() + model.getSecondNumber();
    }
}
