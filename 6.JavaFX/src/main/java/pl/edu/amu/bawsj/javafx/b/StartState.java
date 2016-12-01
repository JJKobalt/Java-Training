package pl.edu.amu.bawsj.javafx.b;

/**
 * Created by JanJa on 01.12.2016.
 */
class StartState implements CalculatorState {

    private CalculatorModel model;
    private CalculatorPresenter presenter;

    StartState(CalculatorModel model, CalculatorPresenter presenter) {
        this.model = model;
        this.presenter = presenter;
    }

    @Override
    public void addNumber(String number) {
        model.flushLine();
        presenter.calculatorState= new SetFirstNumberState(model,presenter);
        presenter.calculatorState.addNumber(number);

    }

    @Override
    public void addCalculation() {
        System.err.println("Nothing will happen");
    }

    @Override
    public void perform() {
        System.err.println("Nothing will happen");
    }
}
