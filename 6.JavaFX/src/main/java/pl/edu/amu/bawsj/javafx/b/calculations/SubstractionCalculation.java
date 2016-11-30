package pl.edu.amu.bawsj.javafx.b.calculations;

import pl.edu.amu.bawsj.javafx.b.CalculatorModel;

/**
 * Created by JanJa on 01.12.2016.
 */
public class SubstractionCalculation implements CalculationStrategy {

    private CalculatorModel model;

    public SubstractionCalculation(CalculatorModel model) {
        this.model = model;
        model.addToLine("-");
    }



    @Override
    public double calculate() {
        return model.getFirstNumber() - model.getSecondNumber();
    }
}
