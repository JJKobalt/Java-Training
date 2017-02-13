package pl.edu.amu.bawsj.javafx.b;

import pl.edu.amu.bawsj.javafx.b.calculations.CalculationStrategy;

/**
 * Created by JanJa on 25.11.2016.
 */
public class SetSecondNumberState implements CalculatorState {

    private CalculatorModel model;


    SetSecondNumberState(CalculatorModel model) {

        this.model = model;

    }




    @Override
    public void addNumber(String number) {
        model.addToLine(number);

    }

    @Override
    public void addCalculation() {
        model.secondNumber =Double.valueOf( model.takeFromLine());
        model.firstNumber = model.calculation.calculate();
        model.calculatorState = new setCalculationState(model);
        model.calculatorState.addCalculation();

    }


    @Override
    public void perform() {
        model.secondNumber =Double.valueOf( model.takeFromLine());

        Double result = model.calculation.calculate();
        model.addToLine(result.toString());
        model.calculatorState = new CalculationFinishedState(model);

    }



}
