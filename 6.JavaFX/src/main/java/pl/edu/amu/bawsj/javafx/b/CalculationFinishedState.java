package pl.edu.amu.bawsj.javafx.b;

/**
 * Created by JanJa on 30.11.2016.
 */
class CalculationFinishedState implements CalculatorState {

    private CalculatorModel model;
    private CalculatorPresenter presenter;

    CalculationFinishedState(CalculatorModel model, CalculatorPresenter presenter) {
        this.model = model;
        this.presenter = presenter;
    }

    @Override
    public void addNumber(String number) {
        presenter.calculatorState = new SetFirstNumberState(model, presenter);
        model.flushLine();
        presenter.calculatorState.addNumber(number);
    }

    @Override
    public void addCalculation() {
        presenter.calculatorState = new SetFirstNumberState(model, presenter);
        presenter.calculatorState.addCalculation();
    }

    @Override
    public void perform() {
        model.firstNumber=Double.valueOf(model.line.getValueSafe());

        model.flushLine();
        Double result = presenter.calculation.calculate();
        model.addToLine(result.toString());


    }
}
