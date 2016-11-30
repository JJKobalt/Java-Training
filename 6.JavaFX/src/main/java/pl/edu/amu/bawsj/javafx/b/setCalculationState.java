package pl.edu.amu.bawsj.javafx.b;

import pl.edu.amu.bawsj.javafx.b.calculations.CalculationStrategy;

/**
 * Created by JanJa on 30.11.2016.
 */
class setCalculationState implements CalculatorState {


    private CalculatorPresenter presenter;
    private CalculatorModel model;

    setCalculationState(CalculatorModel model, CalculatorPresenter presenter) {

        this.presenter = presenter;
        this.model = model;
    }


    @Override
    public void addNumber(String number) {
        model.flushLine();
        presenter.calculatorState = new SetSecondNumberState(model, presenter);
        presenter.calculatorState.addNumber(number);
    }

    @Override
    public void addCalculation() {
        model.flushLine();
    }


    @Override
    public void perform() {
        model.secondNumber = model.firstNumber;

        model.flushLine();
        Double result = presenter.calculation.calculate();
        model.addToLine(result.toString());
        presenter.calculatorState = new CalculationFinishedState(model, presenter);


    }
}
