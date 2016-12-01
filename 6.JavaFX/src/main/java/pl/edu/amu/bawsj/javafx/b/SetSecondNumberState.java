package pl.edu.amu.bawsj.javafx.b;

import pl.edu.amu.bawsj.javafx.b.calculations.CalculationStrategy;

/**
 * Created by JanJa on 25.11.2016.
 */
public class SetSecondNumberState implements CalculatorState {

    private CalculatorModel model;
    private CalculatorPresenter presenter;

    SetSecondNumberState(CalculatorModel model, CalculatorPresenter presenter) {

        this.model = model;
        this.presenter = presenter;
    }


    @Override
    public void addNumber(String number) {
        model.addToLine(number);

    }

    @Override
    public void addCalculation() {
        model.secondNumber =Double.valueOf( model.takeFromLine());
        model.firstNumber = presenter.calculation.calculate();
        presenter.calculatorState = new setCalculationState(model, presenter);
        presenter.calculatorState.addCalculation();

    }


    @Override
    public void perform() {
        model.secondNumber =Double.valueOf( model.takeFromLine());

        Double result = presenter.calculation.calculate();
        model.addToLine(result.toString());
        presenter.calculatorState = new CalculationFinishedState(model, presenter);

    }



}
