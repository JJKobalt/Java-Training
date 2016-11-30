package pl.edu.amu.bawsj.javafx.b;

import pl.edu.amu.bawsj.javafx.b.calculations.CalculationStrategy;
import sun.rmi.runtime.Log;

/**
 * Created by JanJa on 25.11.2016.
 */
public class SetFirstNumberState implements CalculatorState {


    private CalculatorModel model;
    private CalculatorPresenter presenter;

    SetFirstNumberState(CalculatorModel model, CalculatorPresenter presenter) {

        this.model = model;
        this.presenter = presenter;
    }

    @Override
    public void addNumber(String number) {
        model.addToLine(number);
    }

    @Override
    public void addCalculation() {
        model.firstNumberComplete();
        presenter.calculatorState = new setCalculationState(model,presenter);
    }


    @Override
    public void perform() {
     System.err.print("Perform in firstState");
    }
}
