package pl.edu.amu.bawsj.javafx.b;

import pl.edu.amu.bawsj.javafx.b.calculations.CalculationStrategy;

/**
 * Created by JanJa on 30.11.2016.
 */
class setCalculationState implements CalculatorState {



    private CalculatorModel model;

    setCalculationState(CalculatorModel model) {


        this.model = model;
    }


    @Override
    public void addNumber(String number) {
        model.flushLine();
        model.calculatorState = new SetSecondNumberState(model);
        model.calculatorState.addNumber(number);
    }

    @Override
    public void addCalculation() {
        model.flushLine();
    }


    @Override
    public void perform() {
        model.secondNumber = model.firstNumber;

        model.flushLine();
        Double result = model.calculation.calculate();
        model.addToLine(result.toString());
        model.calculatorState = new CalculationFinishedState(model);


    }
}
